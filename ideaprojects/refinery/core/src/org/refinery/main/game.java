package org.refinery.main;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import org.refinery.main.objects.player;
import org.refinery.main.util.gameObject;

import java.util.ArrayList;

public class game {
    private ArrayList<gameObject> gameObjects = new ArrayList<>();
    private SpriteBatch batch;

    public game(SpriteBatch batch) {
        this.batch = batch;
        gameObjects.add(new player());
    }
    public void update() {
        for (gameObject gameObject : gameObjects) {
            gameObject.update();
            gameObject.draw(batch);
        }
    }
}
