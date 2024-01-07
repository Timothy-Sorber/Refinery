package org.refinery;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import org.refinery.main.game;

public class Launcher extends ApplicationAdapter {
	private SpriteBatch batch;
	private Texture texture;
	private OrthographicCamera camera;
	private game game;

	@Override
	public void create () {
		camera = new OrthographicCamera();
		camera.setToOrtho(false);
		batch = new SpriteBatch();
		texture = new Texture("textures/grass.jpg");
		game = new game(batch);
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);

		if (Gdx.input.isKeyJustPressed(Input.Keys.F11)) {
			boolean fullscreen = Gdx.graphics.isFullscreen();
			if (fullscreen) {
				Gdx.graphics.setWindowedMode(800, 800);
			}else{
				Gdx.graphics.setFullscreenMode(Gdx.graphics.getDisplayMode());
			}
		}
		if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
			Gdx.app.exit();
		}

		camera.update();
		batch.setProjectionMatrix(camera.combined);

		batch.begin();

		game.update();
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
