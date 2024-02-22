package org.refinery.main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import org.refinery.main.objects.player;
import org.refinery.main.util.*;

import java.util.ArrayList;
import java.util.Random;

public class game {
    public static ArrayList<gameObject> gameObjects = new ArrayList<>();
    public static ArrayList<chunk> chunks = new ArrayList<>();
    private static SpriteBatch batch;
    public static ShapeRenderer shapeRenderer;
    public static player player;
    private static Vector2[] worldGenChecks = new Vector2[25];
    private int lastPChunkX, lastPChunkY;
    public static int renderDistance = 2;
    public static OrthographicCamera camera;
    public static Random random = new Random(0);
    public static boolean debugDraw = false;
    public static perlinNoise noise = new perlinNoise();

    public game(SpriteBatch batch, OrthographicCamera camera) {
        new gameRegistry();
        this.batch = batch;
        this.camera = camera;
        shapeRenderer = new ShapeRenderer();
        player = new player();
        gameObjects.add(player);
        int pchunkX = (int) Math.floor((double) player.position.x/(chunk.tileSize*chunk.chunkSize));
        int pchunkY = (int) Math.floor((double) player.position.y/(chunk.tileSize*chunk.chunkSize));
        int i = 0;
        for (int x = -2; x < 3; x++) {
            for (int y = -2; y < 3; y++) {
                worldGenChecks[i] = new Vector2(x + pchunkX, y + pchunkY);
                i++;
            }
        }
        lastPChunkX = pchunkX;
        lastPChunkY = pchunkY;
    }
    public void update() {
        int pchunkX = (int) Math.floor((double) player.position.x/(chunk.tileSize*chunk.chunkSize));
        int pchunkY = (int) Math.floor((double) player.position.y/(chunk.tileSize*chunk.chunkSize));
        if (pchunkX!=lastPChunkX||pchunkY!=lastPChunkY) {
            int i = 0;
            for (int x = -2; x < 3; x++) {
                for (int y = -2; y < 3; y++) {
                    worldGenChecks[i] = new Vector2(x + pchunkX, y + pchunkY);
                    i++;
                }
            }
            lastPChunkX = pchunkX;
            lastPChunkY = pchunkY;
        }

        shapeRenderer.setProjectionMatrix(camera.combined);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        
        for (chunk chunk : chunks) {
            if (chunk.position.x>pchunkX-renderDistance&&
                    chunk.position.y>pchunkY-renderDistance&&
                    chunk.position.x<pchunkX+renderDistance&&
                    chunk.position.y<pchunkY+renderDistance
                ) {
                chunk.draw(batch, camera);
            }
        }
        
        worldGen();
        
        for (gameObject gameObject : gameObjects) {
            gameObject.update();
            gameObject.draw(batch);
        }

        /*if (gameInput.mouseDown) {
            System.out.println(gameInput.mouseWorldX+"|"+gameInput.mouseWorldY);
            Vector2 pos = chunk.convertToGridPosition(gameInput.mouseWorldX, gameInput.mouseWorldY);
            setTile(pos, "sand");
        }*/
        shapeRenderer.end();

        if (Gdx.input.isKeyJustPressed(Input.Keys.F4)) {
            debugDraw=!debugDraw;
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.F1)) {
            chunks.clear();
        }
    }

    private void worldGen() {
        for (int i=0; i<worldGenChecks.length; i++) {
            Vector2 check = worldGenChecks[i];
            boolean found = false;
            for (chunk chunk : chunks) {
                if (check.x==chunk.position.x&&check.y==chunk.position.y){
                    found = true;
                    break;
                }
            }
            if (!found) {
                chunk newChunk = new chunk(check, this);
                chunks.add(newChunk);
                new Thread(new chunkLoader(newChunk)).run();
            }
        }
    }
    public chunk getChunk(int x, int y) {
        for (chunk chunk : chunks) {
            if (chunk.position.x==x&&chunk.position.y==y) {
                return chunk;
            }
        }
        return null;
    }
    public chunk getChunk(Vector2 position) {
        return getChunk((int) position.x, (int) position.y);
    }

    public void setTile(int x, int y, String type) {
        Vector2 chunkPos = chunk.convertGridPositionToChunkPosition(x, y);
        chunk chunk = getChunk(chunkPos);
        Vector2 gridPos = new Vector2(x, y);
        chunk.setTile(gridPos, type);
    }
    public void setTile(Vector2 position, String type) {
        setTile((int) position.x, (int) position.y, type);
    }
}
