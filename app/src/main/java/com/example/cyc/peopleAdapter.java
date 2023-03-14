package com.example.cyc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class peopleAdapter extends ArrayAdapter<people> {
    private int resourceId;

    public peopleAdapter(Context context, int textViewResourceId, List<people> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        people people = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
        ImageView peopleImage = (ImageView) view.findViewById(R.id.people_image);
        TextView peopleName = (TextView) view.findViewById(R.id.people_name);
        peopleName.setText(people.getName());

        peopleImage.setImageResource((people.getImageId()));
        return view;
    }
}
