package com.lady.viktoria;

public class Main {

    public static void main(String[] args) {
        // example data
        double[] sensorRawData = { 85, 80, 95 };
        double[] bgMeterData = { 190, 180 };
        double[] weight = { 1, 1, 1};

        double[] x = bgMeterData;
        double[] y = sensorRawData;

        onePointCalibration(y[0], x[0]);
        twoPointCalibration(y,x);
    }



    public static double onePointCalibration(double y, double x) {
        // one pint calibration
        // m = ( y - b) / x
        double b = 0;
        double m = 0;
        m = (y - b) / x;
        System.out.println("one point calibration for " + y + " bgMeterData: " + x + " m is: " + m);
        return m;
    }

    public static double twoPointCalibration(double[] y, double[] x) {
        // two point calibration
        // m = ( y2 - y1 ) * ( x2 - x1 )
        // b = y2 - mx2
        double b = 0;
        double m = 0;
        for (int i=0; i < 1; i++) {
            m=(getMax(y[0], y[1]) - getMin(y[0], y[1])) * (getMax(x[0], x[1]) - getMin(x[0], x[1]));
            b= getMax(y[0], y[1]) - m * getMax(x[0], x[1]);
            System.out.println("two point calibration for " + y[0] + " m is " + m + " b is " + b);
        }
        return m;
    }


    public static double regression(double[] y, double[] x, double m, double b, double[] e) {
        //yi=mxi+b+ei,
        for (int i=0; i < y.length; i++) {
            y[i] = m * x[i] + b + e[i];
            System.out.println("regression with stdError " + y[i] + " error is " + e[i]);
            return y[i];
        }
        return m;
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

    public static strictfp double populationStandardDeviation(double[] values) {
        double mean = mean(values);
        double n = values.length;
        double dv = 0;
        for (double d : values) {
            double dm = d - mean;
            dv += dm * dm;
        }
        return Math.sqrt(dv / n);
    }


    /**
     * Calculate the mean of an array of values
     *
     * @param values The values to calculate
     * @return The mean of the values
     */
    public static strictfp double mean(double[] values) {
        return sum(values) / values.length;
    }
    /**
     * Sum up all the values in an array
     *
     * @param values an array of values
     * @return The sum of all values in the Array
     */
    public static strictfp double sum(double[] values) {
        if (values == null || values.length == 0) {
            throw new IllegalArgumentException("The data array either is null or does not contain any data.");
        }
        else {
            double sum = 0;
            for (int i = 0; i < values.length; i++) {
                sum += values[i];
            }
            return sum;
        }
    }


}
