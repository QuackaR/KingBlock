package de.krien.games.kingblock.util.game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.physics.box2d.World;

import de.krien.games.kingblock.controller.gamestates.EGameState;
import de.krien.games.kingblock.controller.gamestates.game.Game;
import de.krien.games.kingblock.controller.input.PlayerInputProcessor;

public class GameUtil {

	public static Game getGame() {
		return ((Game) (EGameState.GAME.getScreen()));
	}
	
	public static World getWorld() {
		return getGame().getWorld();
	}
	
	public static OrthographicCamera getCamera() {
		return getGame().getCamera().getCamera();
	}
	
	public static PlayerInputProcessor getPlayerInputProcessor() {
		return getGame().getInputProcessor();
	}


}
