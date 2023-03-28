package org.refinery.Util.GameObject.UI;

import org.refinery.Objects.TestParticle;
import org.refinery.Util.List.GOlist;
import org.refinery.Util.Position;
import org.refinery.Util.Size;

import java.awt.*;

public class Button extends UI{
    public Boolean mouseover;
    public Boolean click = false;
    public Button(String name, GOlist GOlist) {
        super(name);
        setPosition(new Position(500,250));
        setSize(new Size(200,50));
        setLabel("Test Button");
        setLabelpos(new Position(100,25));
        setColor(Color.BLUE);
        setLabelcolor(Color.RED);
        mouseover=false;
    }

    @Override
    public void asMouseOver() {
        mouseover=true;
        setColor(new Color(0,100,255));
    }

    @Override
    public void asMouseDown() {
        if (mouseover&&!click){
            setColor(Color.CYAN);
            GOlist.add(new TestParticle());
            click = true;
        }
    }

    @Override
    public void asMouseAway() {
        mouseover=false;
        setColor(Color.BLUE);
    }

    @Override
    public void asMouseUp() {
        click=false;
    }
}
