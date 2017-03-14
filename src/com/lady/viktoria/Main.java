package com.lady.viktoria;

public class Main {

    public static void main(String[] args) {
        // example data
        double[] sensorRawData = { 80, 85, 95 };
        double[] bgMeterData = { 180, 160 };
        double[] weight = { 1, 1, 1};

        // one pint calibration
        double b = 0;
        double m = 0;

        for (int i = 0; i< sensorRawData.length; i++) {
            m = (sensorRawData[i] - b) / bgMeterData[0];
            System.out.println("one point calibration for " + sensorRawData[i] + " bgMeterData: " + bgMeterData[0] + " m is: " + m);
        }

        System.out.println("---------------------");
        // two point calibration
        // m = ( y2 - y1 ) * ( x2 - x1 )
        // b = y2 - mx2
        for (int i=0; i < 1; i++) {
            m=(getMax(sensorRawData[0], sensorRawData[1]) - getMin(sensorRawData[0], sensorRawData[1]))
                    * (getMax(bgMeterData[0], bgMeterData[1]) - getMin(bgMeterData[0], bgMeterData[1]));
            b= sensorRawData[1] - m * bgMeterData[1];
            System.out.println("two point calibration for " + sensorRawData[0] + " m is " + m + " b is " + b);
        }
    }

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
