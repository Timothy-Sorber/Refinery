package org.refinery.game;

import org.json.JSONObject;
import org.refinery.Ground.Grass;
import org.refinery.Ground.TestGround;
import org.refinery.Machines.TestMachine;
import org.refinery.Modding.mod;
import org.refinery.Objects.Player;
import org.refinery.Util.*;
import org.refinery.Util.GameObject.GameObject;
import org.refinery.Util.GameObject.UI.*;
import org.refinery.Util.GameObject.UI.Button;
import org.refinery.Util.Item.Inventory.Inventory;
import org.refinery.Util.Item.Inventory.Inventoryviewer;
import org.refinery.Util.List.*;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;
import java.util.List;
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
    public ArrayList<mod> Mods = new ArrayList<mod>();
    public File gameData = new File("game/GameData.txt");

    public Game(int width, int height) throws IOException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, IllegalAccessException, InstantiationException {
        input = new Input();
        input.clearMouseClick();
        w = new Window(width, height, input);
        GameObjects = new ArrayList<>();
        GOlist = new GOlist();
        UIlist = new UIlist();
        GRlist = new GRlist();
        MAlist = new MAlist();
        GOlist.add(new Player(input));
        UIlist.add(new Button(GOlist, this));
        testinv = new Inventory("test inventory", 5);
        testinvviewer = new Inventoryviewer(testinv, this);
        //UIlist.add(testinvviewer);
        MAlist.add(new TestMachine(new Position(8,4)));
        generateRandomTerrain(20,20, GRlist);
        findandrunmods();
    }


    public void findandrunmods() throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        System.out.println("Loading mods...");
        //Creating a File object for directory
        File directoryPath = new File("./game/mods");
        //List of all files and directories
        String contents[] = directoryPath.list();
        System.out.println("List of Mods:");
        for(int i=0; i<contents.length; i++) {
            if (contents[i].endsWith(".jar")) {
                System.out.println(contents[i]);
                JarFile jarFile = new JarFile("game/mods/"+contents[i]);
                Enumeration<JarEntry> e = jarFile.entries();

                URL[] urls = { new URL("jar:file:" + "game/mods/"+contents[i]+"!/") };
                URLClassLoader cl = URLClassLoader.newInstance(urls);

                while (e.hasMoreElements()) {
                    JarEntry je = e.nextElement();
                    if(je.isDirectory() || !je.getName().endsWith(".class")){
                        continue;
                    }
                    // -6 because of .class
                    String className = je.getName().substring(0,je.getName().length()-6);
                    className = className.replace('/', '.');
                    if (className.endsWith("Main")) {
                        Class c = cl.loadClass(className);
                        Class<?> clazz = c;
                        Constructor<?> ctor = clazz.getConstructor();
                        Object instance = ctor.newInstance();
                        Method modinnit = clazz.getMethod("onEnable", Game.class);
                        modinnit.invoke(instance, this);
                        System.out.println("Loaded " + contents[i].replace(".jar", "") + " without errors!");
                    }
                }
            }
        }
    }

    public boolean getModState(String modname){
        boolean state = false;
        try {
            Scanner scanner = new Scanner(gameData);
            while (scanner.hasNextLine()) {
                if (scanner.nextLine() == "(Disabled)" + modname) {
                    state = false;
                }
            }
            state = true;
        }catch (FileNotFoundException e){
            System.out.println("An error occurred while loading mod '"+modname+"'.");
            System.exit(1);
        }
        return state;
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