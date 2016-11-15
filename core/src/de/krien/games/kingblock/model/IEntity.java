package de.krien.games.kingblock.model;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public interface IEntity {
	
	public Vector2 getPosition();
	public void update(float timeSinceLastGameLoop);
	public void draw(SpriteBatch spriteBatch);
    
	
}
