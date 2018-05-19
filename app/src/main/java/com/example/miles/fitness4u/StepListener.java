package com.example.miles.fitness4u;

/**
 * Created by miles on 5/19/2018.
 */

//This interface will listen to any alerts when a step is being taken
public interface StepListener {

    public void step(long timeNs);
}
