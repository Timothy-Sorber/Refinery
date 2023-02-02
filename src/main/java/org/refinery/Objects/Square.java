package org.refinery.Objects;

import org.refinery.Util.GameObject.GameObject;
import org.refinery.Util.Input;
import org.refinery.Util.Position;
import org.refinery.Util.util;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Square extends GameObject {
    private Position position;
    public Input input;
    private org.refinery.Util.util util;

    public Square(){
        super();
        this.position = new Position(950, 950);
        util = new util();
    }
    @Override
    public void update() {
        int deltaX = 0;
        int deltaY = 0;
        position = new Position(position.getX()-1, position.getY()-1);
        setPosition(position);
    }

    @Override
    public Image getSprite() {
        BufferedImage i = new BufferedImage(s.getWidth(), s.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g = i.createGraphics();
        g.setColor(Color.RED);
        g.fillRect(0,0, s.getWidth(), s.getHeight());
        g.dispose();
        return i;
    }
}
