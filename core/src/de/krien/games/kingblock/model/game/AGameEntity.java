package de.krien.games.kingblock.model.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;

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
    	spriteBatch.draw(texture, body.getPosition().x, body.getPosition().y);
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

}
