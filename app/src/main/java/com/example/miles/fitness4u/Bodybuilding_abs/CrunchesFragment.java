package com.example.miles.fitness4u.Bodybuilding_abs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.miles.fitness4u.R;

/**
 * Created by miles on 5/16/2018.
 */

public class CrunchesFragment extends Fragment {

    ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this, R.layout.fragment_bodybody_selection, items);
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.bodybuilding_abs, container, false);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        ListView listView = ()



    }
}
