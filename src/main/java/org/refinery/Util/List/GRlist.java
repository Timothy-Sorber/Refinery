package org.refinery.Util.List;

import org.refinery.Util.GameObject.Ground;

import java.util.ArrayList;

public class GRlist {
    public static ArrayList<Ground> List;
    public GRlist(){
        List = new ArrayList<>();
    }

    public static void add(Ground element){
        List.add(element);
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

    public static Ground get(int index){
        return List.get(index);
    }

    public static int size(){
        return List.size();
    }
}
