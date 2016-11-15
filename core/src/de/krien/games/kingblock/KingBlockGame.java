package de.krien.games.kingblock;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

import de.krien.games.kingblock.controller.gamestates.EGameState;

public class KingBlockGame extends Game {
	
	private static KingBlockGame instance;
	private EGameState gameState;

	private KingBlockGame() {
    }

	public static KingBlockGame getInstance() {
		if (instance == null) {
			instance = new KingBlockGame();
		}
		return instance;
	}

	@Override
	public void create() {
		gameState = EGameState.MENU;
		setScreen(gameState.getScreen());
	}

	@Override
	public void render() {
		super.render();
	}

	@Override
	public void dispose() {

	}

	public EGameState getGameState() {
		return gameState;
	}

	public void setGameState(EGameState gameState) {
		this.gameState = gameState;
		setScreen(gameState.getScreen());
		Gdx.input.setInputProcessor(gameState.getInputProcessor());
	}
}
