package org.refinery.game;

import org.json.JSONObject;
import org.json.JSONArray;
import org.refinery.Ground.Grass;
import org.refinery.Ground.TestGround;
import org.refinery.Machines.TestMachine;
import org.refinery.Objects.*;
import org.refinery.Util.*;
import org.refinery.Util.GameObject.Ground;
import org.refinery.Util.GameObject.UI;
import org.refinery.Util.Item.Inventory;
import org.refinery.Util.Item.Inventoryviewer;
import org.refinery.Util.List.*;
import org.refinery.UI.*;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.JarURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;

public class Game {
    private Window w;
    private GOlist GOlist;
    private UIlist UIlist;
    private GRlist GRlist;
    private static ArrayList<Class> registeredground = new ArrayList<>();
    private static ArrayList<String> registeredgroundNames = new ArrayList<>();
    private MAlist MAlist;
    private Input input, pinput;
    private util u = new util();
    public int fps,ups;
    public Inventory testinv;
    public Inventoryviewer testinvviewer;
    private boolean modsloaded,start = false;
    private int modIndex = 0;

    public Game(int width, int height) {
        input = new Input();
        input.clearMouseClick();
        pinput = new Input();
        w = new Window(width, height, input, pinput);
        GOlist = new GOlist();
        UIlist = new UIlist();
        GRlist = new GRlist();
        MAlist = new MAlist();
        UIlist.add(new loadingScreen(new Size(width, height)));
        System.out.println("Checking for/creating game files...");
        registry.register(registry.GROUND,Grass.class);
        registry.register(registry.GROUND,TestGround.class);
        System.out.println("Loading mods...");
    }

    public void update(int FPS, int UPS){
        if (modsloaded) {
            if (!start) {
                start = true;
                onLoad();
            }
            w.update();
            for (int i = 0; i < GOlist.size(); i++) {
                GOlist.get(i).update(w.width, w.height, GOlist, this);
                if (GOlist.get(i).getState() == false) {
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
                        (mx > UX && mx < (UX + UI.getSize().getWidth()))
                                && (my > UY && my < (UY + UI.getSize().getHeight()))
                ) {
                    UI.asMouseOver();
                    if (UI.Visible()) {
                        if (input.getMousePressed()) {
                            UI.asMouseDown();
                        } else {
                            UI.asMouseUp();
                        }
                    }
                } else {
                    UI.asMouseAway();
                }
            }
            fps = FPS;
            ups = UPS;
        }else{
            modLoaderUpdate();
        }
    }

