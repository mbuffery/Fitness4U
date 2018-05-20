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

public class LowLateralRaisesFragment extends Fragment {

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
        BodyBuildingSelection LowLateralRaises = new BodyBuildingSelection("Low Lateral Raises", "Muscle: Deltoids",
                "Step 1: Start with the side of your body facing the machine/weights. Start with any arm that has to come across your body in order to reach the grip." +
                        "If you want better support, use the other arm to hold onto the machine.",
                "Step 2: Have your feet shoulder width apart from one another. Start to lift the weight by pulling it across your body until it is shoulder height." +
                        "Pause, then slowly go down to starting position.", R.drawable.ic_fitness);

        //adds crunches to the array
        selected.add(LowLateralRaises);

        //Creates new adapter and takes all the selected data.
        DataAdapter adapter = new DataAdapter(getContext(), R.layout.row_view, selected);

        //Add the selected data to the adapter;
        listView.setAdapter(adapter);



    }
}
