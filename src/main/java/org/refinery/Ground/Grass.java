package org.refinery.Ground;

import org.refinery.Util.GameObject.Ground;
import org.refinery.Util.Position;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Grass extends Ground {
    public Grass(Position position) {
        super(position);
    }

    @Override
    public BufferedImage getSprite() {
        BufferedImage image = new BufferedImage(100,100,BufferedImage.TYPE_INT_RGB);
        Graphics2D g = image.createGraphics();

        g.setColor(new Color(0,255,100));
        g.fillRect(0,0,100,100);
        g.setColor(Color.BLACK);
        g.drawRect(0,0,100,100);
        return image;
    }
}
