package com.example.miles.fitness4u.Bodybuilding_legs;

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

public class AngledLegPressFragment extends Fragment {

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
        BodyBuildingSelection AngledLeg = new BodyBuildingSelection("Angled Leg Press", "Muscle: Glutes",
                "Step 1: This machine is pretty straight forward but a main tip is to never fully lock out your legs otherwise it could create serious problems." +
                        "Once sat into the machine, place your legs at shoulder width distance. Once lowering the safety bars, push the weight up until the legs are almost fully extended." +
                        "This is your stating position.",
                "Step 2: As you inhale, start to lower your legs until they make a 90 degree angle." +
                        "When pushing, make sure you use your heels. While pushing, slowly exhale" +
                        "", R.drawable.crunches);

        //adds crunches to the array
        selected.add(AngledLeg);

        //Creates new adapter and takes all the selected data.
        DataAdapter adapter = new DataAdapter(getContext(), R.layout.row_view, selected);

        //Add the selected data to the adapter;
        listView.setAdapter(adapter);



    }
}
