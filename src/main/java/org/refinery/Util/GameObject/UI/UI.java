package org.refinery.Util.GameObject.UI;

import org.refinery.Util.Input;
import org.refinery.Util.Position;
import org.refinery.Util.Size;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class UI {
    protected Size size;
    protected Position position,labelpos;
    protected Boolean visible;

    public UI(){
        //Default settings for a UI element
        size = new Size(200,50);
        position = new Position(0,0);
        visible = true;
    }

    public abstract void asMouseOver();
    public abstract void asMouseDown();
    public abstract void asMouseAway();
    public abstract void asMouseUp();
    public abstract BufferedImage getSprite();

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
    public Boolean Visible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }
}