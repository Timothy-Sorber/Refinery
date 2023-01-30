package org.refinery;

import org.refinery.Util.util;

public class Launcher {
    public static void main(String[] args) {
        util u = new util();
        new Thread(new GameLoop(new Game(1000,1000))).start();
    }
}