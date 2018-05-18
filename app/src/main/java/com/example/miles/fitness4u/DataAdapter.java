package com.example.miles.fitness4u;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by miles on 5/17/2018.
 */

public class DataAdapter extends ArrayAdapter<BodyBuildingSelection> {
    Context context;
    int resourceId;

    //Set array list to null
    ArrayList<BodyBuildingSelection> selection = null;

    public DataAdapter(@NonNull Context context, int resourceId, ArrayList<BodyBuildingSelection> selection) {
        super(context, resourceId, selection);
        this.context = context;
        this.resourceId = resourceId;
        this.selection = selection;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        BodyBuildingSelection selected = selection.get(position);

        //If there is nothing there, display the row view
        if (convertView == null)
        {
            //Maybe you can create an if statement that is the convertView equals what it should be then display the data
            convertView = LayoutInflater.from(context).inflate(R.layout.row_view, parent, false);
        }

        //Gives each Textview a variable
        TextView TitleTV = (TextView) convertView.findViewById(R.id.Title);
        TextView mainTextTV = (TextView) convertView.findViewById(R.id.information2);
        TextView mainTextTV2 = (TextView) convertView.findViewById(R.id.information3);
        //TextView mainTextTV3 = (TextView) convertView.findViewById(R.id.information4);
        //TextView mainTextTV4 = (TextView) convertView.findViewById(R.id.information5);
        //TextView mainTextTV5 = (TextView) convertView.findViewById(R.id.information6);
        TextView subHeadTV = (TextView) convertView.findViewById(R.id.subHeader);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.image1);


        //Sets text and image to the selected screen
        TitleTV.setText(selected.title);
        subHeadTV.setText(selected.subHeader);
        mainTextTV.setText(selected.mainText);
        mainTextTV2.setText(selected.mainText2);
        //mainTextTV3.setText(selected.mainText3);
        //mainTextTV4.setText(selected.mainText4);
        //mainTextTV5.setText(selected.mainText5);
        imageView.setImageResource(selected.imageId);

        //Return
        return convertView;
    }
}