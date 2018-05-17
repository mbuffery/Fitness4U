package com.example.miles.fitness4u.Bodybuilding_abs;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.miles.fitness4u.BodyBuildingSelection;
import com.example.miles.fitness4u.R;

import java.util.ArrayList;

/**
 * Created by miles on 5/16/2018.
 */

public class CrunchesFragment extends ArrayAdapter<BodyBuildingSelection> {
    Context context;
    int resource;
    ArrayList<BodyBuildingSelection> selection = null;

    public CrunchesFragment(@NonNull Context context, int resource, ArrayList<BodyBuildingSelection> selection) {
        super(context, resource);
    }
}
