package org.refinery.UI;

import org.refinery.Machines.TestMachine;
import org.refinery.Util.GameObject.UI;
import org.refinery.Util.List.GOlist;
import org.refinery.Util.Position;
import org.refinery.Util.Size;
import org.refinery.Util.util;
import org.refinery.game.Game;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Button extends UI {
    public Boolean mouseover;
    public Boolean click = false;
    public Game game;
    public util util = new util();
    public Button(GOlist GOlist, Game game) {
        super();
        setPosition(new Position(500,250));
        setSize(new Size(200,50));
        mouseover=false;
        this.game=game;
    }

    @Override
    public void asMouseOver() {
        mouseover=true;
    }

    @Override
    public void asMouseDown() {
        if (!click){
            click=true;
            game.getMachines().add(new TestMachine(new Position(0,0)));
        }
    }

    @Override
    public void asMouseAway() {
        mouseover=false;
    }

    @Override
    public void asMouseUp() {
        click=false;
    }

    @Override
    public BufferedImage getSprite() {
        BufferedImage I = new BufferedImage(getSize().getWidth(), getSize().getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = I.createGraphics();
        if (mouseover&&!click){
            g.setColor(new Color(0, 150, 255));
        }else if (mouseover&&click){
            g.setColor(Color.CYAN);
        }else {
            g.setColor(Color.BLUE);
        }
        g.fillRect(0,0, getSize().getWidth(), getSize().getHeight());
        g.setColor(Color.BLACK);
        g.drawString("Test button go BRRR", 0,20);
        g.dispose();
        return I;
    }
}
