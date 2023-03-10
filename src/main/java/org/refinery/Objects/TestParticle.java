package org.refinery.Objects;

import org.refinery.Util.GameObject.GameObject;
import org.refinery.Util.List.GOlist;
import org.refinery.Util.Position;
import org.refinery.Util.Size;
import org.refinery.Util.Velocity;
import org.refinery.Util.util;

import java.awt.*;
import java.awt.image.BufferedImage;

public class TestParticle extends GameObject {

    private util util = new util();

    public TestParticle() {
        super("Particle");
        setSize(new Size(10,10));
        setPosition(new Position(util.randomint(2000, true),100));
        setVelocity(new Velocity(getPosition(),0,0));
    }

    @Override
    public void update(int screenwidth, int screenheight, GOlist GameObjects) {
        getVelocity().update();
        getVelocity().setVelocityy(getVelocity().getVelocityy()+1);
        setPosition(v.getPosition());
        for(int i = 0; i < GameObjects.size(); i++) {
            GameObject obj = GOlist.get(i);
            if (util.distanceto(getPosition(), obj.getPosition())<100){
                int dx = getPosition().getX() - obj.getPosition().getX();
                int dy = getPosition().getY() - obj.getPosition().getY();
                getVelocity().setVelocityx(getVelocity().getVelocityx()-Integer.signum(dx));
                getVelocity().setVelocityy(getVelocity().getVelocityy()-Integer.signum(dy));
            }
            if (util.distanceto(getPosition(), obj.getPosition())<50){
                int dx = getPosition().getX() - obj.getPosition().getX();
                int dy = getPosition().getY() - obj.getPosition().getY();
                getVelocity().setVelocityx(getVelocity().getVelocityx()+Integer.signum(dx));
                getVelocity().setVelocityy(getVelocity().getVelocityy()+Integer.signum(dy));
            }
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
