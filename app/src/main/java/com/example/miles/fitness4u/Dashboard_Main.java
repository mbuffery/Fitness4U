package com.example.miles.fitness4u;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

/**
 * Created by miles on 5/16/2018.
 */

public class Dashboard_Main  extends AppCompatActivity{

    ArrayList<DashModel> dashModelArrayList;
    RecyclerView recyclerView;

    @Override
    protected void onCreate (Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_dashboard);
        recyclerView = findViewById(R.id.rv1);

        dashModelArrayList = new ArrayList<>();
        String heads[] =  {"Abs", "Bicep", " Chest", "Triceps", "Settings"}
    }

}
