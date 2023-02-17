package org.refinery.Util;

public class Position {
    private int x, y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int distanceTo(Position p1, Position p2) {
        return (int) Math.sqrt((p1.getX() - p2.getX())^2 + (p1.getY() - p2.getY())^2);
    }
}
