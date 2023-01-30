package org.refinery;
import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    private Canvas c;
    public Window(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        setName("Refinery test window");
        c = new Canvas();
        c.setPreferredSize(new Dimension(1000, 1000));
        add(c);
        pack();
    }
}
