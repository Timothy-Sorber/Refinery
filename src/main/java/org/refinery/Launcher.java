package org.refinery;

public class Launcher {
    public static void main(String[] args) {
        util u = new util();
        Window w = new Window();
        new Thread(new GameLoop()).start();
    }
}