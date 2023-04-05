package org.refinery.game;

import org.refinery.Ground.Grass;
import org.refinery.Ground.TestGround;
import org.refinery.Machines.TestMachine;
import org.refinery.Objects.Player;
import org.refinery.Objects.TestParticle;
import org.refinery.Util.*;
import org.refinery.Util.GameObject.GameObject;
import org.refinery.Util.GameObject.UI.*;
import org.refinery.Util.GameObject.UI.Button;
import org.refinery.Util.Item.Inventory.Inventory;
import org.refinery.Util.Item.Inventory.Inventoryviewer;
import org.refinery.Util.List.*;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Random;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class Game {
    private Window w;
    private List<GameObject> GameObjects;
    private GOlist GOlist;
    private UIlist UIlist;
    private GRlist GRlist;
    private MAlist MAlist;
    private Input input;
    private util u = new util();
    public int fps,ups;
    public Inventory testinv;
    public Inventoryviewer testinvviewer;

    public Game(int width, int height){
        input = new Input();
        input.clearMouseClick();
        w = new Window(width, height, input);
        GameObjects = new ArrayList<>();
        GOlist = new GOlist();
        UIlist = new UIlist();
        GRlist = new GRlist();
        MAlist = new MAlist();
        GOlist.add(new Player(input));
        //UIlist.add(new Button(GOlist, this));
        testinv = new Inventory("test inventory", 5);
        MAlist.add(new TestMachine(new Position(8,4)));
        generateRandomTerrain(10,20, GRlist);
        for (int i = 0; i<10; i++){
            GOlist.add(new TestParticle());
        }
    }

    /*
    public void findandrunmods() throws ClassNotFoundException {
        JarFile jarFile = new JarFile(pathToJar);
        Enumeration<JarEntry> e = jarFile.entries();

        URL[] urls = { new URL("jar:file:" + pathToJar+"!/") };
        URLClassLoader cl = URLClassLoader.newInstance(urls);

        while (e.hasMoreElements()) {
            JarEntry je = e.nextElement();
            if(je.isDirectory() || !je.getName().endsWith(".class")){
                continue;
            }
            // -6 because of .class
            String className = je.getName().substring(0,je.getName().length()-6);
            className = className.replace('/', '.');
            Class c = cl.loadClass(className);

        }
    }
    */

    public void firstload(){
        try {
            File modsf = new File("./game/mods");
            if (!modsf.exists()) {
                modsf.mkdirs();
                File readme = new File("./game/mods/readme.txt");
                readme.createNewFile();
                readme.setWritable(true);
                FileWriter Writer = new FileWriter("./game/mods/readme.txt");
                Writer.write("Yes, this will have mod support. Please go to https://github.com/Timothy-Sorber/Refinery/tree/master/Modding for more information");
                Writer.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
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
        if (input.ispressed(87)){
            System.out.println("W pressed");
        }
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
    public MAlist getMachines(){
        return MAlist;
    }
    private void generateRandomTerrain(int rows, int rowsize, GRlist ground) {
        Random rand = new Random();
        for(int i = 0; i < rows; i++){
            for(int j = 0; j<rowsize; j++){
                int ri = rand.nextInt(2);
                if (ri==0){
                    ground.add(new Grass(new Position(j,i)));
                }else{
                    ground.add(new TestGround(new Position(j,i)));
                }
            }
        }
    }
}