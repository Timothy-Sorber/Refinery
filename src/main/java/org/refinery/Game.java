package org.refinery;

import org.refinery.Objects.Player;
import org.refinery.Util.GameObject.GameObject;

import java.util.ArrayList;
import java.util.List;
import java.awt.*;

public class Game {
    private Window w;
    private List<GameObject> GameObjects;
    private Input input = new Input();

    public Game(int width, int height){
        w = new Window(width, height, input);
        GameObjects = new ArrayList<>();
        GameObjects.add(new Player(new PlayerController(input)));
    }

    public void update(){
        GameObjects.forEach(GameObject -> GameObject.update());
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