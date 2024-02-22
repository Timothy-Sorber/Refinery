package org.refinery.main.util;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;
import org.refinery.main.game;

public class gameInput implements InputProcessor {
    public static boolean[] keys;
    public static boolean mouseDown = false, mouseClicked = false;
    public static int mouseX, mouseY;
    public static float mouseWorldX, mouseWorldY;
    public static float wheelDelta;
    public gameInput() {
        keys = new boolean[145];
    }
    @Override
    public boolean keyDown(int keycode) {
        keys[keycode] = true;
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        keys[keycode] = false;
        return true;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        OrthographicCamera camera = game.camera;
        mouseX = screenX;
        mouseY = screenY;
        Vector3 worldPos = camera.unproject(new Vector3(screenX, screenY, 0));
        mouseWorldX = worldPos.x;
        mouseWorldY = worldPos.y;

        mouseDown = true;
        mouseClicked = true;

        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {

        mouseDown = false;

        return true;
    }

    @Override
    public boolean touchCancelled(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        OrthographicCamera camera = game.camera;
        mouseX = screenX;
        mouseY = screenY;
        Vector3 worldPos = camera.unproject(new Vector3(screenX, screenY, 0));
        mouseWorldX = worldPos.x;
        mouseWorldY = worldPos.y;
        return true;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        wheelDelta = amountY;
        return true;
    }
}
