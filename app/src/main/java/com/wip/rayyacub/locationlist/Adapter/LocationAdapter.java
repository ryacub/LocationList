package com.wip.rayyacub.locationlist.Adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wip.rayyacub.locationlist.Model.LocationData;
import com.wip.rayyacub.locationlist.R;

import java.util.ArrayList;
import java.util.List;

public class LocationAdapter extends RecyclerView.Adapter<LocationAdapter.LocationViewHolder> {

    private List<LocationData> locationData = new ArrayList<>();
    private Context context;

    public LocationAdapter(List<LocationData> locationData, Context context) {
        this.locationData = locationData;
        this.context = context;
    }

    @Override
    public LocationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);
        return new LocationViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(LocationViewHolder holder, int position) {
        //getting the image string for glide.
        String iconString = locationData.get(position).getIcon();
        Glide.with(context)
                .load(iconString)
                .into(holder.icon);
        holder.name.setText(locationData.get(position).getName());
        holder.date.setText(locationData.get(position).getEndDate());
        //venue field returns no value, therefore no values can be set dynamically.
        holder.cityState.setText(R.string.default_location);

    }

    @Override
    public int getItemCount() {
        return locationData.size();
    }

    //rv view holder
    class LocationViewHolder extends RecyclerView.ViewHolder {
        ImageView icon;
        TextView name;
        TextView cityState;
        TextView date;

        public LocationViewHolder(View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.icon);
            name = itemView.findViewById(R.id.name);
            date = itemView.findViewById(R.id.date);
            cityState = itemView.findViewById(R.id.city_state);
        }
    }

}
