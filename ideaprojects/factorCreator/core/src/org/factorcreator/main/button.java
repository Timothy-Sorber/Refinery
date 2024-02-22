package org.factorcreator.main;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public abstract class button {
    public Texture texture;
    public Vector2 position, size;

    public button(Texture texture, int x, int y, int width, int height) {
        this.texture = texture;
        this.position = new Vector2(x, y);
        this.size = new Vector2(width, height);
    }

    public abstract void onClick();
}
