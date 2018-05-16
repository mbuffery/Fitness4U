package com.example.miles.fitness4u.BodyBuilding;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.miles.fitness4u.R;

/**
 * Created by miles on 5/16/2018.
 */

public class Back_Fragment extends Fragment {

    private Button num1,num2,num3,num4,num5,num6;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.bodybuilding_back, container, false);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //Recieves the button from the layout

        num1 = getView().findViewById(R.id.ChinUps);
        num2 = getView().findViewById(R.id.Deadlifts);
        num3 = getView().findViewById(R.id.LatPullDown);
        num4 = getView().findViewById(R.id.DumbbellShrugs);
        num5 = getView().findViewById(R.id.TBar);
        num6 = getView().findViewById(R.id.OneArmRow);



        num1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ChinUpsFragment()).commit();
            }

        });
        num2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new DeadliftsFragment()).commit();
            }

        });
        num3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new LatPullDownFragment()).commit();

            }

        });
        num4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new DumbbellShrugsFragment()).commit();

            }

        });
        num5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new TBarFragment()).commit();

            }

        });
        num6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new OneArmRowFragment()).commit();

            }

        });



    }
}
