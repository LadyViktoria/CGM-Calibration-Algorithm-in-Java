package com.lady.viktoria.utils;

public class MinMax {
    public static double getMax(double a, double b){
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    public static double getMin(double a, double b){
        if (a < b) {
            return a;
        } else {
            return b;
        }
    }
}
