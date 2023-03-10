package org.refinery.Objects;

import org.refinery.Util.util;
import org.refinery.Util.GameObject.GameObject;
import org.refinery.Util.Input;
import org.refinery.Util.List.GOlist;
import org.refinery.Util.Position;
import org.refinery.Util.Size;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends GameObject {
    private Input input;
    public Color color;
    private util util = new util();
    public Player(Input input){
        super("Player");
        setPosition(new Position(100,100));
        setSize(new Size(50,50));
        this.input = input;
        color = new Color(0,0,255);
    }

    @Override
    public void update(int screenwidth, int screenheight, GOlist GameObjects) {
        if (input.ispressed(68)){
            //move left
            setPosition(new Position(getPosition().getX()+10, getPosition().getY()));
        }
        if (input.ispressed(65)){
            //move right
            setPosition(new Position(getPosition().getX()-10, getPosition().getY()));
        }
        if (input.ispressed(87)){
            //move up
            setPosition(new Position(getPosition().getX(), getPosition().getY()-10));
        }
        if (input.ispressed(83)){
            //move down
            setPosition(new Position(getPosition().getX(), getPosition().getY()+10));
        }
        color = new Color(util.randomint(255,false), util.randomint(255,false), util.randomint(255,false));
    }

    @Override
    public Image getSprite() {
        BufferedImage i = new BufferedImage(getSize().getWidth(), getSize().getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g = i.createGraphics();
        g.setColor(color);
        g.fillRect(0, 0, i.getWidth()/4, i.getHeight()/4);
        g.fillRect(i.getWidth()-(i.getWidth()/4), 0, i.getWidth(), i.getHeight()/4);
        g.fillRect(0, i.getHeight()-(i.getHeight()/4), i.getWidth(), i.getHeight());
        g.dispose();
        return i;
    }
}
