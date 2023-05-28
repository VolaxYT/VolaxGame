package fr.volax;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	private final static int width = 1280, height = 720;

	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setTitle("VolaxGame");
        config.setWindowedMode(width, height);
        config.useVsync(true);
        config.setForegroundFPS(60);
		new Lwjgl3Application(new VolaxGame(width, height), config);
	}
}
