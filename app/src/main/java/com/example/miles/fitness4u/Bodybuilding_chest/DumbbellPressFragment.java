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

public class DumbbellPressFragment extends Fragment {

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
        BodyBuildingSelection  DumbbellPress = new BodyBuildingSelection(" DumbbellPress", "Muscle: Pectoralis",
                "Step 1: Lay flat down on the bench while holding a dumbbell in each hand resting onto your thighs." +
                        "Use your thighs to help push up the dumbbell, this is to help ease the bells in front of you at shoulder width distance",
                "Step 2: After successfully lifting them up, have them to the side of your chest creating a 90 degree angle all the while keeping control. This is your start position" +
                        "As you breathe out, focus on using your chest to push them up. Make sure to lock your arms when you reach the top." +
                        "When coming down, go slowly or you may injure yourself. you should end up in your starting position", R.drawable.ic_fitness);

        //adds crunches to the array
        selected.add( DumbbellPress);

        //Creates new adapter and takes all the selected data.
        DataAdapter adapter = new DataAdapter(getContext(), R.layout.row_view, selected);

        //Add the selected data to the adapter;
        listView.setAdapter(adapter);



    }
}
