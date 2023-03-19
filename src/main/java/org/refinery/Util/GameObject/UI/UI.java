package org.refinery.Util.GameObject.UI;

import org.refinery.Util.Input;
import org.refinery.Util.Position;
import org.refinery.Util.Size;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class UI {
    protected Size size;
    protected Position position,labelpos;
    protected Color color;
    protected String name;
    protected String label;
    protected Input input;

    public UI(String name){
        //Default settings for a UI element
        size = new Size(200,50);
        position = new Position(0,0);
        color = new Color(100,100,255);
        label = "Unlabeled";
        labelpos = new Position(0,0);
    }

    public abstract void asMouseOver();
    public abstract void asMouseDown();
    public abstract void asMouseAway();
    public abstract void asMouseUp();

    public BufferedImage getSprite(){
        BufferedImage i = new BufferedImage(size.getWidth(), size.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g = i.createGraphics();
        g.setColor(color);
        g.fillRect(0,0,size.getWidth(),size.getHeight());
        g.setColor(Color.BLACK);
        g.drawString(label, labelpos.getX(), labelpos.getY());
        g.dispose();
        return i;
    }

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

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Position getLabelpos() {
        return labelpos;
    }

    public void setLabelpos(Position labelpos) {
        this.labelpos = labelpos;
    }
}