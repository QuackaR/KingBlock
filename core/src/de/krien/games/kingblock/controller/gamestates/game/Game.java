package de.krien.games.kingblock.controller.gamestates.game;

import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;

import de.krien.games.kingblock.controller.gamestates.EGameState;
import de.krien.games.kingblock.controller.input.PlayerInputProcessor;
import de.krien.games.kingblock.model.game.AGameEntity;
import de.krien.games.kingblock.model.game.GameEntities;
import de.krien.games.kingblock.model.ui.AUIEntity;
import de.krien.games.kingblock.model.ui.UIEntities;

public class Game implements Screen {

	/* Temporary Debugging Objects */
	Box2DDebugRenderer debugRenderer = new Box2DDebugRenderer();
	/* Temporary Debugging Objects */

	private World world;
	private Camera camera;
	private SpriteBatch spriteBatch;

	public Game() {
		world = new World(new Vector2(0, 0), true);
		camera = new Camera();
		spriteBatch = new SpriteBatch();
	}

	@Override
	public void show() {
	}

	@Override
	public void render(float delta) {
		update();
		draw();
	}

	private void update() {
		float timeSinceLastGameLoop = Gdx.graphics.getDeltaTime();
		world.step(timeSinceLastGameLoop, 6, 2); // TODO What are velocity and
													// position iterations for?
		camera.update(GameEntities.INSTANCE.getPlayer().getPosition());
		updateGameEntities(timeSinceLastGameLoop);
		updateUIEntities(timeSinceLastGameLoop);
	}

	private void updateGameEntities(float timeSinceLastGameLoop) {
		List<AGameEntity> gameEntities = GameEntities.INSTANCE.getEntityList();
		for (int i = 0; i < gameEntities.size(); i++) {
			gameEntities.get(i).update(timeSinceLastGameLoop);
		}
	}

	private void updateUIEntities(float timeSinceLastGameLoop) {
		List<AUIEntity> uiEntities = UIEntities.INSTANCE.getEntityList();
		for (int i = 0; i < uiEntities.size(); i++) {
			uiEntities.get(i).update(timeSinceLastGameLoop);
		}
	}

	private void draw() {
		camera.clear();
		drawGameEntities();
		drawUIEntities();
		camera.draw();
	}

	private void drawGameEntities() {
		List<AGameEntity> gameEntities = GameEntities.INSTANCE.getEntityList();
		for (int i = 0; i < gameEntities.size(); i++) {
			gameEntities.get(i).draw(spriteBatch);
		}
		debugRenderer.render(world, camera.getCamera().combined);
	}

	private void drawUIEntities() {
		Matrix4 normalProjection = new Matrix4().setToOrtho2D(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		spriteBatch.setProjectionMatrix(normalProjection);
		spriteBatch.begin();
		List<AUIEntity> uiEntities = UIEntities.INSTANCE.getEntityList();
		for (int i = 0; i < uiEntities.size(); i++) {
			uiEntities.get(i).draw(spriteBatch);
		}
		spriteBatch.end();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void hide() {
	}

	@Override
	public void dispose() {
	}

	public World getWorld() {
		return world;
	}

	public Camera getCamera() {
		return camera;
	}

	public PlayerInputProcessor getInputProcessor() {
		return (PlayerInputProcessor) EGameState.GAME.getInputProcessor();
	}
}
