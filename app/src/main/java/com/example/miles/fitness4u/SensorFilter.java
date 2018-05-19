package com.example.miles.fitness4u;

/**
 * Created by miles on 5/19/2018.
 */

public class SensorFilter {
    private SensorFilter() {
    }

    //Algorithm to filter out the values, this will give an calculated estimate to steps

    //There will be multiple values, filters out any values that are unwanted from the accelerometer data

    public static float sumTotal(float[] array) {
        float values = 0;

        for (int i = 0; i < array.length; i++) {
            values += array[i];
        }
        return values;
    }

    //Crosses the vaules that has been recorded from the stepcounter
    public static float[] crossValues(float[] array1, float[] array2) {

        //Creates 3 arrays
        float[] valuesArray = new float[3];

        //Each array has now crossed their values and been set to valuesArrary
        valuesArray[0] = array1[1] * array2[2] - array1[2] * array2[1];
        valuesArray[1] = array1[2] * array2[0] - array1[0] * array2[2];
        valuesArray[2] = array1[0] * array2[1] - array1[1] * array2[0];

        return valuesArray;
    }

    public static float norm(float[] array) {
        float values = 0;
        for (int i = 0; i < array.length; i++) {
            values += array[i] * array[i];
        }
        return (float) Math.sqrt(values);
    }


}
