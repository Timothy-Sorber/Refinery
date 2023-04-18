package org.refinery.Items;

import org.refinery.Util.Item.Item;

import java.awt.*;
import java.awt.image.BufferedImage;

public class TestItem extends Item {
    public TestItem(int amount) {
        super("test item", amount, 32);
    }

    @Override
    public BufferedImage getSprite() {
        BufferedImage image = new BufferedImage(10,10,BufferedImage.TYPE_INT_RGB);
        Graphics2D g = image.createGraphics();
        g.setColor(Color.yellow);
        g.fillRect(0,0,10,10);
        return image;
    }

    @Override
    public void onUse() {

    }
}
