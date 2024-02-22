package org.refinery.main.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import org.refinery.main.util.gameObject;
import org.refinery.main.util.gameInput;

public class player extends gameObject {
    public static float speed = 1f;
    public player() {
        super(new Texture("textures/player.png"), new Vector2(0, 0), new Vector2(64, 128));
        collidable = true;
    }
    @Override
    public void update() {
        velocity.y-=Math.signum(velocity.y)/2;
        velocity.x-=Math.signum(velocity.x)/2;
        if (Gdx.input.isKeyPressed(Input.Keys.W)&&velocity.y<speed*10) {
            velocity.y+=speed;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)&&velocity.x>speed*-10) {
            velocity.x-=speed;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)&&velocity.y>speed*-10) {
            velocity.y-=speed;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)&&velocity.x<speed*10) {
            velocity.x+=speed;
        }
    }
}
