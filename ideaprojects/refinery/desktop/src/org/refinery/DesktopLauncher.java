package org.refinery;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) throws IOException {
		System.out.println("Hello World!");
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		config.setWindowedMode(800, 800);
		config.setTitle("refinery");
		File gconfigf = new File("./game/settings.json");
		if (gconfigf.exists()) {
			Scanner scanner = new Scanner(gconfigf);
			String gconfigs = scanner.nextLine();
			while (scanner.hasNextLine()) {
				gconfigs+=scanner.nextLine();
			}
			JSONObject gconfig = new JSONObject(gconfigs);
			boolean isFullscreen = gconfig.getBoolean("fullscreen");
			if (isFullscreen) {
				config.setFullscreenMode(config.getDisplayMode());
			}
		}else {
			File gamedir = new File("./game");
			if (!gamedir.exists()) {
				gamedir.mkdirs();
			}
			gconfigf.createNewFile();
		}
		new Lwjgl3Application(new Launcher(), config);
	}
}
