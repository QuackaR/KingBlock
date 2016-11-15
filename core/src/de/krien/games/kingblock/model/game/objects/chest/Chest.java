package de.krien.games.kingblock.model.game.objects.chest;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;

import de.krien.games.kingblock.model.game.AGameEntity;
import de.krien.games.kingblock.util.box2d.BodyUtil;
import de.krien.games.kingblock.util.texture.AssetUtil;

public class Chest extends AGameEntity{

	public Chest() {
		super();
		this.texture = AssetUtil.loadGameEntityTexture(EChestModels.MILITARY_CHEST_01);
		this.body = BodyUtil.createRectangle(new Vector2(500, 500), new Vector2(texture.getWidth(), texture.getHeight()), BodyType.StaticBody, true);
	}
	
	
}
