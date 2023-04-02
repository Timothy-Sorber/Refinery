package org.refinery.Machines;

import org.refinery.Util.GameObject.Machine;
import org.refinery.Util.Position;
import org.refinery.Util.Size;

import java.awt.*;
import java.awt.image.BufferedImage;

public class TestMachine extends Machine {
    public TestMachine(Position position) {
        super("test machine", position, new Size(3,3), 2);
    }

    @Override
    public BufferedImage getSprite() {
        BufferedImage image = new BufferedImage(getSize().getWidth()*100, getSize().getHeight()*100, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = image.createGraphics();
        g.setColor(Color.GRAY);
        g.fillRect(0, 0, image.getWidth(), image.getHeight());
        return image;
    }

    @Override
    public void update() {

    }
}
