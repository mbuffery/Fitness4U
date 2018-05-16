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

public class Bicep_Fragment extends Fragment {

    private Button num1,num2,num3,num4,num5,num6;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.bodybuilding_abs, container, false);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //Recieves the button from the layout

        num1 = getView().findViewById(R.id.DumbbellCurls);
        num2 = getView().findViewById(R.id.BarbellCurls);
        num3 = getView().findViewById(R.id.HammerCurls);
        num4 = getView().findViewById(R.id.CableBicep);
        num5 = getView().findViewById(R.id.SeatedCurl);
        num6 = getView().findViewById(R.id.ReverseCurl);



        num1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new DumbbellCurlsFragment()).commit();
            }

        });
        num2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new BarbellCurlsFragment()).commit();
            }

        });
        num3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new HammerCurlsFragment()).commit();

            }

        });
        num4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new CableBicepFragment()).commit();

            }

        });
        num5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new SeatedCurlFragment()).commit();

            }

        });
        num6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ReverseCurlFragment()).commit();

            }

        });



    }
}
