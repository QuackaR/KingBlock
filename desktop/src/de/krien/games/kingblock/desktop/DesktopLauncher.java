package de.krien.games.kingblock.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import de.krien.games.kingblock.KingBlockGame;

public class DesktopLauncher {

    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = "King Block";
        config.width = 1280;
        config.height = 720;
        new LwjglApplication(KingBlockGame.getInstance(), config);
    }
}
