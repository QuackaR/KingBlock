package de.krien.games.kingblock.controller.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

import de.krien.games.kingblock.controller.gamestates.EGameState;
import de.krien.games.kingblock.controller.gamestates.game.Game;
import de.krien.games.kingblock.model.IClickableEntity;
import de.krien.games.kingblock.model.IEntity;
import de.krien.games.kingblock.model.game.AGameEntity;
import de.krien.games.kingblock.model.game.GameEntities;
import de.krien.games.kingblock.model.ui.AUIEntity;
import de.krien.games.kingblock.model.ui.UIEntities;

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
		Vector2 eventPosition = new Vector2(screenX, Gdx.graphics.getHeight() - screenY);
		IEntity clickedEntity = getClickedEntity(eventPosition);
		if (clickedEntity != null && clickedEntity instanceof IClickableEntity && clickedEntity instanceof AUIEntity
				&& button == Buttons.LEFT) {
			((IClickableEntity) clickedEntity).clicked(eventPosition);
		} else if (clickedEntity != null && clickedEntity instanceof IClickableEntity
				&& clickedEntity instanceof AGameEntity && button == Buttons.RIGHT) {
			((IClickableEntity) clickedEntity).clicked(eventPosition);
		}
		return false;
	}

	private static IEntity getClickedEntity(Vector2 eventPosition) {
		for (IEntity entity : UIEntities.INSTANCE.getEntityList()) {
			if (entity.getPosition() != null && entity.getSize() != null) {
				Vector3 entityPosition3 = getCamera().project(new Vector3(entity.getPosition().x, entity.getPosition().y, 0));
				Vector2 entityPosition = new Vector2(entityPosition3.x, entityPosition3.y);
				if(eventPosition.x >= entityPosition.x
					&& eventPosition.x <= (entityPosition.x + entity.getSize().x)
					&& eventPosition.y >= entityPosition.y
					&& eventPosition.y <= (entityPosition.y + entity.getSize().y)) {
					return entity;
				}
			}
		}
		for (IEntity entity : GameEntities.INSTANCE.getEntityList()) {
			float halfSizeX = entity.getSize().x / 2;
			float halfSizeY = entity.getSize().y / 2;
			if (entity.getPosition() != null && entity.getSize() != null) {
				Vector3 entityPosition3 = getCamera().project(new Vector3(entity.getPosition().x, entity.getPosition().y, 0));
				Vector2 entityPosition = new Vector2(entityPosition3.x, entityPosition3.y);
				if (eventPosition.x >= entityPosition.x - halfSizeX 
						&& eventPosition.x <= (entityPosition.x + halfSizeX)
						&& eventPosition.y >= entityPosition.y - halfSizeY 
						&& eventPosition.y <= (entityPosition.y + halfSizeY)) {
					return entity;
				}
			}
		}
		return null;
	}
	
	private static Camera getCamera() {
		return ((Game) (EGameState.GAME.getScreen())).getCamera().getCamera();
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
