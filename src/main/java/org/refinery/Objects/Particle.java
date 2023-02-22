package org.refinery.Objects;

import org.refinery.Util.Position;
import org.refinery.Util.Size;
import org.refinery.Util.Velocity;
import org.refinery.Util.util;
import org.refinery.Util.GameObject.GameObject;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Particle extends GameObject {
    private util util = new util();
    private Velocity velocity;
    private int vx = util.randomsignedint(10, false);
    private int vy = util.randomsignedint(10, false);
    private int G = 1;
    public Particle() {
        super("PARTICLE");
        setPosition(new Position(util.randomint(2000, true), util.randomint(1000, true)));
        setSize(new Size(10,10));

    }

    @Override
    public void update(int screenwidth, int screenheight, List GameObjects) {
        Position nextpos = new Position(p.getX()+vx, p.getY()+vy);
        if (nextpos.getY() < 0 || nextpos.getY() > 1000){
            destroy();
        }
        if (nextpos.getX() < 0 || nextpos.getY() > 2000){
            destroy();
        }
        setPosition(nextpos);
    }

    @Override
    public Image getSprite() {
        BufferedImage i = new BufferedImage(s.getWidth(), s.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D gr = i.createGraphics();
        gr.setColor(Color.BLUE);
        gr.fillOval(0,0, s.getWidth(), s.getHeight());
        gr.dispose();
        return i;
    }
}
