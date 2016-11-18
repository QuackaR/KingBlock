package de.krien.games.kingblock.model.game;

import java.util.List;

import de.krien.games.kingblock.model.IEntityList;

public interface IGameEntityList extends IEntityList {

	public List<AGameEntity> getEntityList();
	public void addEntity(AGameEntity entity);
	public void removeEntity(AGameEntity entity);

}
