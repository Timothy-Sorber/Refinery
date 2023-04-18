package org.refinery;

import org.refinery.game.Game;
import org.refinery.game.GameLoop;

public class Launcher {
    public static void main(String[] args) {
        System.out.println("Innitializing gameloop");
        new Thread(new GameLoop(new Game(1920,1080))).start();
    }
}