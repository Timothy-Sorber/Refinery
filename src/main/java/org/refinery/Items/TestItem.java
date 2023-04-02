package org.refinery.Items;

import org.refinery.Util.Item.Item;

import java.awt.*;
import java.awt.image.BufferedImage;

public class TestItem extends Item {
    public TestItem(int amount) {
        super("test item", amount, 30);
    }

    @Override
    public BufferedImage getSprite() {
        BufferedImage image = new BufferedImage(10,10,BufferedImage.TYPE_INT_RGB);
        Graphics2D g = image.createGraphics();
        g.setColor(Color.yellow);
        g.fillRect(0,0,10,10);
        return null;
    }

    @Override
    public void onUse() {

    }
}
