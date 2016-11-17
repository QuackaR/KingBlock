package de.krien.games.kingblock.model.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;

import de.krien.games.kingblock.controller.gamestates.EGameState;
import de.krien.games.kingblock.controller.gamestates.game.Game;
import de.krien.games.kingblock.model.IEntity;

public class AGameEntity implements IEntity {

	protected Body body;
	protected Texture texture;

    public AGameEntity() {
    }

    @Override
    public void update(float timeSinceLastGameLoop) {
    }

    @Override
    public void draw(SpriteBatch spriteBatch) {
		spriteBatch.setProjectionMatrix(((Game) (EGameState.GAME.getScreen())).getCamera().getCamera().combined);
		spriteBatch.begin();
    	spriteBatch.draw(new TextureRegion(texture), body.getPosition().x-(texture.getWidth()/2), body.getPosition().y-(texture.getHeight()/2), texture.getWidth()/2, texture.getHeight()/2, texture.getWidth(), texture.getHeight(), 1, 1, MathUtils.radiansToDegrees*body.getAngle());
		spriteBatch.end();
    }
    
	public Body getBody() {
		return body;
	}
	
	public Texture getTexture() {
		return texture;
	}

    public float getAngle() {
        return body.getAngle();
    }

	@Override
	public Vector2 getPosition() {
		return body.getPosition();
	}

	@Override
	public Vector2 getSize() {
		return new Vector2(texture.getWidth(), texture.getHeight());
	}	

}
