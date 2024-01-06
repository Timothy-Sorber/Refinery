package org.refinery;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class Launcher extends ApplicationAdapter {
	SpriteBatch batch;
	Texture texture;
	OrthographicCamera camera;
	
	@Override
	public void create () {
		camera = new OrthographicCamera();
		camera.setToOrtho(false);
		batch = new SpriteBatch();
		texture = new Texture("textures/grass.jpg");
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);

		camera.update();
		batch.setProjectionMatrix(camera.combined);

		batch.begin();
		for (int x=0; x<20; x++) {
			for (int y = 0; y < 10; y++) {
				batch.draw(texture, x*128, y*128);
			}
		}
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
