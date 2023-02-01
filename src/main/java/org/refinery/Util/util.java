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

    public int randomint(int max){
        Random rand = new Random();
        return rand.nextInt(max);
    }
    public long randomlong(long max){
        Random rand = new Random();
        return rand.nextLong(max);
    }
    public Boolean randombool(){
        Random rand = new Random();
        return rand.nextBoolean();
    }


}
