package org.refinery.Modding;

import org.refinery.game.Game;

public abstract class mod {

    public String modid;

    public mod(String modid){
        this.modid = modid;
    }

    public abstract void onEnable(Game game);
}
