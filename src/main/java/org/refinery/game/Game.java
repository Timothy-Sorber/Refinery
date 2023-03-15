package org.refinery.game;

import org.refinery.Objects.Player;
import org.refinery.Objects.TestParticle;
import org.refinery.PlayerController;
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
        for (int i = 0; i<10; i++){
            GOlist.add(new TestParticle());
        }
    }

    public void update(int FPS, int UPS){
        w.update();
        for (int i = 0; i < GOlist.size(); i++) {
            GOlist.get(i).update(w.width, w.height, GOlist, this);
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

    public Position getCameraPosition() {
        return w.getPosition();
    }
    public Window Window() {
        return w;
    }
}