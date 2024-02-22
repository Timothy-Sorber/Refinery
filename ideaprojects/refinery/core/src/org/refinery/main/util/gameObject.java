package org.refinery.main.util;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public abstract class gameObject {
    public Texture texture;
    public Vector2 position, velocity, size, bound1, bound2;
    public boolean collidable = false;
    public gameObject(Texture sprite, Vector2 position, Vector2 size) {
        this.texture = sprite;
        this.position = position;
        this.size = size;
        this.velocity = new Vector2(0, 0);
        bound1 = new Vector2(0, 0);
        bound2 = new Vector2(1, 1);
    }

    public void draw(SpriteBatch batch) {
        batch.draw(texture, position.x, position.y, size.x, size.y);
        position.add(velocity);
    }

    public abstract void update();
}
