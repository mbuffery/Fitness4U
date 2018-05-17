package com.example.miles.fitness4u.Bodybuilding_abs;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.miles.fitness4u.BodyBuildingSelection;
import com.example.miles.fitness4u.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by miles on 5/16/2018.
 */

public class CrunchesFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_bodybody_selection, container, false);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ListView listView = (ListView)getView().findViewById(R.id.listView);

        ArrayList<BodyBuildingSelection> selected = new ArrayList<BodyBuildingSelection>();



    }
}
