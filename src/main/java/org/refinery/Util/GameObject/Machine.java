package org.refinery.Util.GameObject;

import org.refinery.Util.Position;
import org.refinery.Util.Size;

import java.awt.image.BufferedImage;

public abstract class Machine{
    protected String name;
    protected Position position;
    protected Size size;
    protected boolean Placed;
    public Machine(String name, Position position, Size size) {
        this.name = name;
        this.position = snap(position);
        this.size = size;
        Placed = true;
    }

    public abstract BufferedImage getSprite();
    public abstract void update();
    public Position getPosition() {
        return new Position(position.getX()/50, position.getY()/50);
    }
    public void setPosition(Position position){
        this.position = snap(position);
    }

    public String getName() {
        return name;
    }

    private Position snap(Position pos){
        pos.setX(pos.getX()*50);
        pos.setY(pos.getY()*50);
        return pos;
    }
    public Size getSize() {
        return size;
    }
    public boolean isPlaced() {
        return Placed;
    }

    public void setPlaced(boolean placed) {
        Placed = placed;
    }
}
