package de.krien.games.kingblock.model;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;

public interface IEntity {
	
	public Vector2 getPosition();
	public Vector2 getSize();
	public void update(float timeSinceLastGameLoop);
	public void draw(SpriteBatch spriteBatch, Matrix4 projectionMatrix);
    
	
}
