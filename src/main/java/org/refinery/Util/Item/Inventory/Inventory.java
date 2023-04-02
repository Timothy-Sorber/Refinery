package org.refinery.Util.Item.Inventory;

import org.refinery.Util.Item.Item;

import java.util.ArrayList;

public class Inventory {
    public ArrayList<Item> contents;
    public int size;
    public String name;

    public Inventory(String name, int size){
        contents = new ArrayList<>();
        this.size = size;
        this.name = name;
    }

    public void add(Item item){
        if (contents.size() < size){
            contents.add(item);
        }
    }

    public Item get(int index){
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
}
