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

public class SeatedFlyFragment extends Fragment {

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
        BodyBuildingSelection SeatedFly = new BodyBuildingSelection("Situps", "Muscle: Pectoralis",
                "Step 1: Sit at the end of a flat bench with your legs together while holding the dumbbells behind your calves." +
                        "Start to bend at your waist while keeping your back straight. Pick up the dumbbells with your palms of the hand facing you. This is your starting position",
                "Step 2: Lift the dumbbells with a slight blend in your elbows until your arms are parallel to the floor. Make sure to keep your breathing in check." +
                        "After pausing for a second, slowing bring them back down into the starting position", R.drawable.crunches);

        //adds crunches to the array
        selected.add(SeatedFly);

        //Creates new adapter and takes all the selected data.
        DataAdapter adapter = new DataAdapter(getContext(), R.layout.row_view, selected);

        //Add the selected data to the adapter;
        listView.setAdapter(adapter);



    }
}
