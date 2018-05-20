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

public class InclinePressFragment extends Fragment {

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
        BodyBuildingSelection InclinePress = new BodyBuildingSelection("InclinePress", "Muscle: Pectoralis",
                "Step 1: Lie on the bench while having your feet flat on the ground. Make sure your back is arched and that you are pushing through your hips" +
                        "Grab the bar at a medium width and then proceed to bring it off the rack. Have it above your chest with your arms fully extended. This is your starting position",
                "Step 2: Start to lower the bar until it reaches just above you chest. Little tip: Don't bounce the weight off your chest otherwise you lose out." +
                        "After touching your upper chest, begin to push up slowly until you reach the starting position", R.drawable.ic_fitness);

        //adds crunches to the array
        selected.add(InclinePress);

        //Creates new adapter and takes all the selected data.
        DataAdapter adapter = new DataAdapter(getContext(), R.layout.row_view, selected);

        //Add the selected data to the adapter;
        listView.setAdapter(adapter);



    }
}
