package org.refinery.Util;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Vector {
    public Rotation rotation;
    public int length;
    public Position origin;

    public Vector(Rotation rotation, int length, Position origin) {
        this.rotation = rotation;
        this.length = length;
        this.origin = origin;
    }

    public Rotation getRotation() {
        return rotation;
    }

    public void setRotation(Rotation rotation) {
        this.rotation = rotation;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Position getOrigin() {
        return origin;
    }

    public void setOrigin(Position origin) {
        this.origin = origin;
    }

    public Position getEndPoint() {
        return null;
    }

    public Image Line(){
        BufferedImage Line = new BufferedImage(1000, 1000, BufferedImage.TYPE_INT_RGB);
        Graphics2D Graphics = Line.createGraphics();
        return Line;
    }
}
