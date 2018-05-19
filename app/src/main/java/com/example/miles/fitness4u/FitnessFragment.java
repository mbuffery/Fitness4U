package com.example.miles.fitness4u;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by miles on 4/16/2018.
 */

public class FitnessFragment extends Fragment implements SensorEventListener{


    private long steps = 0;
    TextView tvSteps;
    SensorManager sManager;
    boolean running = false;




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_fitness, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        tvSteps = (TextView) getView().findViewById(R.id.tvSteps);

        //Initialised SensorManager and Sensor
        sManager = (SensorManager) getActivity().getSystemService(Context.SENSOR_SERVICE);

    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        if (running)
        {
            tvSteps.setText(String.valueOf(event.values[0]));
        }


/*
        Sensor sensor = event.sensor;
        float[] values = event.values;
        int value = -1;

        if (values.length > 0) {
            value = (int) values[0];
        }

        if (sensor.getType() == Sensor.TYPE_STEP_DETECTOR) {
            steps++;
        }*/
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    public void onResume()
    {
        super.onResume();
        running = true;
        Sensor countSensor = sManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);

        if (countSensor != null)
        {
            sManager.registerListener(this, countSensor, SensorManager.SENSOR_DELAY_UI);
        } else
        {
            Toast.makeText(getActivity(), "Sensor not found", Toast.LENGTH_SHORT).show();
        }

        //sManager.registerListener(this, stepSensor, SensorManager.SENSOR_DELAY_FASTEST);
    }

    @Override
    public void onPause() {
        super.onPause();
        running = false;
        //sManager.unregisterListener(this);
    }

    //function to determine the distance run in kilometers using average step length for men and number of steps
    public float getDistanceRun(long steps){
        float distance = (float)(steps*78)/(float)100000;
        return distance;
    }





}
