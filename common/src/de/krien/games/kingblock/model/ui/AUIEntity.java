package de.krien.games.kingblock.model.ui;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import de.krien.games.kingblock.model.IEntity;

public class AUIEntity implements IEntity {

	protected Vector2 position;
	protected Vector2 size;

	public AUIEntity() {
	}

	public void update(float timeSinceLastGameLoop) {

	}

	public void draw(SpriteBatch spriteBatch) {

	}

	@Override
	public Vector2 getPosition() {
		return position;
	}

	@Override
	public Vector2 getSize() {
		return size;
	}


}
