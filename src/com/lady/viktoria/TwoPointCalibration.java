package com.lady.viktoria;

import static com.lady.viktoria.utils.MinMax.getMax;
import static com.lady.viktoria.utils.MinMax.getMin;

public class TwoPointCalibration {
    public static double twoPointCalibration(double[] y, double[] x) {
        // two point calibration
        // slope, m = ( y2 - y1 ) * ( x2 - x1 )
        // intercept, b = y2 - mx2
        double m=(getMax(y[0], y[1]) - getMin(y[0], y[1])) * (getMax(x[0], x[1]) - getMin(x[0], x[1]));
        double b= getMax(y[0], y[1]) - m * getMax(x[0], x[1]);
        System.out.println("two point calibration for " + y[0] + " m is " + m + " b is " + b);
        return m;
    }
}
