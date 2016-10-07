package com.example.zer.task3;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ContactAdapter extends ArrayAdapter<Contact> {

    public ContactAdapter(Context context, List<Contact> contacts) {
        super(context, R.layout.list_item, contacts);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        View rowView = convertView;

        if (rowView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            rowView = layoutInflater.inflate(R.layout.list_item, parent, false);

            holder = new ViewHolder();
            holder.image = (ImageView) rowView.findViewById(R.id.li_image);
            holder.name = (TextView) rowView.findViewById(R.id.li_name);
            holder.email = (TextView) rowView.findViewById(R.id.li_email);

            rowView.setTag(holder);
        } else {
            holder = (ViewHolder) rowView.getTag();
        }

        holder.image.setImageDrawable(ContextCompat.getDrawable(getContext(), getItem(position).getImage()));
        holder.name.setText(getItem(position).getName());
        holder.email.setText(getItem(position).getEmail());

        return rowView;
    }

    private static class ViewHolder {
        public ImageView image;
        public TextView name;
        public TextView email;
    }
}
