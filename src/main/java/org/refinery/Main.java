package org.refinery;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        long process = 1;
        long n = 1;
        int i = 0;
        int test = 4000;
        long h = 1;
        Boolean c = true;
        int pi = 0;
        while (c) {
            if (process <= 4) {
                System.out.println("Seed " + Long.toString(n) + " found true after " + Integer.toString(pi) + " iterations");
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
            if (i >= test){
                c = false;
                System.out.println("Reached max tests, highest integer reached: " + Long.toString(h));
            }
        }
    }
}