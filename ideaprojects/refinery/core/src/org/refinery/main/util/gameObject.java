package org.refinery.main.util;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public abstract class gameObject {
    protected Texture texture;
    protected Vector2 position, velocity, size;
    public gameObject(Texture sprite, Vector2 position, Vector2 size) {
        this.texture = sprite;
        this.position = position;
        this.size = size;
        this.velocity = new Vector2(0, 0);
    }

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture sprite) {
        this.texture = sprite;
    }

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public Vector2 getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector2 velocity) {
        this.velocity = velocity;
    }

    public void draw(SpriteBatch batch) {
        batch.draw(texture, position.x, position.y, size.x, size.y);
        position.add(velocity);
    }

    public abstract void update();
}
