package org.refinery.UI;

import org.refinery.Util.GameObject.UI;
import org.refinery.Util.Size;

import java.awt.*;
import java.awt.image.BufferedImage;

public class loadingScreen extends UI {
    private BufferedImage image;
    private Graphics2D graphics;
    public loadingScreen(Size size){
        setSize(size);
        setVisible(true);
        image = new BufferedImage(size.getWidth(),size.getHeight(), BufferedImage.TYPE_INT_RGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.lightGray);
        graphics.drawRect(0,0,image.getWidth(),image.getHeight());
        graphics.setColor(Color.BLACK);
        graphics.drawString("Please wait while the game loads the mods :)", size.getWidth()/2, size.getHeight()/2);
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
        return image;
    }
}
