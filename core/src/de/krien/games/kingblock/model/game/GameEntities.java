package de.krien.games.kingblock.model.game;

import java.util.ArrayList;
import java.util.List;

import de.krien.games.kingblock.model.game.objects.chest.Chest;
import de.krien.games.kingblock.model.game.player.Player;

public enum GameEntities {

	INSTANCE();

	private List<AGameEntity> entityList;
	private Player player;

	private GameEntities() {
		entityList = new ArrayList<>();
		player = new Player();
		addEntity(player);
		addEntity(new Chest());
	}

	public List<AGameEntity> getEntityList() {
		return entityList;
	}

	public void setEntityList(List<AGameEntity> entityList) {
		this.entityList = entityList;
	}

	public void addEntity(AGameEntity entity) {
		entityList.add(entity);
	}

	public void removeEntity(AGameEntity entity) {
		entityList.remove(entity);
	}

	public Player getPlayer() {
		return player;
	}

}
