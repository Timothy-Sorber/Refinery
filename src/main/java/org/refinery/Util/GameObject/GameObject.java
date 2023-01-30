package org.refinery.Util.GameObject;
import org.refinery.Util.GameObject.Position;
import org.refinery.Util.GameObject.Size;

public class GameObject {
    private Position p;
    private Size s;
    private Boolean visible;

    public GameObject(Position pos, Size size){
        this.p = pos;
        this.s = size;
        this.visible = false;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public Position getP() {
        return p;
    }

    public void setP(Position p) {
        this.p = p;
    }

    public Size getS() {
        return s;
    }

    public void setS(Size s) {
        this.s = s;
    }
}
