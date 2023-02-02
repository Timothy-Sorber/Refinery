package org.refinery.Util;

public class Velocity {
    public Position p;
    public int vx;
    public int vy;

    public Velocity(Position p, int vx, int vy) {
        this.p = p;
        this.vx = vx;
        this.vy = vy;
    }

    public void update(){
        p = new Position(p.getX()+vx, p.getY()+vy);
    }

    public int getVelocityx() {
        return vx;
    }

    public void setVelocityx(int vx) {
        this.vx = vx;
    }

    public int getVelocityy() {
        return vy;
    }

    public void setVelocityy(int vy) {
        this.vy = vy;
    }

    public Position getPosition() {
        return p;
    }

    public void setPosition(Position p) {
        this.p = p;
    }
}
