package org.refinery;

import org.refinery.game.Game;
import org.refinery.game.GameLoop;

public class Launcher {
    public static void main(String[] args) {
        new Thread(new GameLoop(new Game(1920,1080))).start();
    }
}