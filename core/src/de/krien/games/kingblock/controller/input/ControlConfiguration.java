package de.krien.games.kingblock.controller.input;

import com.badlogic.gdx.Input.Keys;

public class ControlConfiguration {

	private static final int DEFAULT_MOVE_UP_KEY = Keys.W;
	private static final int DEFAULT_MOVE_DOWN_KEY = Keys.S;
	private static final int DEFAULT_MOVE_LEFT_KEY = Keys.A;
	private static final int DEFAULT_MOVE_RIGHT_KEY = Keys.D;

	private static int moveUpKey = DEFAULT_MOVE_UP_KEY;
	private static int moveDownKey = DEFAULT_MOVE_DOWN_KEY;
	private static int moveLeftKey = DEFAULT_MOVE_LEFT_KEY;
	private static int moveRightKey = DEFAULT_MOVE_RIGHT_KEY;

	public static int getMoveUpKey() {
		return moveUpKey;
	}

	public static void setMoveUpKey(int moveUpKey) {
		ControlConfiguration.moveUpKey = moveUpKey;
	}

	public static int getMoveDownKey() {
		return moveDownKey;
	}

	public static void setMoveDownKey(int moveDownKey) {
		ControlConfiguration.moveDownKey = moveDownKey;
	}

	public static int getMoveLeftKey() {
		return moveLeftKey;
	}

	public static void setMoveLeftKey(int moveLeftKey) {
		ControlConfiguration.moveLeftKey = moveLeftKey;
	}

	public static int getMoveRightKey() {
		return moveRightKey;
	}

	public static void setMoveRightKey(int moveRightKey) {
		ControlConfiguration.moveRightKey = moveRightKey;
	}

}
