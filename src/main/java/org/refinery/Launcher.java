package org.refinery;

import org.refinery.game.Game;
import org.refinery.game.GameLoop;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Launcher {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, IllegalAccessException, InstantiationException {
        System.out.println("Innitializing gameloop");
        new Thread(new GameLoop(new Game(1920,1080))).start();
    }
}