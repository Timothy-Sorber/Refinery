package org.refinery;

import java.awt.Color;
public class GameLoop implements Runnable {
    private boolean running;
    private final double updateRate = 1.0d/60.0d;
    private long nextStatTime;
    private int fps, ups;

    private Game game;

    public GameLoop(Game game){
        this.game = game;
    }
    @Override
    public void run() {
        running = true;
        double accumulator = 0;
        long currentTime, lastUpdate = System.currentTimeMillis();
        nextStatTime = System.currentTimeMillis() + 1000;
        while (running) {
            currentTime = System.currentTimeMillis();
            double lastRenderTime = (currentTime - lastUpdate) / 1000d;
            accumulator += lastRenderTime;
            lastUpdate = currentTime;

            if (accumulator >= updateRate) {
                while (accumulator >= updateRate) {
                    update();
                    accumulator -= updateRate;
                }
                render();
            }
            updateStats();
        }
    }

    private void updateStats() {
        if (System.currentTimeMillis() > nextStatTime) {
            System.out.println("Fps: " + fps + " Ups: " + ups);
            fps = 0;
            ups = 0;
            nextStatTime = System.currentTimeMillis() + 1000;
        }
    }

    private void render() {
        game.render();
        fps++;
    }

    private void update() {
        game.update();
        ups++;
    }
}
