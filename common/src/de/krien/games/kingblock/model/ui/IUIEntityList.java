package de.krien.games.kingblock.model.ui;

import java.util.List;

import de.krien.games.kingblock.model.IEntityList;

public interface IUIEntityList extends IEntityList{

	public List<AUIEntity> getEntityList();
	public void addEntity(AUIEntity entity);
	public void removeEntity(AUIEntity entity);

}
