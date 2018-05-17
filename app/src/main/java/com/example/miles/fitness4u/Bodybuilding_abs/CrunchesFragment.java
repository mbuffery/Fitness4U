package com.example.miles.fitness4u.Bodybuilding_abs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.miles.fitness4u.BodyBuildingSelection;
import com.example.miles.fitness4u.DataAdapter;
import com.example.miles.fitness4u.R;

import java.util.ArrayList;

/**
 * Created by miles on 5/16/2018.
 */

public class CrunchesFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_bodybody_selection, container, false);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ListView listView = (ListView)getView().findViewById(R.id.listView);

        ArrayList<BodyBuildingSelection> selected = new ArrayList<BodyBuildingSelection>();

        BodyBuildingSelection crunches = new BodyBuildingSelection("crunches", "This is a test to see if everything is working." +
                "Add this line as well or maybe not, we will find out" +
                "and see if this works as well", R.drawable.crunches);
        selected.add(crunches);

        DataAdapter adapter = new DataAdapter(getContext(), R.layout.row_view, selected);
        listView.setAdapter(adapter);



    }
}
