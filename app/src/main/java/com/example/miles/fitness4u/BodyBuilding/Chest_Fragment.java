package com.example.miles.fitness4u.BodyBuilding;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.miles.fitness4u.Bodybuilding_chest.BenchPressFragment;
import com.example.miles.fitness4u.Bodybuilding_chest.CableFlyFragment;
import com.example.miles.fitness4u.Bodybuilding_chest.DeclinePressFragment;
import com.example.miles.fitness4u.Bodybuilding_chest.DumbbellPressFragment;
import com.example.miles.fitness4u.Bodybuilding_chest.InclinePressFragment;
import com.example.miles.fitness4u.Bodybuilding_chest.SeatedFlyFragment;
import com.example.miles.fitness4u.R;

/**
 * Created by miles on 5/16/2018.
 */

public class Chest_Fragment extends Fragment {

    private Button num1,num2,num3,num4,num5,num6;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.bodybuilding_chest, container, false);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //Recieves the button from the layout

        num1 = getView().findViewById(R.id.BenchPress);
        num2 = getView().findViewById(R.id.InclinePress);
        num3 = getView().findViewById(R.id.DumbbellPress);
        num4 = getView().findViewById(R.id.DeclinePress);
        num5 = getView().findViewById(R.id.SeatedFly);
        num6 = getView().findViewById(R.id.CableFly);



        num1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new BenchPressFragment()).commit();
            }

        });
        num2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new InclinePressFragment()).commit();
            }

        });
        num3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new DumbbellPressFragment()).commit();

            }

        });
        num4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new DeclinePressFragment()).commit();

            }

        });
        num5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new SeatedFlyFragment()).commit();

            }

        });
        num6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new CableFlyFragment()).commit();

            }

        });



    }
}
