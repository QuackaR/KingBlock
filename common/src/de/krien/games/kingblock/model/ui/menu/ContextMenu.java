package de.krien.games.kingblock.model.ui.menu;

import java.util.List;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;

import de.krien.games.kingblock.model.IClickableEntity;
import de.krien.games.kingblock.model.IEntityList;
import de.krien.games.kingblock.model.ui.AUIEntity;
import de.krien.games.kingblock.model.ui.IUIEntityList;

public class ContextMenu extends AUIEntity implements IClickableEntity {

	private static final int MENU_OFFSET_Y = -25;
	private static final int MENU_OFFSET_X = 15;
	protected final static float DEFAULT_WIDTH = 100;
	protected final static float DEFAULT_HEIGHT = 25;
	protected final static Color DEFAULT_TEXT_COLOR = Color.BLACK;

	protected Vector2 size;
	protected List<IContextMenuEntry> entries;
	protected IUIEntityList entityList;

	private BitmapFont font;
	private GlyphLayout layout;
	private ShapeRenderer shapeRenderer;

	public ContextMenu(IUIEntityList entityList) {
		super();
		this.font = new BitmapFont();
		font.setColor(DEFAULT_TEXT_COLOR);
		this.layout = new GlyphLayout();
		this.shapeRenderer = new ShapeRenderer();
		shapeRenderer.setColor(Color.GRAY);
		this.entityList = entityList;
		entityList.addEntity(this);
	}
	
	public ContextMenu(IUIEntityList entityList, Vector2 position, List<IContextMenuEntry> entries) {
		super();
		this.position = position;
		this.size = new Vector2(DEFAULT_WIDTH, DEFAULT_HEIGHT * entries.size());
		this.entries = entries;

		this.font = new BitmapFont();
		font.setColor(DEFAULT_TEXT_COLOR);
		this.layout = new GlyphLayout();
		this.shapeRenderer = new ShapeRenderer();
		shapeRenderer.setColor(Color.GRAY);
		this.entityList = entityList;
		entityList.addEntity(this);
	}

	@Override
	public void draw(SpriteBatch spriteBatch, Matrix4 projectionMatrix) {
		drawMenu(projectionMatrix);
		drawText(spriteBatch, projectionMatrix);
	}

	private void drawMenu(Matrix4 projectionMatrix) {
		shapeRenderer.setProjectionMatrix(projectionMatrix);
		shapeRenderer.begin(ShapeType.Line);
		for (int i = 0; i < entries.size(); i++) {
			float sizeY = size.y / entries.size();
			float offsetY = (i-1) * sizeY;
			shapeRenderer.rect(position.x, position.y - offsetY, size.x, sizeY);
		}
		shapeRenderer.end();
	}

	private void drawText(SpriteBatch spriteBatch, Matrix4 projectionMatrix) {
		spriteBatch.setProjectionMatrix(projectionMatrix);
		spriteBatch.begin();
		for (int i = 0; i < entries.size(); i++) {
			String entry = entries.get(i).getText();
			Vector2 position = getEntryPosition(i);
			font.draw(spriteBatch, entry, position.x, position.y);
		}
		spriteBatch.end();
	}

	private Vector2 getEntryPosition(int entryIndex) {
		float entryHeight = size.y / entries.size();
		float entryWidth = size.x;

		layout.setText(font, entries.get(entryIndex).getText());
		float textWidth = layout.width;
		float textHeight = layout.height;

		float positionX = position.x + (entryWidth / 2) - (textWidth / 2);
		float positionY = position.y; // + (entryHeight / 2) - (textHeight / 2);

		float offset = entryHeight * entryIndex;
		positionY = positionY - offset;

		return new Vector2(positionX, position.y);
	}

	@Override
	public void clicked(Vector2 clickPosition, IEntityList entityList) {
		float entryHeight = size.y / entries.size();
		for (int i = 0; i < entries.size(); i++) {
			float positionMin = position.y + entryHeight * i;
			float positionMax = position.y + entryHeight * (i + 1);
			if (clickPosition.y >= positionMin && clickPosition.y <= positionMax) {
				entries.get(i).run();
			}

		}
	}

	@Override
	public Vector2 getSize() {
		return size;
	}

}
