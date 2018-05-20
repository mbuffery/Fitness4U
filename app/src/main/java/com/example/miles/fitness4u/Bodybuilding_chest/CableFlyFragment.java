package com.example.miles.fitness4u.Bodybuilding_chest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.example.miles.fitness4u.BodyBuildingSelection;
import com.example.miles.fitness4u.DataAdapter;
import com.example.miles.fitness4u.R;

import java.util.ArrayList;

/**
 * Created by miles on 5/16/2018.
 */

public class CableFlyFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_bodybody_selection, container, false);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //Sets the listview of the xml to listview
        ListView listView = getView().findViewById(R.id.listView);

        //New array for BodyBuildingSelection
        ArrayList<BodyBuildingSelection> selected = new ArrayList<>();

        //Crunches will display 3 textview and one image
        BodyBuildingSelection CableFly = new BodyBuildingSelection("CableFly", "Muscle: Latissimus Dorsi",
                "Step 1: Place pulleys at a high position before starting (above your head). While holding both cables, step forward" +
                        " between both pulleys equally and bring the cables in front of you ",
                "Step 2: Slightly bend your elbows to stop any major stress on the tendon. Extend both arms to the side creating a wide arc which will stretch your chest." +
                        "Make sure that you only use your shoulder joints and not the arms or torso. Return to starting position and start again.", R.drawable.ic_fitness);

        //adds crunches to the array
        selected.add(CableFly);

        //Creates new adapter and takes all the selected data.
        DataAdapter adapter = new DataAdapter(getContext(), R.layout.row_view, selected);

        //Add the selected data to the adapter;
        listView.setAdapter(adapter);



    }
}
