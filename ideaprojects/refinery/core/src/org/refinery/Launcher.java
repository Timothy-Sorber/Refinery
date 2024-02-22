package org.refinery;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import org.refinery.main.game;
import org.refinery.main.objects.player;
import org.refinery.main.util.gameInput;

public class Launcher extends ApplicationAdapter {
	private SpriteBatch batch;
	private Texture texture;
	private OrthographicCamera camera;
	private game game;
	private player player;
	private gameInput input;
	private Viewport viewport;
	public static Launcher instance;

	@Override
	public void create () {
		instance = this;
		camera = new OrthographicCamera();
		camera.setToOrtho(false);
		batch = new SpriteBatch(8191);
		texture = new Texture("textures/grass.jpg");
		game = new game(batch, camera);
		player = game.player;
		camera.zoom = 1;
		viewport = new FitViewport(2000, 2000, camera);
		input = new gameInput();
		Gdx.input.setInputProcessor(input);
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

		camera.zoom+=(input.wheelDelta/10)*camera.zoom;
		//camera.zoom = Math.min(camera.zoom,10);

		input.wheelDelta = 0;

		float dx = camera.position.x - (player.position.x+player.size.x/2);
		float dy = camera.position.y - (player.position.y+player.size.y/2);

		camera.translate(-dx/2, -dy/2);

		camera.update();
		batch.setProjectionMatrix(camera.combined);

		batch.begin();

		game.update();
		batch.end();

		gameInput.mouseClicked = false;
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}

	@Override
	public void resize(int width, int height) {
		viewport.setWorldSize(width, height);
		viewport.update(width, height);
	}
}
