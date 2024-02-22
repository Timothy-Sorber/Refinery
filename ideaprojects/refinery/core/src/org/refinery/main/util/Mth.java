package org.refinery.main.util;

public class Mth {
    public static int longDivision(int a, int b) {
        int result = 0;
        while (a < b) {
            a+=b;
            result++;
        }
        if (a>b) {
            result--;
        }
        return result;
    }
    public static int longDivision(long a, long b) {
        int result = 0;
        while (a < b) {
            a+=b;
            result++;
        }
        if (a>b) {
            result--;
        }
        return result;
    }
    public static int longDivision(float a, float b) {
        int result = 0;
        while (a < b) {
            a+=b;
            result++;
        }
        if (a>b) {
            result--;
        }
        return result;
    }
    public static int longDivision(double a, double b) {
        int result = 0;
        while (a < b) {
            a+=b;
            result++;
        }
        if (a>b) {
            result--;
        }
        return result;
    }
}
