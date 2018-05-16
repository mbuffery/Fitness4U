package com.example.miles.fitness4u.BodyBuilding;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.miles.fitness4u.ProfileFragment;
import com.example.miles.fitness4u.R;

/**
 * Created by miles on 4/16/2018.
 */

public class BodybuildingFragment extends Fragment{

    private Button abs, shoulders,chest,back,legs,bicep,tricep;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_bodybuilding, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //Recieves the button from the layout

        abs = getView().findViewById(R.id.Abs);
        shoulders = getView().findViewById(R.id.Shoulders);
        chest = getView().findViewById(R.id.Chest);
        back = getView().findViewById(R.id.Back);
        legs = getView().findViewById(R.id.Legs);
        bicep = getView().findViewById(R.id.Bicep);
        tricep = getView().findViewById(R.id.Tricep);


        abs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new Abs_Fragment()).commit();
            }

        });
        shoulders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }

        });
        chest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }

        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }

        });
        legs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }

        });
        bicep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }

        });
        tricep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }

        });


    }
    }

