package de.krien.games.kingblock.util.texture;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import de.krien.games.kingblock.model.IEntityModel;


public class AssetUtil {

    private final static String IMAGE_TYPE = "PNG";
    
    public static Texture loadGameEntityTexture(IEntityModel model) {
        String fileName = model.getModelID() + "." + IMAGE_TYPE.toLowerCase();
        return new Texture(Gdx.files.internal(model.getType() + "/" + fileName));
    }
}
