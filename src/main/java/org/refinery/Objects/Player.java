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
    private int movey,movex;
    public Player(Input input){
        super("Player");
        setPosition(new Position(100,100));
        setSize(new Size(50,50));
        this.input = input;
        color = new Color(0,0,255);
    }

    @Override
    public void update(int screenwidth, int screenheight, GOlist GameObjects) {
        int x = getPosition().getX();
        int y = getPosition().getY();
        if (movey<0&&!input.ispressed(87)){movey++;}
        if (movey>0&&!input.ispressed(83)){movey--;}
        if (movex<0&&!input.ispressed(65)){movex++;}
        if (movex>0&&!input.ispressed(68)){movex--;}
        if (input.ispressed(68)&&movex<20){
            //move left
            movex++;
        }
        if (input.ispressed(65)&&movex>-20){
            //move right
            movex--;
        }
        if (input.ispressed(87)&&movey>-20){
            //move up
            movey--;
        }
        if (input.ispressed(83)&&movey<20){
            //move down
            movey++;
        }
        y+=movey;
        x+=movex;
        setPosition(new Position(x,y));
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
