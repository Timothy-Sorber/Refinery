package org.refinery.Objects;

import org.refinery.Input;
import org.refinery.Util.GameObject.GameObject;
import org.refinery.Util.Position;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends GameObject {
    private Position position;
    public Input input;

    public Player(Input input){
        super();
        this.input = input;
        this.position = getPosition();
    }
    @Override
    public void update() {
        int deltaX = 0;
        int deltaY = 0;
        position = new Position(position.getX()+1, position.getY()+0);
        setPosition(position);
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
