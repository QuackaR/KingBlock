package de.krien.games.kingblock.util.game;

import de.krien.games.kingblock.controller.gamestates.EGameState;
import de.krien.games.kingblock.controller.gamestates.game.Game;

public class GameUtil {

	public static Game getGame() {
		return ((Game) (EGameState.GAME.getScreen()));
	}

}
