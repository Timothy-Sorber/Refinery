package org.refinery.Util.Item;

import java.util.ArrayList;

public class Inventory {
    public ArrayList<Class> contents;
    public int size;
    public String name;

    public Inventory(String name, int size){
        contents = new ArrayList<>();
        this.size = size;
        this.name = name;
    }

    public void add(Class item){
        if (contents.size() < size){
            contents.add(item);
        }
    }

    public Class get(int index){
        if (contents.size() < index) {
            return contents.get(index);
        }else{
            return null;
        }
    }

    public void remove(int index){
        if (index <= contents.size()){
            contents.remove(index);
        }
    }
    public void setItem(int index, Class item){
        if (index <= contents.size()){
            contents.set(index, item);
        }
    }
}
