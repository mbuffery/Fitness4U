package com.example.miles.fitness4u;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by miles on 4/16/2018.
 */

public class BodybuildingFragment extends Fragment implements View.OnClickListener{

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

        abs = (Button) getView().findViewById(R.id.Abs);
        shoulders = (Button) getView().findViewById(R.id.Shoulders);
        chest = (Button) getView().findViewById(R.id.Chest);
        back = (Button) getView().findViewById(R.id.Back);
        legs = (Button) getView().findViewById(R.id.Legs);
        bicep = (Button) getView().findViewById(R.id.Bicep);
        tricep = (Button) getView().findViewById(R.id.Tricep);


        abs.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view){

                getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ProfileFragment()).commit();
            }

        });
        shoulders.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view){

            }

        });
        chest.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view){

            }

        });
        back.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view){

            }

        });
        legs.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view){

            }

        });
        bicep.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view){

            }

        });
        tricep.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view){

            }

        });

    }

    @Override
    public void onClick(View view) {

    }
}
