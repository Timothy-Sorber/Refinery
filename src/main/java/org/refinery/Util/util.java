package org.refinery.Util;

import java.util.Random;

public class util {
    public static void wait(int ms)
    {
        try
        {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }

    public int randomint(int max, boolean zero){
        Random rand = new Random();
        return rand.nextInt(max);
    }
    public long randomlong(long max, boolean zero){
        Random rand = new Random();
        return rand.nextLong(max);
    }
    public Boolean randombool(){
        Random rand = new Random();
        return rand.nextBoolean();
    }

    public int randomsignedint(int num, boolean zero){
        Random rand = new Random();
        int n = rand.nextInt(num);
        if ((zero == false) && (n == 0)){
            return randomsignedint(num, false);
        }else{
            if(randombool()){
                return n;
            }else{
                return n*-1;
            }
        }
    }

    public int distanceto(Position pos1, Position pos2){
        return (int) Math.sqrt((pos1.getX() - pos2.getX())^2 + (pos1.getY() - pos2.getY())^2);
    }
}
