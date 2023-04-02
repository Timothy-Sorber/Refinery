package org.refinery.Util.Item;

import org.refinery.Util.GameObject.GameObject;
import org.refinery.Util.List.GOlist;
import org.refinery.Util.Position;
import org.refinery.game.Game;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Item {
    public int cooldown,amount,maxstacksize;
    public String name;

    public Item(String name, int amount, int maxstacksize) {
        this.name = name;
        cooldown = 0;
    }

    public abstract BufferedImage getSprite();
    public abstract void onUse();

    public void update(){
        if (cooldown>0){
            cooldown--;
        }
    }

    public void setCooldown(int cooldown){
        this.cooldown = cooldown;
    }
}
