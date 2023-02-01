package org.refinery.Util;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Input implements KeyListener {

    private Boolean[] pressed;

    public Input(){
        pressed = new Boolean[110];
    }

    public Boolean ispressed(int keycode){
        return pressed[keycode];
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        pressed[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        pressed[e.getKeyCode()] = false;
    }
}
