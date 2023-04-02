package org.refinery.Util.Item.Inventory;

import org.refinery.Util.GameObject.UI.UI;
import org.refinery.game.Game;

import java.awt.image.BufferedImage;

public class Inventoryviewer extends UI {
    public Inventoryviewer(Inventory inventory, Game game){
        setVisible(true);
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
        BufferedImage image = new BufferedImage(1000,1000,BufferedImage.TYPE_INT_ARGB);
        return image;
    }
}
