package org.refinery.Util.GameObject;

import org.refinery.Util.Position;
import org.refinery.Util.Size;
import org.refinery.Util.Velocity;

import java.awt.*;

public abstract class GameObject {
    protected Position p;
    protected Velocity v;
    protected Size s;
    public static String type;

    public GameObject(String type) {
        p = new Position(50, 50);
        s = new Size(100, 100);
        v = new Velocity(p,0,0);
        this.type = type;
    }

    public abstract void update();
    public abstract Image getSprite();
    public static String getObject(){
        return type;
    }

    public Position getPosition() {
        return p;
    }

    public Size getSize() {
        return s;
    }

    public void setPosition(Position p) {
        this.p = p;
    }
}
