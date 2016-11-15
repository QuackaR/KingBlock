package de.krien.games.kingblock.model.ui.stats;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import de.krien.games.kingblock.controller.gamestates.EGameState;
import de.krien.games.kingblock.controller.gamestates.game.Game;
import de.krien.games.kingblock.model.game.GameEntities;
import de.krien.games.kingblock.model.ui.AUIEntity;

public class Stats extends AUIEntity {

	private BitmapFont font;

	public Stats() {
		font = new BitmapFont();
		font.setColor(Color.RED);
	}

	@Override
	public void update(float timeSinceLastGameLoop) {
	}

	@Override
	public void draw(SpriteBatch spriteBatch) {
		drawFps(spriteBatch);
		drawCursorPosition(spriteBatch);
		drawPlayerPosition(spriteBatch);
		drawCameraZoom(spriteBatch);
	}

	private void drawFps(SpriteBatch spriteBatch) {
		font.draw(spriteBatch, "FpS: " + Gdx.graphics.getFramesPerSecond(), 5, Gdx.graphics.getHeight() - 5);
	}

	private void drawPlayerPosition(SpriteBatch spriteBatch) {
		Vector2 position = round(GameEntities.INSTANCE.getPlayer().getPosition());
		font.draw(spriteBatch, "Player Position: " + position.x + "/" + position.y, 5, Gdx.graphics.getHeight() - 25);
	}

	private void drawCursorPosition(SpriteBatch spriteBatch) {
		Vector2 cursorPosition = round(new Vector2(Gdx.input.getX(), Gdx.input.getY()));
		font.draw(spriteBatch, "Mouse Position: " + cursorPosition.x + "/" + cursorPosition.y, 5, Gdx.graphics.getHeight() - 45);
	}

	private void drawCameraZoom(SpriteBatch spriteBatch) {
		float cameraZoom = ((Game) (EGameState.GAME.getScreen())).getCamera().getCamera().zoom;
		font.draw(spriteBatch, "Camera Zoom: " + cameraZoom, 5, Gdx.graphics.getHeight() - 65);
	}

	private Vector2 round(Vector2 vector) {
		float x = Math.round(vector.x * 100f) / 100f;
		float y = Math.round(vector.y * 100f) / 100f;
		return new Vector2(x, y);
	}

}
