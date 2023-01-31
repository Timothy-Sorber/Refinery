package org.refinery;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

public class Window extends JFrame {
    private Canvas c;
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

        game.getGameObjects().forEach(GameObject -> g.drawImage(
                GameObject.getSprite(),
                GameObject.getPosition().getX(),
                GameObject.getPosition().getY(),
                null
        ));

        g.dispose();
        bufferStrategy.show();
    }
}
