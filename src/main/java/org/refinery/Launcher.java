package org.refinery;

import org.refinery.game.Game;
import org.refinery.game.GameLoop;

public class Launcher {
    public static void main(String[] args) {
        new Thread(new GameLoop(new Game(2000,1000))).start();
    }
}