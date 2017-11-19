package com.queenievatcha.listviewtestapp;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.zip.Inflater;

/**
 * Created by Queenievatcha on 18-Nov-17.
 */

class CustomAdapter extends ArrayAdapter<String> {
    private String[] puppy;
    private String[] description;
    private Integer[] imgID;
    private Activity context;

    CustomAdapter(@NonNull Activity context, String[] puppy, String[] description, Integer[] imgID) {
        super(context, R.layout.custom_row, puppy);

        this.context = context;
        this.puppy = puppy;
        this.description = description;
        this.imgID = imgID;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View r = convertView;
        ViewHolder viewHolder = null;
        if (r == null) {
            LayoutInflater layoutInflater = context.getLayoutInflater();
            r = layoutInflater.inflate(R.layout.custom_row, null, true);
            viewHolder = new ViewHolder(r);
            r.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) r.getTag();
        }

        viewHolder.puppyImage.setImageResource(imgID[position]);
        viewHolder.puppyName.setText(puppy[position]);
        viewHolder.description.setText(description[position]);

        return r;


    }

    class ViewHolder {
        TextView puppyName;
        TextView description;
        ImageView puppyImage;
        ViewHolder(View v) {
            puppyName = v.findViewById(R.id.puppyName);
            description = v.findViewById(R.id.description);
            puppyImage = v.findViewById(R.id.puppyImage);
        }
    }
}
