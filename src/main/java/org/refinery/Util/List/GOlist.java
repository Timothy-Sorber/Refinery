package org.refinery.Util.List;

import org.refinery.Util.GameObject.GameObject;

import java.util.ArrayList;

public class GOlist {
    public static ArrayList<GameObject> List;
    public GOlist(){
        List = new ArrayList<GameObject>();
    }

    public static void add(GameObject go){
        List.add(go);
    }

    public void delete(int index){
        List.remove(index);
    }

    public void clear(){
        List.clear();
    }

    public void remove(){
        List.remove(List.size());
    }

    public static GameObject get(int index){
        return List.get(index);
    }

    public static int size(){
        return List.size();
    }
}