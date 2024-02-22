package org.refinery.main.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.graphics.Color;

import org.refinery.Launcher;
import org.refinery.main.game;
import org.refinery.main.gameRegistry;

import java.awt.*;
import java.util.Random;

public class chunk {
    public Vector2 position;
    public static int tileSize = 128, chunkSize = 32, chunkSizeInPixels = tileSize * chunkSize;
    private int genIteration = 0;
    private String[] textureNames = new String[chunkSize*chunkSize];
    private Texture[] textureCache = new Texture[chunkSize*chunkSize];
    public boolean isCached = false, genDone = false;
    private game Game;
    private Random random;
    public chunk(Vector2 position, game game) {
        this.position = position;
        this.Game = game;
        this.random = game.random;
    }
    public void draw(SpriteBatch batch, OrthographicCamera camera) {
        if (!isCached) {
            new Thread(() -> {
                int i = 0;
                for (String textureName : textureNames) {
                    if (textureName!=null) {
                        textureCache[i] = gameRegistry.getTile(textureName);
                    }
                    i++;
                }
            });
            isCached = true;
        }
        if (true) {
            int i = 0;
            for (int x = 0; x < chunkSize; x++) {
                for (int y = 0; y < chunkSize; y++) {
                    if (textureCache[i] != null &&
                            (y * tileSize) + position.y * (tileSize * chunkSize) < camera.position.y + (camera.viewportHeight * camera.zoom) &&
                            (x * tileSize) + position.x * (tileSize * chunkSize) < camera.position.x + (camera.viewportWidth * camera.zoom)) {
                        batch.draw(textureCache[i], x * tileSize + position.x * tileSize * 32, y * tileSize + position.y * tileSize * chunkSize, tileSize, tileSize);
                    }
                    i++;
                }
            }
        }
        if (game.debugDraw) {
            ShapeRenderer shape = game.shapeRenderer;
            shape.setColor(Color.BLACK);
            int chunkX = Math.round(position.x*chunkSizeInPixels);
            int chunkY = Math.round(position.y*chunkSizeInPixels);
            int lineWidth = 16;
            shape.rect(chunkX-(lineWidth/2), chunkY, lineWidth, chunkSizeInPixels);
            shape.rect(chunkX, chunkY-(lineWidth/2), chunkSizeInPixels, lineWidth);
            for (int x = 0; x < chunkSize; x++) {
                int dx = Math.round((x * tileSize) + chunkX);
                shape.rect(dx - (lineWidth/4), chunkY, lineWidth/2, chunkSizeInPixels);
            }
            for (int y = 0; y < chunkSize; y++) {
                int dy = Math.round((y * tileSize) + chunkY);
                shape.rect(chunkX, dy - (lineWidth/4), chunkSizeInPixels, lineWidth/2);
            }
        }
    }
    public void setTile(int x, int y, String type) {
        int index = y * chunkSize + x;
        textureNames[index] = type;
        textureCache[index] = gameRegistry.getTile(type);
    }
    public void setTile(Vector2 position, String type) {
        setTile((int) position.x, (int) position.y, type);
    }
    public void genUpdate() {
        if (!genDone) {
            String result = "grass";

            double tileX = position.x * chunkSize + (genIteration % chunkSize);
            double tileY = position.y * chunkSize + Math.floor(genIteration / chunkSize);


            if (game.noise.noise(tileX * 0.1, tileY * 0.1) > 0.2) {
                result = "sand";
            }

            textureNames[genIteration] = result;
            textureCache[genIteration] = gameRegistry.getTile(result);
            genIteration++;

            if (genIteration >= chunkSize * chunkSize) {
                genDone = true;
            }
        }
    }
    public static Vector2 convertToChunkPosition(float x, float y) {
        int chunkSizeInPixels = tileSize * chunkSize;
        double chunkX = Math.floor(x / chunkSizeInPixels);
        double chunkY = Math.floor(y / chunkSizeInPixels);
        return new Vector2((float) chunkX, (float) chunkY);
    }
    public static Vector2 convertGridPositionToChunkPosition(int x, int y) {
        double chunkX = Math.floor(x / chunkSize);
        double chunkY = Math.floor(y / chunkSize);
        return new Vector2((float) chunkX, (float) chunkY);
    }
    public static Vector2 convertToGridPosition(float x, float y, Boolean relative) {
        double gridX = Math.floor(x / tileSize);
        double gridY = Math.floor(y / tileSize);

        // if relative is true then make position relative to the chunk it is in
        if (relative) {
            // Calculate the chunk offset
            int chunkOffsetX = (int) Math.floor(gridX / chunkSize);
            int chunkOffsetY = (int) Math.floor(gridY / chunkSize);

            // Adjust grid positions relative to the chunk
            gridX -= chunkOffsetX * chunkSize;
            gridY -= chunkOffsetY * chunkSize;
        }

        return new Vector2((float) gridX, (float) gridY);
    }
    public static Vector2 convertToGridPosition(float x, float y) {
        return convertToGridPosition(x, y, false);
    }
}
