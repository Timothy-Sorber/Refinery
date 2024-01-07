package org.refinery;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;

import org.refinery.main.game;
import org.refinery.main.objects.player;

public class Launcher extends ApplicationAdapter {
	private SpriteBatch batch;
	private Texture texture;
	private OrthographicCamera camera;
	private game game;
	private player player;

	@Override
	public void create () {
		camera = new OrthographicCamera();
		camera.setToOrtho(false);
		batch = new SpriteBatch();
		texture = new Texture("textures/grass.jpg");
		game = new game(batch);
		player = game.getPlayer();
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

		float dx = camera.position.x - player.position.x;
		float dy = camera.position.y - player.position.y;

		camera.translate(-dx/10, -dy/10);

		camera.update();
		batch.setProjectionMatrix(camera.combined);

		batch.begin();

		for (int x=0; x<50; x++) {
			for (int y=0; y<50; y++) {
				batch.draw(texture, x*128, y*128);
			}
		}

		game.update();
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
