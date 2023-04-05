package org.refinery.Util;

import java.awt.event.*;

public class Input implements KeyListener, MouseListener, MouseMotionListener {

    private Boolean[] pressed;
    private Position PointerPosition;
    private Boolean MouseClicked;
    private Boolean MousePressed;

    public Input(){

        pressed = new Boolean[110];
        MousePressed = false;
        MouseClicked = false;
        for(int i = 0; i < pressed.length; i++){
            pressed[i] = false;
        }
        PointerPosition = new Position(0,0);
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

    public void clearMouseClick(){
        MouseClicked = false;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        MousePressed = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        MouseClicked = true;
        MousePressed = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        PointerPosition = new Position(e.getX(), e.getY());
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        PointerPosition = new Position(e.getX(), e.getY());
    }

    public Position getPointerPosition() {
        return PointerPosition;
    }

    public Boolean getMouseClicked() {
        return MouseClicked;
    }

    public Boolean getMousePressed() {
        return MousePressed;
    }
}
