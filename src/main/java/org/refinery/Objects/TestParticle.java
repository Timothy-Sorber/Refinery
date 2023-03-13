package org.refinery.Objects;

import org.refinery.Util.GameObject.GameObject;
import org.refinery.Util.List.GOlist;
import org.refinery.Util.Position;
import org.refinery.Util.Size;
import org.refinery.Util.Velocity;
import org.refinery.Util.util;
import org.refinery.game.Game;

import java.awt.*;
import java.awt.image.BufferedImage;

public class TestParticle extends GameObject {

    private util util = new util();

    public TestParticle() {
        super("Particle");
        setSize(new Size(50,50));
        setPosition(new Position(util.randomint(2000, true),100));
        setVelocity(new Velocity(getPosition(),0,0));
    }

    @Override
    public void update(int screenwidth, int screenheight, GOlist GameObjects, Game game) {
        int x = getPosition().getX();
        int y = getPosition().getY();
        for (int i=0; i<GameObjects.size(); i++) {
            GameObject obj = GOlist.get(i);
            int dx = x-obj.getPosition().getX();
            int dy = y-obj.getPosition().getY();
            setPosition(new Position(x-(dx/5),y-(dy/5)));
        }
    }

    @Override
    public Image getSprite() {
        BufferedImage i = new BufferedImage(getSize().getWidth(), getSize().getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g = i.createGraphics();
        g.setColor(Color.blue);
        g.fillOval(0,0, i.getWidth(), i.getHeight());
        g.dispose();
        return i;
    }
}
