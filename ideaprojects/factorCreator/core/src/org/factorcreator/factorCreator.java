package org.factorcreator;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import org.factorcreator.main.button;
import org.factorcreator.main.buttons.createMod;

public class factorCreator extends ApplicationAdapter {
	private Viewport viewport;
	private SpriteBatch batch;
	private Camera camera;
	private button[] buttons;

	
	@Override
	public void create() {
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		viewport = new FitViewport(800, 800, camera);
		buttons = new button[]{new createMod(340, 700)};
	}

	@Override
	public void render() {
		ScreenUtils.clear(0.3f, 0.3f, 0.3f, 1);
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		for (button button : buttons) {
			batch.draw(button.texture, -120, 100, 240, 80);
		}
		batch.end();
	}
	
	@Override
	public void dispose() {
		batch.dispose();
	}

	@Override
	public void resize(int width, int height) {
		viewport.setWorldSize(width, height);
		viewport.update(width, height);
	}
}
