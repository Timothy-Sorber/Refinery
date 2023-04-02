package org.refinery.Util.GameObject;

import org.refinery.Util.Item.Inventory.Inventory;
import org.refinery.Util.Item.Item;
import org.refinery.Util.Position;
import org.refinery.Util.Size;

import java.awt.image.BufferedImage;

public abstract class Machine{
    protected String name;
    protected Position position;
    protected Size size;
    protected Inventory inventory;
    public Machine(String name, Position position, Size size, int Invsize) {
        this.name = name;
        this.position = snap(position);
        this.size = size;
        inventory = new Inventory(name, Invsize);
    }

    public abstract BufferedImage getSprite();
    public abstract void update();

    public Item getItem(int index) {
        return inventory.get(index);
    }
    public void setItem(int index, Item item) {
        inventory.setItem(index, item);
    }
    public Position getPosition() {
        return new Position(position.getX()/100, position.getY()/100);
    }
    public void setPosition(Position position){
        this.position = snap(position);
    }
    public Inventory getInventory() {
        return inventory;
    }

    public String getName() {
        return name;
    }

    private Position snap(Position pos){
        pos.setX(pos.getX()*100);
        pos.setY(pos.getY()*100);
        return pos;
    }
    public Size getSize() {
        return size;
    }
}
