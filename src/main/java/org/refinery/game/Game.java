package org.refinery.game;

import org.refinery.Objects.Player;
import org.refinery.Util.GameObject.GameObject;
import org.refinery.Util.Input;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Window w;
    private List<GameObject> GameObjects;
    private Input input = new Input();

    public Game(int width, int height){
        w = new Window(width, height, input);
        GameObjects = new ArrayList<>();
        GameObjects.add(new Player(input));
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