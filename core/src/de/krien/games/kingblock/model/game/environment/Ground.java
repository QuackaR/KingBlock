package de.krien.games.kingblock.model.game.environment;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.PolygonShape;

import de.krien.games.kingblock.controller.gamestates.EGameState;
import de.krien.games.kingblock.controller.gamestates.game.Game;
import de.krien.games.kingblock.model.game.AGameEntity;

public class Ground extends AGameEntity {

    private Body body;
    
    public Ground() {
        super();
        body = createBody();
    }

    private Body createBody() {
    	BodyDef bodyDef = new BodyDef();
    	bodyDef.type = BodyType.StaticBody;
    	System.out.println(Gdx.graphics.getHeight()/2);
    	bodyDef.position.set(0,10);
    	Body body = ((Game)(EGameState.GAME.getScreen())).getWorld().createBody(bodyDef);

    	PolygonShape groundBox = new PolygonShape();
    	groundBox.setAsBox(((Game)(EGameState.GAME.getScreen())).getCamera().getCamera().viewportWidth, 10.0f);
    	body.createFixture(groundBox, 0.0f); 
    	groundBox.dispose();	
    	return body;
	}
    
	@Override
	public Vector2 getPosition() {
		return body.getPosition();
	}
	
}
