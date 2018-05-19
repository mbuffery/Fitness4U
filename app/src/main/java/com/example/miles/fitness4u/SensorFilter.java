package com.example.miles.fitness4u;

/**
 * Created by miles on 5/19/2018.
 */

public class SensorFilter {
    private SensorFilter() {
    }

    //Algorithm to filter out the values, this will give an calculated estimate to steps

    //There will be multiple values, filters out any values that are unwanted from the accelerometer data


   //
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

        //Each array has now crossed their values with every other array and been set to valuesArrary
        //X, Y and Z
        valuesArray[0] = array1[1] * array2[2] - array1[2] * array2[1];
        valuesArray[1] = array1[2] * array2[0] - array1[0] * array2[2];
        valuesArray[2] = array1[0] * array2[1] - array1[1] * array2[0];

        return valuesArray;
    }

    //
    public static float normFunction(float[] array) {
        //Set values to 0
        float values = 0;
        //Loops through the length of the array while adding to values
        //Every loop, past values data will be added to new values data
        //Will assign strictly positive length/size for each vector in a vector space
        for (int i = 0; i < array.length; i++) {
            values += array[i] * array[i];
        }
        return (float) Math.sqrt(values);
    }

    // Method will only work with 3D vectors(x, y, z)
    //From vectors a and b, calculates the dot product
    // Times both x , y and z cords with each other
    //Adding them all together at the end to get the dot product
    public static float dotProduct(float[] a, float[] b) {
        float values = a[0] * b[0] + a[1] * b[1] + a[2] * b[2];
        return values;
    }


}
