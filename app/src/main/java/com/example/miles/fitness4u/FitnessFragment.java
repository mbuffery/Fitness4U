package com.example.miles.fitness4u;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static android.content.Context.SENSOR_SERVICE;

/**
 * Created by miles on 4/16/2018.
 */

public class FitnessFragment extends Fragment implements SensorEventListener, StepListener{


    //private long steps = 0;
    TextView tvSteps;
    private Sensor countSensor;
    private StepDetector stepDetector;
    SensorManager sManager;
    Button startCounter, endCounter;

    private static final String numberOfSteps = "Number of Steps: ";
    private int numSteps;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_fitness, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        tvSteps = getView().findViewById(R.id.tvSteps);
        startCounter = getView().findViewById(R.id.startCounter);
        endCounter = getView().findViewById(R.id.stopCounter);

        //Initialised SensorManager and Sensor
        sManager = (SensorManager) getActivity().getSystemService(Context.SENSOR_SERVICE);
        countSensor = sManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        stepDetector = new StepDetector();
        stepDetector.registerListener(this);

        startCounter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                numSteps = 0;
                sManager.registerListener(FitnessFragment.this, countSensor, SensorManager.SENSOR_DELAY_FASTEST);
                Toast.makeText(getActivity(), "Start Walking", Toast.LENGTH_SHORT).show();
            }
        });

        endCounter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sManager.unregisterListener(FitnessFragment.this);
                Toast.makeText(getActivity(), "Stop Walking", Toast.LENGTH_SHORT).show();
                numSteps = 0;
            }
        });
    }


    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {
    }



    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER)
        {
            stepDetector.updateAccel(event.timestamp, event.values[0], event.values[1], event.values[2]);
        }

    }

    @Override
    public void step(long timeNs) {

        numSteps++;
        tvSteps.setText(numberOfSteps + numSteps);
    }


}
