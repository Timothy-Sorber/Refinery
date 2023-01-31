package org.refinery.Objects;

import org.refinery.Controller;
import org.refinery.Input;
import org.refinery.PlayerController;
import org.refinery.Util.GameObject.GameObject;
import org.refinery.Util.GameObject.Position;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends GameObject {

    private Controller controller;
    private Position position;

    public Player(Controller controller){
        super();
        this.controller = controller;
    }
    @Override
    public void update() {
        int deltaX = 0;
        int deltaY = 0;

        if (controller.iru()){
            deltaY--;
        }
        if (controller.ird()){
            deltaY++;
        }
        if (controller.irl()){
            deltaX--;
        }
        if (controller.irr()){
            deltaX++;
        }
        position = new Position(position.getX()+deltaX, position.getY()+deltaY);
    }

    @Override
    public Image getSprite() {
        BufferedImage i = new BufferedImage(s.getWidth(), s.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g = i.createGraphics();
        g.setColor(Color.BLUE);
        g.fillRect(0,0, s.getWidth(), s.getHeight());
        g.dispose();
        return i;
    }
}