    private void modLoaderUpdate() {
        try {
            JSONArray disabledmods = new JSONObject(new FileUtils("./game/Configuration/config.json").toString()).getJSONArray("disabledmods");
            File directoryPath = new File("./game/mods");
            String contents[] = directoryPath.list();
            if (modIndex < contents.length){
                if (contents[modIndex].endsWith(".jar")) {
                    String name = contents[modIndex].substring(0, contents[modIndex].lastIndexOf("."));
                    if (!disabledmods.toString().contains(name)) {
                        JarFile jarFile = new JarFile("./game/mods/" + contents[modIndex]);
                        Enumeration<JarEntry> e = jarFile.entries();

                        URL[] urls = {new URL("jar:file:" + "./game/mods/" + contents[modIndex] + "!/")};
                        URLClassLoader cl = URLClassLoader.newInstance(urls);

                        while (e.hasMoreElements()) {
                            JarEntry je = e.nextElement();
                            if (je.isDirectory() || !je.getName().endsWith(".class")) {
                                continue;
                            }
                            String className = je.getName().substring(0, je.getName().length() - 6);
                            className = className.replace('/', '.');
                            if (className.endsWith(contents[modIndex].replace(".jar", ""))) {
                                Class c = cl.loadClass(className);
                                Class<?> clazz = c;
                                String modname = c.getName().substring(4, c.getName().length());
                                modname = modname.substring(((modname.length() - 1) / 2) + 1, modname.length());
                                Constructor<?> ctor = clazz.getConstructor();
                                Object instance = ctor.newInstance();
                                Method modinnit = clazz.getMethod("onEnable", Game.class);
                                modinnit.invoke(instance, this);
                            }
                        }
                    } else {
                        System.out.println(name + " [Disabled]");
                    }
                }
                modIndex++;
            }else{
                modsloaded = true;
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
    private void onLoad(){
        System.out.println("Finished mod loading!");
        GOlist.add(new Player(pinput));
        UIlist.delete(0);
        UIlist.add(new Button(GOlist, this));
        MAlist.add(new TestMachine(new Position(8,4)));
        generateRandomTerrain(25,35,GRlist);
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
                    Grass grass = new Grass();
                    grass.setPosition(new Position(j,i));
                    ground.add(grass);
                }else{
                    ground.add(new TestGround(new Position(j,i)));
                }
            }
        }
    }
    private GRlist getWorldGround(String name){
        JSONObject worldjson = new JSONObject(new FileUtils("./game/Saves/"+name+".json").toString());
        GRlist groundlist = new GRlist();
        JSONArray WorldGround = worldjson.getJSONArray("ground");
        JSONObject curground;
        String type;
        URL[] groundClassURL = {};
        URLClassLoader loader;
        int typeIndex;
        for(int i = 0; i < WorldGround.length(); i++){
            curground = WorldGround.getJSONObject(i);
            type = curground.getString("type");
            Class c = registeredground.get(registeredgroundNames.lastIndexOf(type));
            try {
                Ground instance = (Ground) c.newInstance();
                groundlist.add(instance);
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return groundlist;
    }

    public class registry{
        public static final String GROUND = "Ground";
        public static void register(String type, Class object){
            registeredground.add(object);
            registeredgroundNames.add(object.getName());
        }
    }

    public void saveWorldGrounds(String worldname, GRlist Grounds) {
        try {
            JSONArray worldgrounds = new JSONArray("[]");
            JSONObject curgroundjson = new JSONObject("{}");
            JSONObject curworld = new JSONObject(new FileUtils("./game/Saves/" + worldname + ".json").toString());
            File world = new File("./game/Saves/" + worldname + ".json");
            if (!world.exists()) {
                world.mkdir();
            }
            FileWriter worldfilewriter = new FileWriter(world);
            Ground curground;
            for (int i = 0; i < Grounds.size(); i++) {
                curground = Grounds.get(i);
                System.out.println(curground.getPosition().getX());
                System.out.println(curground.getPosition().getX());
                curgroundjson.put("X", curground.getPosition().getX());
                curgroundjson.put("Y", curground.getPosition().getY());
                curgroundjson.put("type", curground.getClass().getName());
                worldgrounds.put(i, new JSONObject(curgroundjson.toString().replace("\"", "")));
            }
            curworld.put("ground", worldgrounds);
            worldfilewriter.write(curworld.toString());
            worldfilewriter.close();
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean checkForGameFiles(){
        boolean result = true;
        File main = new File("./game");
        if (!main.exists()){
            main.mkdir();
            result = false;
        }
        File config = new File("./game/Configuration");
        if (!config.exists()) {
            config.mkdir();
            result = false;
        }
        File configjson = new File("./game/Configuration/config.json");
        File plrs = new File("./game/Configuration/players.json");
        if (!configjson.exists()) {
            try{
                configjson.createNewFile();
                FileWriter writer = new FileWriter(configjson);
                writer.write("{\n\t\"disabledmods\": [\n\t]\n}");
                writer.close();
            }catch (IOException e) {
                throw new RuntimeException(e);
            }
            result = false;
        }
        if (!plrs.exists()) {
            try{
                plrs.createNewFile();
                FileWriter writer = new FileWriter(plrs);
                writer.write("[\n]");
                writer.close();
            }catch (IOException e) {
                throw new RuntimeException(e);
            }
            result = false;
        }
        File mods = new File("./game/mods");
        if (!mods.exists()) {
            mods.mkdir();
            result = false;
        }
        return result;
    }
}