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

public class BenchPressFragment extends Fragment {

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
        BodyBuildingSelection BenchPress = new BodyBuildingSelection("BenchPress", "Muscle: Pectoralis",
                "Step 1: As you begin to lay onto the bench, try to arch your back as much as possible to focus your chest more." +
                        "When lifting the bar, bring it above your chest. When doing this exercise, you would want someone to spot you in case of accident",
                "Step 2: Make sure you keep your body and head on the bench as it will potentially injure your body. When going up and down, keep your elbows out." +
                        " Come down to the lower part of your chest. As you come up, try to have it end with it being on the upper level of your chest.", R.drawable.ic_fitness);

        //adds crunches to the array
        selected.add(BenchPress);

        //Creates new adapter and takes all the selected data.
        DataAdapter adapter = new DataAdapter(getContext(), R.layout.row_view, selected);

        //Add the selected data to the adapter;
        listView.setAdapter(adapter);



    }
}
