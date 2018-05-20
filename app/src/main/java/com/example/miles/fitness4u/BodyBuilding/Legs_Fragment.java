package com.example.miles.fitness4u.BodyBuilding;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.miles.fitness4u.Bodybuilding_legs.AngledLegPressFragment;
import com.example.miles.fitness4u.Bodybuilding_legs.BarbellSquatOverheadFragment;
import com.example.miles.fitness4u.Bodybuilding_legs.DumbbellLungesFragment;
import com.example.miles.fitness4u.Bodybuilding_legs.DumbbellSquatsFragment;
import com.example.miles.fitness4u.Bodybuilding_legs.LegExtensionsFragment;
import com.example.miles.fitness4u.Bodybuilding_legs.SquatsFragment;
import com.example.miles.fitness4u.R;

/**
 * Created by miles on 5/16/2018.
 */

public class Legs_Fragment extends Fragment {

    private Button num1,num2,num3,num4,num5,num6;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.bodybuilding_legs, container, false);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //Recieves the button from the layout

        num1 = getView().findViewById(R.id.Squats);
        num2 = getView().findViewById(R.id.DumbbellLunges);
        num3 = getView().findViewById(R.id.AngledLegPress);
        num4 = getView().findViewById(R.id.LegExtensions);
        num5 = getView().findViewById(R.id.BarbellSquatOverhead);
        num6 = getView().findViewById(R.id.DumbbellSquats);



        num1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new SquatsFragment()).commit();
            }

        });
        num2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new DumbbellLungesFragment()).commit();
            }

        });
        num3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new AngledLegPressFragment()).commit();

            }

        });
        num4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new LegExtensionsFragment()).commit();

            }

        });
        num5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new BarbellSquatOverheadFragment()).commit();

            }

        });
        num6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new DumbbellSquatsFragment()).commit();

            }

        });



    }
}
