package org.refinery.Util.GameObject;

import org.refinery.Util.Position;

import java.awt.image.BufferedImage;

public abstract class Ground {
    protected Position position;

    public Ground(Position position){
        this.position = snap(position);
    }

    public abstract BufferedImage getSprite();

    public Position getPosition() {
        return new Position(position.getX()/50, position.getY()/50);
    }

    public void setPosition(Position position) {
        this.position = snap(position);
    }

    private Position snap(Position pos){
        pos.setY(pos.getY()*50);
        pos.setX(pos.getX()*50);
        return pos;
    }
}
