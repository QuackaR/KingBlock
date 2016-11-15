package de.krien.games.kingblock.controller.input;

import com.badlogic.gdx.InputProcessor;

public class PlayerInputProcessor implements InputProcessor {

	private boolean moveUp = false;
	private boolean moveDown = false;
	private boolean moveLeft = false;
	private boolean moveRight = false;

	@Override
	public boolean keyDown(int keycode) {
		if (keycode == ControlConfiguration.getMoveUpKey()) {
			moveUp = true;
		}
		if (keycode == ControlConfiguration.getMoveDownKey()) {
			moveDown = true;
		}
		if (keycode == ControlConfiguration.getMoveLeftKey()) {
			moveLeft = true;
		}
		if (keycode == ControlConfiguration.getMoveRightKey()) {
			moveRight = true;
		}
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		if (keycode == ControlConfiguration.getMoveUpKey()) {
			moveUp = false;
		}
		if (keycode == ControlConfiguration.getMoveDownKey()) {
			moveDown = false;
		}
		if (keycode == ControlConfiguration.getMoveLeftKey()) {
			moveLeft = false;
		}
		if (keycode == ControlConfiguration.getMoveRightKey()) {
			moveRight = false;
		}

		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isMoveUp() {
		return moveUp;
	}

	public boolean isMoveDown() {
		return moveDown;
	}

	public boolean isMoveLeft() {
		return moveLeft;
	}

	public boolean isMoveRight() {
		return moveRight;
	}

}
