package de.krien.games.kingblock.model;

import com.badlogic.gdx.math.Vector2;

public interface IClickableEntity{
	
	void clicked(Vector2 clickPosition, IEntityList entityList);

}
