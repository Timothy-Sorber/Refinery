package org.refinery.main;

import com.badlogic.gdx.graphics.Texture;
import org.json.JSONArray;
import org.json.JSONObject;

public class gameRegistry {
    public static JSONObject registry = new JSONObject();

    public gameRegistry() {
        JSONObject tiles = new JSONObject();

        tiles.put("grass", new Texture("textures/grass.jpg"));
        tiles.put("sand", new Texture("textures/sand.jpg"));

        registry.put("tiles", tiles);
    }
    public static Texture getTile(String name) {
        return (Texture) registry.getJSONObject("tiles").get(name);
    }
}
