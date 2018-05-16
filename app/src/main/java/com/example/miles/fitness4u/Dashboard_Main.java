package com.example.miles.fitness4u;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

/**
 * Created by miles on 5/16/2018.
 */

public class Dashboard_Main  extends AppCompatActivity{

    ArrayList<DashModel> dashModelArrayList;
    RecyclerView recyclerView;
    DashAdapter dashAdapter;

    @Override
    protected void onCreate (Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_dashboard);
        recyclerView = findViewById(R.id.rv1);

        dashModelArrayList = new ArrayList<>();
        String heads[] =  {"Abs", "Bicep", " Chest", "Triceps", "Legs", "Back", "Shoulders"};

        int images[] =  {R.drawable.ic_share, R.drawable.ic_share, R.drawable.ic_share, R.drawable.ic_share, R.drawable.ic_share, R.drawable.ic_share, R.drawable.ic_share};

        for(int count = 0; count < heads.length; count++)
        {
            DashModel dashModel = new DashModel();
            dashModel.setHead(heads[count]);
            dashModel.setImage(images[count]);
            dashModelArrayList.add(dashModel);


            //All Data will be retrieved within the adapter


        }

        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
        dashAdapter = new DashAdapter(dashModelArrayList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(dashAdapter);
    }

}
