package org.refinery.game;
import org.refinery.Util.GameObject.GameObject;
import org.refinery.Util.GameObject.Ground;
import org.refinery.Util.GameObject.UI.UI;
import org.refinery.Util.Input;
import org.refinery.Util.List.GOlist;
import org.refinery.Util.List.GRlist;
import org.refinery.Util.List.UIlist;
import org.refinery.Util.Position;
import org.refinery.Util.Size;
import org.refinery.Util.util;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Window extends JFrame {
    private Canvas c;
    public int width, height;
    public Color bgcolor;
    private util util = new util();
    public int realitivex, realitivey;
    public Input input;
    public Window(int width, int height, Input input){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setTitle("Refinery test window");
        setExtendedState(MAXIMIZED_BOTH);
        realitivex = 0;
        realitivey = 0;
        this.input = input;
        bgcolor = new Color(0,0,0);
        c = new Canvas();
        c.setPreferredSize(new Dimension(width, height));
        c.addMouseListener(input);
        c.addMouseMotionListener(input);
        add(c);
        addKeyListener(input);
        pack();
        c.createBufferStrategy(3);
    }
    public void update(){

    }

    public void render(Game game){
        BufferStrategy bufferStrategy = c.getBufferStrategy();
        Graphics g = bufferStrategy.getDrawGraphics();

        g.setColor(bgcolor);
        g.fillRect(0,0,c.getWidth(),c.getHeight());
        g.setColor(Color.RED);
        g.drawRect(0,0,getWidth(), getHeight());
        //get GameObject, UI, and Ground lists
        GOlist gameobjects = game.getGameObjects();
        UIlist UI = game.getUI();
        GRlist GR = game.getGround();

        //render Ground
        Ground ground;
        for (int i=0; i < GR.size(); i++){
            ground = GR.get(i);
            g.drawImage(
                    ground.getSprite(),
                    ground.getPosition().getX(),
                    ground.getPosition().getY(),
                    null
            );
        }

        //render GameObjects
        GameObject go;
        for(int i = 0; i < gameobjects.size(); i++){
            go = gameobjects.get(i);
            g.drawImage(
                    go.getSprite(),
                    go.getPosition().getX()+realitivex,
                    go.getPosition().getY()+realitivey,
                    null
            );
        }

        //render UI
        UI ui;
        for(int i = 0; i < UI.size(); i++){
            ui = UI.get(i);
            if (ui.Visible()) {
                g.drawImage(
                        ui.getSprite(),
                        ui.getPosition().getX(),
                        ui.getPosition().getY(),
                        null
                );
            }
        }
        g.setColor(Color.RED);
        g.drawString("FPS: " + game.fps, 10, 20);
        g.drawString("UPS: " + game.ups, 10, 40);
        g.dispose();
        bufferStrategy.show();
    }

    public Position getPosition() {
        return new Position(realitivex, realitivey);
    }
}
