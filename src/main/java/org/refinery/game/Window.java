package org.refinery.game;
import org.refinery.Util.GameObject.GameObject;
import org.refinery.Util.Input;
import org.refinery.Util.List.GOlist;
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
        if (input.ispressed(68)){
            realitivex-=10;
        }
        if (input.ispressed(65)){
            realitivex+=10;
        }
        if (input.ispressed(87)){
            realitivey+=10;
        }
        if (input.ispressed(83)){
            realitivey-=10;
        }
    }

    public void render(Game game){
        BufferStrategy bufferStrategy = c.getBufferStrategy();
        Graphics g = bufferStrategy.getDrawGraphics();

        g.setColor(bgcolor);
        g.fillRect(0,0,c.getWidth(),c.getHeight());
        g.setColor(Color.RED);
        g.drawRect(0,0,getWidth(), getHeight());
        GOlist gameobjects = game.getGameObjects();
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
        g.drawString("FPS: " + game.fps, 10, 20);
        g.drawString("UPS: " + game.ups, 10, 40);
        g.dispose();
        bufferStrategy.show();
    }
}
