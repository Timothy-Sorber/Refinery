package org.refinery.Ground;

import org.refinery.Util.GameObject.Ground;
import org.refinery.Util.Position;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Grass extends Ground {
    private BufferedImage image;
    public Grass() {
        super(new Position(0, 0));
        image = new BufferedImage(50,50,BufferedImage.TYPE_INT_RGB);
        Graphics2D g = image.createGraphics();

        g.setColor(Color.green);
        g.fillRect(0,0,image.getWidth(),image.getHeight());

        g.setColor(Color.BLACK);
        g.drawRect(0,0,50,50);
    }

    @Override
    public BufferedImage getSprite() {
        return image;
    }
}
