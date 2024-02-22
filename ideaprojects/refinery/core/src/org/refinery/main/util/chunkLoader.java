package org.refinery.main.util;

public class chunkLoader implements Runnable {
    private chunk chunk;
    public chunkLoader(chunk chunk) {
        this.chunk = chunk;
    }
    @Override
    public void run() {
        boolean running = true;
        while (running) {
            if (chunk.genDone) {
                running = false;
            } else {
                chunk.genUpdate();
            }
        }
    }
}
