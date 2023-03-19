package org.refinery.game;
import org.refinery.Util.GameObject.GameObject;
import org.refinery.Util.GameObject.UI.UI;
import org.refinery.Util.Input;
import org.refinery.Util.List.GOlist;
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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setName("Refinery test window");
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
        //get GameObject and UI lists
        GOlist gameobjects = game.getGameObjects();
        UIlist UI = game.getUI();

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

        UI ui;
        for(int i = 0; i < UI.size(); i++){
            ui = UI.get(i);
            g.drawImage(
                    ui.getSprite(),
                    ui.getPosition().getX(),
                    ui.getPosition().getY(),
                    null
            );
            g.setColor(Color.BLACK);
            g.drawString(ui.getLabel(), ui.getLabelpos().getX(), ui.getLabelpos().getY());
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
