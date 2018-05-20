package com.example.miles.fitness4u.Bodybuilding_shoulder;

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

public class BarbellLateralRaisesFragment extends Fragment {

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
        BodyBuildingSelection BarbellLateralRaises = new BodyBuildingSelection("Barbell Lateral Raises", "Muscle: Deltoids",
                "Step 1: Stand up straight with a shoulder width apart grip. Have your arms hang down until it reaches your thigh." +
                        "Make sure you keep your whole body looking forward, heda up straight, shoulders back and chest up.",
                "Step 2: Begin to raise your arms to out in front of you until it reaches just above your shoulder height." +
                        "Pause, then slowly go back to your starting position.", R.drawable.crunches);

        //adds crunches to the array
        selected.add(BarbellLateralRaises);

        //Creates new adapter and takes all the selected data.
        DataAdapter adapter = new DataAdapter(getContext(), R.layout.row_view, selected);

        //Add the selected data to the adapter;
        listView.setAdapter(adapter);



    }
}
