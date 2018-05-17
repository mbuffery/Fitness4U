package com.example.miles.fitness4u.Bodybuilding_abs;

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

public class InclineBenchSitupsFragment extends Fragment {

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
        ArrayList<BodyBuildingSelection> selected = new ArrayList<BodyBuildingSelection>();
        //Crunches will display 2 textview and one image
        BodyBuildingSelection crunches = new BodyBuildingSelection("Crunches", "Muscle: Rectus Abdominis", "Place your hands above your head",
                "How about this, will this work please work",
                "Keeping your arms parallel to the floor", "Increase the amount of work", "All this works",  R.drawable.crunches);
        //adds crunches to the array
        selected.add(crunches);
        //Creates new adapter and takes all the selected data.
        DataAdapter adapter = new DataAdapter(getContext(), R.layout.row_view, selected);
        //Add the selected data to the adapter;
        listView.setAdapter(adapter);





    }
}
