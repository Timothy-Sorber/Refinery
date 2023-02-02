package org.refinery.Objects;

import org.refinery.Util.*;
import org.refinery.Util.GameObject.GameObject;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends GameObject {
    private Position position;
    private Velocity v;
    public Input input;
    private util util;

    public Player(Input input, Position p, Size s, Velocity v){
        super();
        this.input = input;
        this.position = p;
        this.s = s;
        this.v = v;
        util = new util();
    }
    @Override
    public void update() {
        v.setPosition(position);
        v.update();
        position = v.getPosition();
        if (position.getX() > (1000 - s.getWidth())) {v.setVelocityx(v.getVelocityx() * -1);}
        if (position.getX() < 0) {v.setVelocityx(v.getVelocityx() * -1);}
        if (position.getY() > (1000 - s.getHeight())) {v.setVelocityy(v.getVelocityy() * -1);}
        if (position.getY() < 0) {v.setVelocityy(v.getVelocityy() * -1);}
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
