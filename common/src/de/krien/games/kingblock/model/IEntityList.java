package de.krien.games.kingblock.model;

import java.util.List;

public interface IEntityList {

	public List<? extends IEntity> getEntityList();
	public void addEntity(IEntity entity);
	public void removeEntity(IEntity entity);
	
}
