package de.krien.games.kingblock.model.game.objects.chest;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.World;

import de.krien.games.kingblock.model.IClickableEntity;
import de.krien.games.kingblock.model.game.AGameEntity;
import de.krien.games.kingblock.model.ui.UIEntities;
import de.krien.games.kingblock.model.ui.menu.ContextMenu;
import de.krien.games.kingblock.util.box2d.BodyUtil;
import de.krien.games.kingblock.util.texture.AssetUtil;

public class Chest extends AGameEntity implements IClickableEntity {

	private ContextMenu contextMenu;

	public Chest(World world) {
		super();
		this.texture = AssetUtil.loadGameEntityTexture(EChestModels.MILITARY_CHEST_01);
		this.body = BodyUtil.createRectangle(world, new Vector2(500, 500),
				new Vector2(texture.getWidth(), texture.getHeight()), BodyType.StaticBody, true);
	}

	@Override
	public void clicked(Vector2 clickPosition) {
		if (contextMenu != null) {
			UIEntities.INSTANCE.removeEntity(contextMenu);
		}
		this.contextMenu = new ChestMenu(clickPosition, texture);
		UIEntities.INSTANCE.addEntity(contextMenu);
	}

}
