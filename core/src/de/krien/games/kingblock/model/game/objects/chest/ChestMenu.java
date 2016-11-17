package de.krien.games.kingblock.model.game.objects.chest;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import de.krien.games.kingblock.model.ui.UIEntities;
import de.krien.games.kingblock.model.ui.menu.ContextMenu;
import de.krien.games.kingblock.model.ui.menu.IContextMenuEntry;
import de.krien.games.kingblock.util.texture.AssetUtil;

public class ChestMenu extends ContextMenu {
	
	private ContextMenu parent = this;
	private Texture texture;

	public ChestMenu(Vector2 position, Texture texture) {
		super();
		this.texture = texture;
		this.position = position;
		initContextMenuEntries();
		this.size = new Vector2(DEFAULT_WIDTH, DEFAULT_HEIGHT * entries.size());
	}

	private void initContextMenuEntries() {
		this.entries = new ArrayList<>();
		createCloseMenuEntry();
		createOpenChestEntry();
	}

	private void createOpenChestEntry() {
		IContextMenuEntry open = new IContextMenuEntry() {

			@Override
			public void run() {
				System.out.println("Open Chest-Option clicked!");
				texture.load(AssetUtil.loadGameEntityTexture(EChestModels.MILITARY_CHEST_02).getTextureData());
				UIEntities.INSTANCE.removeEntity(parent);
			}

			@Override
			public String getText() {
				return "Open Chest";
			}
		};
		entries.add(open);
	}

	private void createCloseMenuEntry() {
		IContextMenuEntry close = new IContextMenuEntry() {

			@Override
			public void run() {
				System.out.println("Close-Option clicked!");
				UIEntities.INSTANCE.removeEntity(parent);
			}

			@Override
			public String getText() {
				return "Close";
			}
		};

		entries.add(close);
	}
}
