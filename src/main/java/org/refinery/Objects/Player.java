package org.refinery.Objects;

import org.refinery.Util.*;
import org.refinery.Util.GameObject.GameObject;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player extends GameObject {
    private Position position;
    private Velocity v;
    public Input input;
    private util util;
    public int minx = 0;
    public int maxx = 0;
    public int miny = 1000;
    public int maxy = 1000;
    public int trycount = 0;
    private ArrayList gos = new ArrayList();


    public Player(Input input, Position p, Size s, Velocity v){
        super("player");
        this.input = input;
        this.position = p;
        this.s = s;
        this.v = v;
        maxx = 1000;
        maxy = 1000;
        minx = 0;
        miny = 0;
        util = new util();
    }
    @Override
    public void update() {
        v.setPosition(position);
        v.setVelocityy(v.getVelocityy() + 1);
        v.update();
        position = v.getPosition();
        if (position.getX() > (maxx - s.getWidth())) {v.setVelocityx((v.getVelocityx() * -1) + Integer.signum(v.getVelocityx()));}
        if (position.getX() < minx) {v.setVelocityx((v.getVelocityx() * -1) + Integer.signum(v.getVelocityx()));}
        if (position.getY() > (maxy - s.getHeight())) {
            position.setY(maxy - s.getHeight());
            v.setVelocityy(((v.getVelocityy()) * -1)  + (Integer.signum(v.getVelocityy())*4));
            v.setVelocityx(v.getVelocityx() - (Long.signum(v.getVelocityx())));
        }
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
