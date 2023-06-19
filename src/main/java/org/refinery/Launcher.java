package org.refinery;

import org.refinery.game.Game;
import org.refinery.game.GameLoop;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Launcher {
    public static void main(String[] args) {
        System.out.println("Innitializing gameloop");
        Game game = new Game(1920, 1080);
        game.checkForGameFiles();
        new Thread(new GameLoop(game)).start();
    }
}