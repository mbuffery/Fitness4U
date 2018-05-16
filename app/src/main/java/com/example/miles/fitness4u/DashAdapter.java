package com.example.miles.fitness4u;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by miles on 5/16/2018.
 */

public class DashAdapter extends RecyclerView.Adapter<DashAdapter.ViewHolder>{

    ArrayList<DashModel> dashModelArrayList;

    public DashAdapter(ArrayList<DashModel> dashModelArrayList) {
        this.dashModelArrayList = dashModelArrayList;
    }

    @Override
    public DashAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DashAdapter.ViewHolder holder, int position) {

        String ret_head = dashModelArrayList.get(position).getHead();
        holder.setHeader(ret_head);


    }

    @Override
    public int getItemCount() {
        return dashModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView header;
        ImageView images;
        View myView;

        public ViewHolder(View itemView) {
            super(itemView);
            myView = itemView;
        }

        public void setHeader (String h)
        {
            header = myView.findViewById(R.id.header);
            header.setText(h);
        }
        public void setImage (int i)
        {
            images = myView.findViewById(R.id.dash_abs);
            images.setImageResource(i);
        }
    }
}
