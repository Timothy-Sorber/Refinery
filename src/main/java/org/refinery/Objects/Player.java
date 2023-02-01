package org.refinery.Objects;

import org.refinery.Util.*;
import org.refinery.Util.GameObject.GameObject;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends GameObject {
    private Position position;
    public Input input;
    private util util;

    public Player(Input input){
        super();
        this.input = input;
        this.position = getPosition();
        util = new util();
    }
    @Override
    public void update() {
        int deltaX = 0;
        int deltaY = 0;
        deltaX = util.randomint(5);
        if (util.randombool()){
            deltaX = deltaX*-1;
        }
        deltaY = util.randomint(5);
        if (util.randombool()){
            deltaY = deltaY*-1;
        }
        position = new Position(position.getX()+deltaX, position.getY()+deltaY);
        setPosition(position);
    }

    @Override
    public Image getSprite() {
        BufferedImage i = new BufferedImage(s.getWidth(), s.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g = i.createGraphics();
        g.setColor(Color.BLUE);
        g.fillRect(0,0, s.getWidth(), s.getHeight());
        g.dispose();
        return i;
    }
}
