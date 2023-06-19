package org.refinery.UI;

import org.refinery.Util.GameObject.UI;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class modViewer extends UI {
    private BufferedImage image;

    public modViewer(ArrayList<String> names){
        image = new BufferedImage(200, 1000, BufferedImage.TYPE_INT_RGB);
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
        return null;
    }
}
