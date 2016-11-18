package de.krien.games.kingblock.util.graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Matrix4;

public class ProjectionUtil {

	public static Matrix4 getNormalProjection() {
		Matrix4 normalProjection = new Matrix4().setToOrtho2D(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		return normalProjection;
	}

	
}
