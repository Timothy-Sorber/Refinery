package org.refinery;

import org.refinery.Util.Controller;
import org.refinery.Util.Input;

import java.awt.event.KeyEvent;

public class PlayerController implements Controller {

    private Input input;

    public PlayerController(Input input){
        this.input = input;
    }

    @Override
    public Boolean iru() {
        return input.ispressed(KeyEvent.VK_UP);
    }

    @Override
    public Boolean ird() {
        return input.ispressed(KeyEvent.VK_DOWN);
    }

    @Override
    public Boolean irl() {
        return input.ispressed(KeyEvent.VK_LEFT);
    }

    @Override
    public Boolean irr() {
        return input.ispressed(KeyEvent.VK_RIGHT);
    }
}
