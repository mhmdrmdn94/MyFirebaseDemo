package com.example.mohamed.myfirebase;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Created by mohamed on 04/03/2017.
 */

public class ListCustomAdapter extends ArrayAdapter<Contact> {

    ArrayList<Contact> contacts;
    private Context context;

    public ListCustomAdapter(Context context,ArrayList<Contact> contacts) {
        super(context, R.layout.list_item, R.id.list_contact_name, contacts);
        this.context = context;
        this.contacts = contacts;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View rowView = convertView;
        ListViewHolder viewHolder;

        if (rowView == null)
        {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            rowView = layoutInflater.inflate(R.layout.list_item, parent, false);

            viewHolder = new ListViewHolder(rowView);

            rowView.setTag(viewHolder);
        }
        else {
                viewHolder = (ListViewHolder) rowView.getTag();
        }

        viewHolder.getName().setText(   contacts.get(position).getFullName() );
        viewHolder.getPhone().setText(    contacts.get(position).getPhone()  );

        return  rowView;
    }


}
