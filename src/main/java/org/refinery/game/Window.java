package org.refinery.game;
import org.refinery.Util.Input;
import org.refinery.game.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Window extends JFrame {
    private Canvas c;
    public int width, height;
    public Window(int width, int height, Input input){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        setName("Refinery test window");
        c = new Canvas();
        c.setPreferredSize(new Dimension(width, height));
        add(c);
        addKeyListener(input);
        pack();
        c.createBufferStrategy(3);
    }

    public void render(Game game){
        BufferStrategy bufferStrategy = c.getBufferStrategy();
        Graphics g = bufferStrategy.getDrawGraphics();

        g.setColor(Color.BLACK);
        g.fillRect(0,0,c.getWidth(),c.getHeight());
        g.setColor(Color.RED);
        g.drawRect(0,0,1000, 1000);

        game.getGameObjects().forEach(GameObject -> g.drawImage(GameObject.getSprite(), GameObject.getPosition().getX(), GameObject.getPosition().getY(), null));

        g.dispose();
        bufferStrategy.show();
    }
}
