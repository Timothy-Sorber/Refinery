package org.refinery.game;

import org.refinery.Objects.Particle;
import org.refinery.Util.*;
import org.refinery.Util.GameObject.GameObject;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Window w;
    private List<GameObject> GameObjects;
    private Input input = new Input();
    private util u = new util();

    public Game(int width, int height){
        w = new Window(width, height, input);
        GameObjects = new ArrayList<>();
    }

    public void update(){
        for (int i = 0; i < 5; i++){
            GameObjects.add(new Particle());
        }
        for (int i = 0; i < GameObjects.size(); i++) {
            GameObjects.get(i).update(w.width, w.height, GameObjects);
            if (GameObjects.get(i).getState() == false){
                GameObjects.remove(i);
            }
        }
    }

    public void render(){
        w.render(this);
    }

    public Window getW() {
        return w;
    }

    public List<GameObject> getGameObjects() {
        return GameObjects;
    }
}