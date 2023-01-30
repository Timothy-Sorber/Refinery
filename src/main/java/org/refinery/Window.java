package org.refinery;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Window extends JFrame {
    private Canvas c;
    public Window(int width, int height){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        setName("Refinery test window");
        c = new Canvas();
        c.setPreferredSize(new Dimension(width, height));
        add(c);
        pack();

        c.createBufferStrategy(3);
    }

    public void render(Game game){
        BufferStrategy bufferStrategy = c.getBufferStrategy();
        Graphics g = bufferStrategy.getDrawGraphics();

        g.setColor(Color.BLACK);
        g.fillRect(0,0,c.getWidth(),c.getHeight());

        Rectangle rect = game.getRect();
        g.setColor(Color.BLUE);
        g.fillRect(rect.x,rect.y,rect.width,rect.height);

        g.dispose();
        bufferStrategy.show();
    }
}
