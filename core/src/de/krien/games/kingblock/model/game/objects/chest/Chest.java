package de.krien.games.kingblock.model.game.objects.chest;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;

import de.krien.games.kingblock.model.IClickableEntity;
import de.krien.games.kingblock.model.game.AGameEntity;
import de.krien.games.kingblock.util.box2d.BodyUtil;
import de.krien.games.kingblock.util.texture.AssetUtil;

public class Chest extends AGameEntity implements IClickableEntity {

//	private ContextMenu contextMenu;
//	private List<IContextMenuEntry> contextMenuEntries;

	public Chest() {
		super();
		this.texture = AssetUtil.loadGameEntityTexture(EChestModels.MILITARY_CHEST_01);
		this.body = BodyUtil.createRectangle(new Vector2(500, 500), new Vector2(texture.getWidth(), texture.getHeight()), BodyType.StaticBody, true);
	}

	@Override
	public void clicked(Vector2 clickPosition) {
//		initContextMenuEntries();
//		this.contextMenu = new ContextMenu(clickPosition, contextMenuEntries);
//		UIEntities.INSTANCE.addEntity(contextMenu);
	}
	
//	private void initContextMenuEntries() {
//		IContextMenuEntry open = new IContextMenuEntry() {
//
//			@Override
//			public void run() {
//				System.out.println("Open Chest-Option clicked!");
//				texture = TextureUtil.loadGameEntityImage(EChestModels.MILITARY_CHEST_02);
//				UIEntities.INSTANCE.removeEntity(contextMenu);
//				contextMenu = null;
//			}
//
//			@Override
//			public String getText() {
//				return "Open Chest";
//			}
//		};
//		IContextMenuEntry close = new IContextMenuEntry() {
//
//			@Override
//			public void run() {
//				System.out.println("Close-Option clicked!");
//				UIEntities.INSTANCE.removeEntity(contextMenu);
//				contextMenu = null;
//			}
//
//			@Override
//			public String getText() {
//				return "Close";
//			}
//		};
//		contextMenuEntries = new ArrayList<>();
//		contextMenuEntries.add(open);
//		contextMenuEntries.add(close);
//	}

//	public ContextMenu getContextMenu() {
//		return contextMenu;
//	}
	
	
}
