package com.lady.viktoria;

public class OnePointCalibration {
    public static double onePointCalibration(double y, double x) {
        // one pint calibration
        // slope. m = ( y - b) / x
        double b = 0;
        double m = (y - b) / x;
        System.out.println("one point calibration for " + y + " bgMeterData: " + x + " m is: " + m);
        return m;
    }
}
