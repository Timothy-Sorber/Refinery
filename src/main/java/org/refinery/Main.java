package org.refinery;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main {
    public static void main(String[] args) {
        util u = new util();
        JFrame w = new JFrame();
        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        w.setSize(1000,1000);
        w.setVisible(true);
        JLabel l = new JLabel();
        l.setHorizontalAlignment(JLabel.CENTER);
        l.setText("Hello world! This program will run a basic 3X+1 script in 3 seconds... [3]");
        w.getContentPane().add(l);
        u.wait(1000);
        l.setText("Hello world! This program will run a basic 3X+1 script in 3 seconds... [2]");
        u.wait(1000);
        l.setText("Hello world! This program will run a basic 3X+1 script in 3 seconds... [1]");
        u.wait(1000);
        l.setText("Hello world! This program will run a basic 3X+1 script in 3 seconds... [0]");
        System.out.println("Running script");
        long process = 1;
        long n = 1;
        int i = 0;
        long test = 4000000;
        long h = 1;
        Boolean c = true;
        int pi = 0;
        while (c) {
            if (process <= 4) {
                System.out.println("Seed " + n + " found true after " + pi + " iterations");
                n++;
                process = n;
                pi = 0;
                i++;
            }
            if ((process % 2) != 0){
                process = ((process*3)+1)/2;
                pi++;
            }else{
                process = process/2;
                pi++;
            }
            if (process > h){
                h = process;
            }
            l.setText("Current int: " + process + " | Highest integer reached: " + h + " | Seed being tested: " + n);
            if (i >= test){
                c = false;
                System.out.println("Reached max tests, highest integer reached: " + h);
                l.setText("Max Tests reached, please set the int 'test' to a higher value to test further || Highest value reached is " + h);
            }
        }
    }
}