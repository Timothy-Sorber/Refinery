package org.refinery.Modding;

import org.refinery.game.Game;

public abstract class mod {

    public mod(String modid) {

    }

    public abstract void onEnable(Game game);
}
