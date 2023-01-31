package org.refinery.Objects;

import org.refinery.Util.GameObject.GameObject;
import org.refinery.Util.GameObject.Position;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends GameObject {
    @Override
    public void update() {
        p = new Position(p.getX()+1,p.getY());
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
