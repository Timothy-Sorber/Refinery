package org.refinery.game;

import org.refinery.Ground.TestGround;
import org.refinery.Objects.Player;
import org.refinery.Objects.TestParticle;
import org.refinery.Util.*;
import org.refinery.Util.GameObject.GameObject;
import org.refinery.Util.GameObject.UI.*;
import org.refinery.Util.GameObject.UI.Button;
import org.refinery.Util.List.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private Window w;
    private List<GameObject> GameObjects;
    private GOlist GOlist;
    private UIlist UIlist;
    private GRlist GRlist;
    private Input input = new Input();
    private Input playerinput = new Input();
    private util u = new util();
    public int fps,ups,cooldown;

    public Game(int width, int height){
        input.clearMouseClick();
        w = new Window(width, height, input);
        GameObjects = new ArrayList<>();
        GOlist = new GOlist();
        UIlist = new UIlist();
        GRlist = new GRlist();
        GOlist.add(new Player(playerinput));
        UIlist.add(new Button("TestButton", GOlist));
        GRlist.add(new TestGround(new Position(0,0)));
        GRlist.add(new TestGround(new Position(1,1)));
        cooldown=0;
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
        for (int i = 0; i < UIlist.size(); i++) {
            UI UI = UIlist.get(i);
            int mx = input.getPointerPosition().getX();
            int my = input.getPointerPosition().getY();
            int UX = UI.getPosition().getX();
            int UY = UI.getPosition().getY();
            if (
                    (mx>UX&&mx<(UX+UI.getSize().getWidth()))
                    &&(my>UY&&my<(UY+UI.getSize().getHeight()))
            ){
                UI.asMouseOver();
                if (UI.Visible()) {
                    if (input.getMousePressed()) {
                        UI.asMouseDown();
                    } else {
                        UI.asMouseUp();
                    }
                }
            }else{
                UI.asMouseAway();
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
    public UIlist getUI() {return UIlist;}

    public GRlist getGround() {
        return GRlist;
    }

    public Position getCameraPosition() {
        return w.getPosition();
    }
    public Window Window() {
        return w;
    }
}