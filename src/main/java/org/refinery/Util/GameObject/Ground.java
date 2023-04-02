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
        return new Position(position.getX()/100, position.getY()/100);
    }

    public void setPosition(Position position) {
        this.position = snap(position);
    }

    private Position snap(Position pos){
        pos.setY(pos.getY()*100);
        pos.setX(pos.getX()*100);
        return pos;
    }
}
