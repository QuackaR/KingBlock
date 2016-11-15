package de.krien.games.kingblock.controller.input;

import com.badlogic.gdx.InputProcessor;

public class PlayerInputProcessor implements InputProcessor {

	private boolean moveUp = false;
	private boolean moveDown = false;
	private boolean moveLeft = false;
	private boolean moveRight = false;

	private boolean zoomIn = false;
	private boolean zoomOut = false;

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
		if (keycode == ControlConfiguration.getZoomInKey()) {
			zoomIn = true;
		}
		if (keycode == ControlConfiguration.getZoomOutKey()) {
			zoomOut = true;
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
		if (keycode == ControlConfiguration.getZoomInKey()) {
			zoomIn = false;
		}
		if (keycode == ControlConfiguration.getZoomOutKey()) {
			zoomOut = false;
		}
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
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

	public void setMoveUp(boolean moveUp) {
		this.moveUp = moveUp;
	}

	public boolean isMoveDown() {
		return moveDown;
	}

	public void setMoveDown(boolean moveDown) {
		this.moveDown = moveDown;
	}

	public boolean isMoveLeft() {
		return moveLeft;
	}

	public void setMoveLeft(boolean moveLeft) {
		this.moveLeft = moveLeft;
	}

	public boolean isMoveRight() {
		return moveRight;
	}

	public void setMoveRight(boolean moveRight) {
		this.moveRight = moveRight;
	}

	public boolean isZoomIn() {
		return zoomIn;
	}

	public void setZoomIn(boolean zoomIn) {
		this.zoomIn = zoomIn;
	}

	public boolean isZoomOut() {
		return zoomOut;
	}

	public void setZoomOut(boolean zoomOut) {
		this.zoomOut = zoomOut;
	}

}
