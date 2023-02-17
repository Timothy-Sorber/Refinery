package org.refinery.Objects;

import org.refinery.Util.GameObject.GameObject;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Particle extends GameObject {
    public Particle() {
        super("PARTICLE");
    }

    @Override
    public void update() {

    }

    @Override
    public Image getSprite() {
        BufferedImage i = new BufferedImage(s.getWidth(), s.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g = i.createGraphics();
        g.setColor(Color.BLUE);
        g.fillOval(0,0, s.getWidth(), s.getHeight());
        g.dispose();
        return i;
    }
}
