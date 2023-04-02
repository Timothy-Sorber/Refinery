package org.refinery.Util.List;

import org.refinery.Util.GameObject.Machine;
import org.refinery.Util.GameObject.UI.UI;

import java.util.ArrayList;

public class MAlist {
    public static ArrayList<Machine> List;
    public MAlist(){
        List = new ArrayList<>();
    }

    public static void add(Machine machine){
        List.add(machine);
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

    public static Machine get(int index){
        return List.get(index);
    }

    public static int size(){
        return List.size();
    }
}
