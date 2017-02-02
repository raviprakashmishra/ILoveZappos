package com.example.rpmnitp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rpmnitp.ilovezappos.R;
import com.example.rpmnitp.processing.Product;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by dell on 2/1/2017.
 */

public class SearchResultArrayAdapter extends ArrayAdapter<Product> {
    private final Context context;
    private final List<Product> values;
    public SearchResultArrayAdapter(Context context, List<Product> values) {
        super(context, R.layout.search_result, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.search_result, parent, false);

        TextView textView = (TextView) rowView.findViewById(R.id.label);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);

        Picasso.with(context).load(values.get(position).getThumbnailImageUrl()).into(imageView);
        textView.setText(values.get(position).getBrandName());


        return rowView;
    }
}