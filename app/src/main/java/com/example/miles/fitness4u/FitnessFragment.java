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
    //Sensor countSensor;
    //SensorManager sManager;
    //boolean running = false;
    Button startCounter, endCounter;
    private StepDetector simpleStepDetector;
    private SensorManager sensorManager;
    private Sensor accel;
    private static final String TEXT_NUM_STEPS = "Number of Steps: ";
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
        //sManager = (SensorManager) getActivity().getSystemService(Context.SENSOR_SERVICE);




        startCounter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if (v.equals(startCounter)) {

                   // startCounter();

               // }
                numSteps = 0;
                sensorManager.registerListener(FitnessFragment.this, accel, SensorManager.SENSOR_DELAY_FASTEST);
                Toast.makeText(getActivity(), "Start Walking", Toast.LENGTH_SHORT).show();
            }
        });

        endCounter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if (v.equals(startCounter)) {

                   // stopCounter();

                    //tvSteps.setText("");
               // }
                sensorManager.unregisterListener(FitnessFragment.this);
                Toast.makeText(getActivity(), "Stop Walking", Toast.LENGTH_SHORT).show();
            }
        });
    }

   // @Override
   // public void onSensorChanged(SensorEvent event) {
/*
        if (running)
        {
            tvSteps.setText(String.valueOf(event.values[0]));
        }


        //TODO: Restart step counter everytime you press go or stop.
        //TODO: After getting the amount of steps, calculate into distance travelled


        Sensor sensor = event.sensor;
        float[] values = event.values;
        int value = -1;

        if (values.length > 0) {
            value = (int) values[0];
        }

        if (sensor.getType() == Sensor.TYPE_STEP_DETECTOR) {
            steps++;
        }*/
    //}

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {


    }

    public void startCounter()
    {/*
        running = true;
        Sensor countSensor = sManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);

        if(running = true) {

            if (countSensor != null) {
                sManager.registerListener(this, countSensor, SensorManager.SENSOR_DELAY_UI);
            } else {
                Toast.makeText(getActivity(), "Sensor not found", Toast.LENGTH_SHORT).show();
            }
        }else {
            Toast.makeText(getActivity(), "You are not running", Toast.LENGTH_SHORT).show();
        }

        //sManager.registerListener(this, stepSensor, SensorManager.SENSOR_DELAY_FASTEST);
        */
    }


    public void stopCounter() {

        //running = false;
        //sManager.unregisterListener(this);
    }

    //function to determine the distance run in kilometers using average step length for men and number of steps
    public float getDistanceRun(long steps){
        float distance = (float)(steps*78)/(float)100000;
        return distance;
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

    }

    @Override
    public void step(long timeNs) {

    }
   
}
