package com.example.miles.fitness4u;

/**
 * Created by miles on 5/19/2018.
 */

public class StepDetector {

    //Sets the accelerometer and velocity
    private static final int accelRingSize = 50;
    private static final int velocityRingSize = 10;

    //Found it that 50 is a good sensitivity as it works on multiple update to date android phones
    private static final float startStepSens = 50f;

    //After each step, give a delay
    private static final int stepDelay = 250000000;

    private int accelRingCounter = 0;
    private int velRingCounter = 0;
    //Sets the X, Y, Z for the accelRing by assigning it a float
    private float[] xAccelRing = new float[accelRingSize];
    private float[] yAccelRing = new float[accelRingSize];
    private float[] zAccelRing = new float[accelRingSize];

    private float[] velRing = new float[velocityRingSize];

    //Set lastStepTime to 0
    private long lastTimeStepped = 0;
    private float oldVelocityEstimate = 0;

    //Uses the StepListener interface to listen and calculate each step
    private StepListener listener;




}
