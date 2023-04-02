package org.refinery.Ground;

import org.refinery.Util.GameObject.Ground;
import org.refinery.Util.Position;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Grass extends Ground {
    private BufferedImage texture;
    public Grass(Position position) {
        super(position);
        try {
            texture = ImageIO.read(new File("src/main/resources/textures/grass.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public BufferedImage getSprite() {
        BufferedImage image = new BufferedImage(100,100,BufferedImage.TYPE_INT_RGB);
        Graphics2D g = image.createGraphics();

        g.drawImage(texture,0,0,null);
        g.setColor(Color.BLACK);
        g.drawRect(0,0,100,100);
        return image;
    }
}
