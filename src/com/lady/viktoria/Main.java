package com.lady.viktoria;

import static com.lady.viktoria.OnePointCalibration.onePointCalibration;
import static com.lady.viktoria.TwoPointCalibration.twoPointCalibration;
import static com.lady.viktoria.utils.StandardDeviation.populationStandardDeviation;

public class Main {

    public static void main(String[] args) {
        // example data
        double[] sensorRawData = { 85, 80, 95, 150, 155, 180, 151, 120,100,81 };
        double[] bgMeterData = { 115, 112 };
        double[] weight = { 1, 1, 1};
        double[] time = {1, 2, 3, 4, 5, 6, 7,8,9,10};

        double[] x = bgMeterData;
        double[] y = sensorRawData;

        onePointCalibration(y[0], x[0]);
        twoPointCalibration(y,x);
        regression(y, time,twoPointCalibration(y,x), 1);
    }

    public static void regression(double[] y, double[] x, double slope, double intercept) {
        //yi=mxi+b+ei,
        for (int i=0; i < y.length; i++) {
            double[] e = {y[i], x[i]};
            double error = populationStandardDeviation(e);
                    y[i] = slope * x[i] + intercept + error;
            System.out.println("regression y= " + y[i] + " error is " + error);
        }
    }
}
