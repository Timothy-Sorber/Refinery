package org.refinery.Util.Item.Inventory;

import org.refinery.Util.GameObject.UI.UI;
import org.refinery.Util.Item.Item;
import org.refinery.Util.Position;
import org.refinery.Util.Size;
import org.refinery.game.Game;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Inventoryviewer extends UI {
    private Game game;
    private Inventory inv;
    public Inventoryviewer(Inventory inventory, Game game) {
        setVisible(true);
        setSize(new Size(800,800));
        this.game = game;
        inv=inventory;
    }
    @Override
    public void asMouseOver() {

    }

    @Override
    public void asMouseDown() {

    }

    @Override
    public void asMouseAway() {

    }

    @Override
    public void asMouseUp() {

    }

    @Override
    public BufferedImage getSprite() {
        BufferedImage image = new BufferedImage(800,800,BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = image.createGraphics();
        setPosition(new Position(
                (game.getW().getWidth()/2)-getSize().getWidth()/2,
                (game.getW().getHeight()/2)-getSize().getHeight()/2
        ));
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 0, image.getWidth(), image.getHeight());
        g.setColor(Color.lightGray);
        g.fillRect(0,0,image.getWidth()-10, image.getHeight()-10);
        g.setColor(Color.GRAY);
        g.fillRect(10,10, image.getWidth()-20, image.getHeight()-20);

        return image;
    }
}
