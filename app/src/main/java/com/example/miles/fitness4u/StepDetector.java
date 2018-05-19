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

    public void registerListener(StepListener listener) {
        this.listener = listener;
    }
    //Will accept the updates from the accelerometer
    public void updateAccel(long timeNs, float x, float y, float z) {
        float[] currentAccelerMeter = new float[3];
        currentAccelerMeter[0] = x;
        currentAccelerMeter[1] = y;
        currentAccelerMeter[2] = z;

        //Updates where the global Z vector is (at this point, it is just a guess of where it might be)
        //Further calculations are needed to pinpoint a more reliable answer
        accelRingCounter++;
        xAccelRing[accelRingCounter % accelRingSize] = currentAccelerMeter[0];
        yAccelRing[accelRingCounter % accelRingSize] = currentAccelerMeter[1];
        zAccelRing[accelRingCounter % accelRingSize] = currentAccelerMeter[2];

        //Globalz has X, Y and Z
        float[] globalZ = new float[3];

        //Calculates each global axis
        // Uses the norm function to create a vector space
        globalZ[0] = SensorFilter.sumTotal(xAccelRing) / Math.min(accelRingCounter, accelRingSize);
        globalZ[1] = SensorFilter.sumTotal(yAccelRing) / Math.min(accelRingCounter, accelRingSize);
        globalZ[2] = SensorFilter.sumTotal(zAccelRing) / Math.min(accelRingCounter, accelRingSize);


        //Uses the normFunction to lower the probability function
        float normaliseFactor = SensorFilter.normFunction(globalZ);

        //Each gloabal axis X, Y, Z probability has been lowered
        globalZ[0] = globalZ[0] / normaliseFactor;
        globalZ[1] = globalZ[1] / normaliseFactor;
        globalZ[2] = globalZ[2] / normaliseFactor;

        //Understand and figure out the component of the current acceleration
        //aiming at the direction of globalZ and then subtracts the gravity's contribution
        float currentZ = SensorFilter.dotProduct(globalZ, currentAccelerMeter) - normaliseFactor;

        //velRingCounter = velRingCounter + 1
        velRingCounter++;

        velRing[velRingCounter % velocityRingSize] = currentZ;

        float velocityEst = SensorFilter.sumTotal(velRing);

        if (velocityEst > startStepSens && oldVelocityEstimate <= startStepSens
                && (timeNs - lastTimeStepped > stepDelay)) {
            listener.step(timeNs);
            lastTimeStepped = timeNs;
        }
        oldVelocityEstimate = velocityEst;
    }








}

