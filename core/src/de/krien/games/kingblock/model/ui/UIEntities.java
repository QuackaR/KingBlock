package de.krien.games.kingblock.model.ui;

import java.util.ArrayList;
import java.util.List;

import de.krien.games.kingblock.model.IEntity;
import de.krien.games.kingblock.model.ui.stats.Stats;

public enum UIEntities implements IUIEntityList {

	INSTANCE();

	private List<AUIEntity> entityList;

	private UIEntities() {
		entityList = new ArrayList<>();

		// TMP
		Stats stats = new Stats();
		entityList.add(stats);
	}

	public List<AUIEntity> getEntityList() {
		return entityList;
	}

	public void setEntityList(List<AUIEntity> entityList) {
		this.entityList = entityList;
	}

	public void addEntity(AUIEntity entity) {
		entityList.add(entity);
	}

	public void removeEntity(AUIEntity entity) {
		entityList.remove(entity);
	}

	@Override
	public void addEntity(IEntity entity) {
		if (entity instanceof AUIEntity) {
			addEntity((AUIEntity) entity);
		}
	}

	@Override
	public void removeEntity(IEntity entity) {
		if (entity instanceof AUIEntity) {
			removeEntity((AUIEntity) entity);
		}
	}

}
