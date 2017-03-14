package com.lady.viktoria;

public class Main {

    public static void main(String[] args) {
        // example data
        double[] sensorRawData = { 80, 85, 95 };
        double[] bgMeterData = { 160, 150 };
        double[] weight = { 1, 1, 1};

        double[] y = sensorRawData;
        double[] x = bgMeterData;

        // one pint calibration
        double b = 0;
        double m = 0;

        for (int i=0; i<y.length; i++) {
            m = (y[i] - b) / x[0];
            System.out.println("one point calibration for raw value " + y[i] + " bgMeterData: " + x[0] + " m is: " + m);
        }

        System.out.println("____________________");
        // two point calibration
        for (int i=0; i < 1; i++) {
            m=(y[1] - y[0]) * (x[1] - x[0]);
            b=y[1] - m * x[1];
            System.out.println("two point calibration for " + y[0] + " m is " + m + " b is " + b);
        }
    }
}
