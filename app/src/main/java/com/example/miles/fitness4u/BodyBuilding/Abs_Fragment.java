package com.example.miles.fitness4u.BodyBuilding;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.miles.fitness4u.R;

/**
 * Created by miles on 5/16/2018.
 */

public class Abs_Fragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.bodybuilding_abs, container, false);
    }
}
