package org.refinery.Modding;

import org.json.JSONObject;
import org.refinery.game.Game;

public abstract class mod {

    public JSONObject info;
    public mod(JSONObject info) {
        this.info = info;
    }
    public JSONObject getInfo(){
        return info;
    }
    public abstract void onEnable(Game game);
}
