package org.refinery.game;

import org.refinery.Objects.Player;
import org.refinery.Objects.TestParticle;
import org.refinery.Util.*;
import org.refinery.Util.GameObject.GameObject;
import org.refinery.Util.List.GOlist;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Window w;
    private List<GameObject> GameObjects;
    private GOlist GOlist;
    private Input input = new Input();
    private util u = new util();
    public int fps;
    public int ups;

    public Game(int width, int height){
        w = new Window(width, height, input);
        GameObjects = new ArrayList<>();
        GOlist = new GOlist();
        GOlist.add(new Player(input));
    }

    public void update(int FPS, int UPS){
        for (int i = 0; i < GOlist.size(); i++) {
            GOlist.get(i).update(w.width, w.height, GOlist);
            if (GOlist.get(i).getState() == false){
                GOlist.delete(i);
            }
        }
        fps = FPS;
        ups = UPS;
    }

    public void render(){
        w.render(this);
    }

    public Window getW() {
        return w;
    }

    public GOlist getGameObjects() {
        return GOlist;
    }
}