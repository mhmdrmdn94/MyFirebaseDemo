package com.example.mohamed.myfirebase;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by mohamed on 04/03/2017.
 */

public class ListViewHolder {

    View convertedView;
    TextView phone, name;

    public ListViewHolder(View view)
    {
        convertedView = view ;
    }


    public TextView getPhone() {
        if( phone == null)
            phone = (TextView) convertedView.findViewById(R.id.list_contact_phone);
        return phone;
    }

    public void setPhone(TextView phone) {
        this.phone = phone;
    }

    public TextView getName() {
        if( name == null)
            name = (TextView) convertedView.findViewById(R.id.list_contact_name);
        return name;
    }

    public void setName(TextView name) {
        this.name = name;
    }
}
