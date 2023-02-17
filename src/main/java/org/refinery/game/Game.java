package org.refinery.game;

import org.refinery.Objects.Player;
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
        GameObjects.add(new Player(input, new Position(50, 50), new Size(u.randomint(150), u.randomint(150)), new Velocity(new Position(50, 50), u.randomint(20), u.randomint(20))));
        GameObjects.add(new Player(input, new Position(500, 500), new Size(u.randomint(150), u.randomint(150)), new Velocity(new Position(50, 50), u.randomint(20), u.randomint(20))));
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