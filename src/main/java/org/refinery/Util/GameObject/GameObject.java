package org.refinery.Util.GameObject;

import java.awt.*;

public abstract class GameObject {
    protected Position p;
    protected Size s;

    public GameObject() {
        p = new Position(50, 50);
        s = new Size(100, 100);
    }

    public abstract void update();
    public abstract Image getSprite();

    public Position getPosition() {
        return p;
    }

    public Size getSize() {
        return s;
    }
}
