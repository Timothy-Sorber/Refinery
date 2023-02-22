package org.refinery.Util.List;

import java.util.ArrayList;

public class IntList {
    public ArrayList<Integer> List;
    public IntList(){
        List = new ArrayList<>();
    }

    public int Get(int index){
        return List.get(index);
    }

    public void Add(int value){
        List.add(value);
    }

    public void Clear(){
        List.clear();
    }

    public void Delete(){
        List.remove(List.size());
    }

    public int Size(){
        return List.size();
    }

    public void Remove(int index){
        List.remove(index);
    }
}
