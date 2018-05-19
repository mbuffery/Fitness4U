package com.example.miles.fitness4u.Bodybuilding_back;

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

public class OneArmRowFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_bodybody_selection, container, false);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //Sets the listview of the xml to listview
        ListView listView = (ListView)getView().findViewById(R.id.listView);

        //New array for BodyBuildingSelection
        ArrayList<BodyBuildingSelection> selected = new ArrayList<>();

        //Crunches will display 3 textview and one image
        BodyBuildingSelection OneArmRow = new BodyBuildingSelection("One Arm Row", "Muscle: Latissimus Dorsi",
                "Step 1: Place one hand and knee onto a bench. Have a dumbbell in the other arm with the other foot flat down on the floor",
                "Step 2: Keep you back flat as the dumbbell hangs down. Pull the dumbbell upwards and towards your hips all while keeping your back straight. Return to position" +
                        "and repeat 8 more times then swap arms", R.drawable.crunches);

        //adds crunches to the array
        selected.add(OneArmRow);

        //Creates new adapter and takes all the selected data.
        DataAdapter adapter = new DataAdapter(getContext(), R.layout.row_view, selected);

        //Add the selected data to the adapter;
        listView.setAdapter(adapter);





    }

}
