package de.krien.games.kingblock.controller.gamestates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;

import de.krien.games.kingblock.controller.gamestates.game.Game;
import de.krien.games.kingblock.controller.gamestates.menu.Menu;
import de.krien.games.kingblock.controller.gamestates.menu.Settings;
import de.krien.games.kingblock.controller.input.PlayerInputProcessor;

public enum EGameState {

	MENU(new Menu(), Gdx.input.getInputProcessor()), GAME(new Game(), new PlayerInputProcessor()), SETTINGS(new Settings(), null), EXIT(null, null);

	private Screen screen;
	private InputProcessor inputProcessor;

	EGameState(Screen screen, InputProcessor inputProcessor) {
		this.screen = screen;
		this.inputProcessor = inputProcessor;
	}

	public Screen getScreen() {
		return screen;
	}

	public InputProcessor getInputProcessor() {
		return inputProcessor;
	}

}
