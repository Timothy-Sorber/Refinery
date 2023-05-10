package org.refinery.Util.List;

import org.refinery.Util.GameObject.UI;

import java.util.ArrayList;

public class UIlist {
    public static ArrayList<UI> List;
    public UIlist(){
        List = new ArrayList<>();
    }

    public static void add(UI element){
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

    public static UI get(int index){
        return List.get(index);
    }

    public static int size(){
        return List.size();
    }
}
