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

public class BarbellSquatOverheadFragment extends Fragment {

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
        BodyBuildingSelection ChinUps = new BodyBuildingSelection("Situps", "Muscle: glutes",
                "Step 1: Grab a racked bar at shoulder height with a overhand grip that is slightly wider than shoulder width." +
                        "Rotate the elbows underneath the bar to allow your palms to be upwards. This will allow the bar to rest on your shoulders. ",
                "Step 2: After unracking from the bar, place your feet just wider than shoulder width. When squatting down, keep your core tight and your chest high." +
                        "Make sure you have a good balance before attempting to lift the weight. Once you hit the bottom, pause for a second and the quickly push back up to the starting position" +
                        "As you fully stand back up, try to explode and push the bar over your head. Use the momentum to get your arms to fully extend. Pause then slowly bring the weight back to the starting position.", R.drawable.crunches);

        //adds crunches to the array
        selected.add(ChinUps);

        //Creates new adapter and takes all the selected data.
        DataAdapter adapter = new DataAdapter(getContext(), R.layout.row_view, selected);

        //Add the selected data to the adapter;
        listView.setAdapter(adapter);



    }
}
