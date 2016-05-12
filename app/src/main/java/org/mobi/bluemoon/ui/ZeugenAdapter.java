package org.mobi.bluemoon.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.mobi.bluemoon.R;

import java.util.ArrayList;

/**
 * Created by Adrian on 5/12/2016.
 */
public class ZeugenAdapter extends ArrayAdapter<ZeugenItem> {

    private final Context context;
    private final ArrayList<ZeugenItem> itemsArrayList;

    public ZeugenAdapter(Context context, ArrayList<ZeugenItem> itemsArrayList) {

        super(context, R.layout.zeugen_list_item, itemsArrayList);

        this.context = context;
        this.itemsArrayList = itemsArrayList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // 1. Create inflater
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // 2. Get rowView from inflater
        View rowView = inflater.inflate(R.layout.zeugen_list_item, parent, false);

        // 3. Get the two text view from the rowView
        TextView labelView = (TextView) rowView.findViewById(R.id.label);
        TextView valueView = (TextView) rowView.findViewById(R.id.value);

        // 4. Set the text for textView
        labelView.setText(itemsArrayList.get(position).getTitle());
        valueView.setText(itemsArrayList.get(position).getDescription());

        // 5. retrn rowView
        return rowView;
    }
}