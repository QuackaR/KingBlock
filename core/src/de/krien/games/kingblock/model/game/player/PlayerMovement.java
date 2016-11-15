package de.krien.games.kingblock.model.game.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

import de.krien.games.kingblock.controller.gamestates.EGameState;
import de.krien.games.kingblock.controller.gamestates.game.Game;

public class PlayerMovement {

	public static void movePlayer(Player player) {
		if (getGame().getInputProcessor().isMoveRight()) {
			player.getBody().setLinearVelocity(new Vector2(50.0f, player.getBody().getLinearVelocity().y));
		}
		if (getGame().getInputProcessor().isMoveLeft()) {
			player.getBody().setLinearVelocity(new Vector2(-50.0f, player.getBody().getLinearVelocity().y));
		}
		if (getGame().getInputProcessor().isMoveRight() && getGame().getInputProcessor().isMoveLeft()
				|| !getGame().getInputProcessor().isMoveRight() && !getGame().getInputProcessor().isMoveLeft()) {
			player.getBody().setLinearVelocity(new Vector2(0, player.getBody().getLinearVelocity().y));
		}
		if (getGame().getInputProcessor().isMoveUp()) {
			player.getBody().setLinearVelocity(new Vector2(player.getBody().getLinearVelocity().x, 50.0f));
		}
		if (getGame().getInputProcessor().isMoveDown()) {
			player.getBody().setLinearVelocity(new Vector2(player.getBody().getLinearVelocity().x, -50.0f));
		}
		if (getGame().getInputProcessor().isMoveUp() && getGame().getInputProcessor().isMoveDown()
				|| !getGame().getInputProcessor().isMoveUp() && !getGame().getInputProcessor().isMoveDown()) {
			player.getBody().setLinearVelocity(new Vector2(player.getBody().getLinearVelocity().x, 0));
		}
	}
	
	public static void rotatePlayer(Player player) {
		Vector3 cursorPosition3 = new Vector3(Gdx.input.getX(), (Gdx.graphics.getHeight() - Gdx.input.getY()), 0);
		cursorPosition3 = getGame().getCamera().getCamera().unproject(cursorPosition3);
		Vector2 cursorPosition = new Vector2(cursorPosition3.x, cursorPosition3.y);
		float radians = getDirectionInRadians(player.getBody().getPosition(), cursorPosition);
		player.getBody().setTransform(player.getBody().getPosition(), radians - (float) Math.PI / 2);
	}
	
	private static float getDirectionInRadians(Vector2 playerCenterPosition, Vector2 mousePosition) {
		float radians = (float) Math.atan2(
				mousePosition.x - playerCenterPosition.x,
				mousePosition.y - playerCenterPosition.y
		);
		return radians;
	}
	
	private static Game getGame() {
		return ((Game) (EGameState.GAME.getScreen()));
	}
	
}
