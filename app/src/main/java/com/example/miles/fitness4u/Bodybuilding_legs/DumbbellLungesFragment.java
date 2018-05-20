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

public class DumbbellLungesFragment extends Fragment {

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
        BodyBuildingSelection ChinUps = new BodyBuildingSelection("Situps", "Muscle: Quadriceps",
                "Step 1: Stand up straight with two dumbbells on both sides. Begin to lunge forward on one leg." +
                        "Make sure your heel comes into first contact with the floor then the forefoot. As you are bending your knees," +
                        "try to keep your back straight.",
                "Step 2: Keep lowering your body until your knee comes near to the floor. Start to return to your normal position and" +
                        "repeat with the other leg.", R.drawable.crunches);

        //adds crunches to the array
        selected.add(ChinUps);

        //Creates new adapter and takes all the selected data.
        DataAdapter adapter = new DataAdapter(getContext(), R.layout.row_view, selected);

        //Add the selected data to the adapter;
        listView.setAdapter(adapter);



    }
}
