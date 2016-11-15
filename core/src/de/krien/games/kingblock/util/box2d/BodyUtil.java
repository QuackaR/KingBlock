package de.krien.games.kingblock.util.box2d;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;

import de.krien.games.kingblock.util.game.GameUtil;

public class BodyUtil {

	// TODO ggf. density, friction und restitution übergeben
	public static Body createCircle(Vector2 position, float size, BodyType bodyType, boolean fixedRotation) {
		BodyDef bodyDef = new BodyDef();
		bodyDef.type = bodyType;
		bodyDef.position.set(position);
		Body body = GameUtil.getGame().getWorld().createBody(bodyDef);
		body.setFixedRotation(fixedRotation);

		CircleShape circle = new CircleShape();
		circle.setRadius(size/2);

		FixtureDef fixtureDef = new FixtureDef();
		fixtureDef.shape = circle;
		fixtureDef.density = 0.5f;
		fixtureDef.friction = 0.4f;
		fixtureDef.restitution = 0.0f;

		body.createFixture(fixtureDef);
		circle.dispose();
		return body;
	}

	public static Body createRectangle(Vector2 position, Vector2 size, BodyType bodyType, boolean fixedRotation) {
		BodyDef bodyDef = new BodyDef();
		bodyDef.type = bodyType;
		bodyDef.position.set(position);
		Body body = GameUtil.getGame().getWorld().createBody(bodyDef);
		body.setFixedRotation(fixedRotation);

		PolygonShape rectangle = new PolygonShape();
		rectangle.setAsBox(size.x/2, size.y/2);

		FixtureDef fixtureDef = new FixtureDef();
		fixtureDef.shape = rectangle;
		fixtureDef.density = 0.5f;
		fixtureDef.friction = 0.4f;
		fixtureDef.restitution = 0.0f;

		body.createFixture(fixtureDef);
		rectangle.dispose();
		return body;
	}

}
