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
        if (convertView == null)
        {
            convertView = LayoutInflater.from(context).inflate(R.layout.row_view, parent, false);
        }

        TextView TitleTV = (TextView) convertView.findViewById(R.id.Title);
        TextView mainTextTV = (TextView) convertView.findViewById(R.id.mainInformation);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.image1);

        TitleTV.setText(selected.title);
        mainTextTV.setText(selected.mainText);
        imageView.setImageResource(selected.imageId);

        return convertView;
    }
}