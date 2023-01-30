package org.refinery;

import java.awt.Rectangle;

public class Game {
    private Window w;
    private Rectangle rect;

    public Game(int width, int height){
        w = new Window(width, height);
        rect = new Rectangle(0,0,100,100);
    }

    public void update(){
        rect.setLocation(rect.x + 10, rect.y);
    }

    public void render(){
        w.render(this);
    }

    public Rectangle getRect() {
        return rect;
    }
}
