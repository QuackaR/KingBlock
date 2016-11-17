package de.krien.games.kingblock.model.game.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;

import de.krien.games.kingblock.model.game.AGameEntity;
import de.krien.games.kingblock.util.box2d.BodyUtil;
import de.krien.games.kingblock.util.game.GameUtil;
import de.krien.games.kingblock.util.texture.AssetUtil;

public class Player extends AGameEntity {

	private final static Vector2 DEFAULT_POSITION = new Vector2(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
	
	public Player() {
		super();
		this.texture = AssetUtil.loadGameEntityTexture(EPlayerModels.DEFAULT);
		body = BodyUtil.createCircle(GameUtil.getWorld(), DEFAULT_POSITION, texture.getWidth(), BodyType.DynamicBody, true);
	}


	@Override
	public void update(float timeSinceLastGameLoop) {
		PlayerMovement.movePlayer(this);
		PlayerMovement.rotatePlayer(this);
	}

//	@Override
//	public void draw(SpriteBatch spriteBatch) {
		// spriteBatch.begin();
		// spriteBatch.
		// spriteBatch.draw(
		// playerMovement.getCurrentFrame(),
		// playerMovement.getPosition().x,
		// playerMovement.getPosition().y
		// );
		// spriteBatch.end();
		// ShapeRenderer shapeRenderer = new ShapeRenderer();
		// shapeRenderer.setProjectionMatrix(spriteBatch.getProjectionMatrix());
		// shapeRenderer.begin(ShapeType.Filled);
		// shapeRenderer.setColor(Color.RED);
		// shapeRenderer.rect(body.getPosition().x, body.getPosition().y, 5, 5);
		// shapeRenderer.end();
//	}




}
