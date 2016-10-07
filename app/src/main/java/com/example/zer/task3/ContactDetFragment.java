package com.example.zer.task3;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ContactDetFragment extends Fragment {

    private TextView name;
    private TextView email;
    private TextView address;
    private TextView phone;

    private static Contact contactDet;

    public static ContactDetFragment newInstance(Contact contact) {
        contactDet = contact;
        return new ContactDetFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.contact_det, container, false);
        name = (TextView) root.findViewById(R.id.cd_name);
        email = (TextView) root.findViewById(R.id.cd_email);
        address = (TextView) root.findViewById(R.id.cd_address);
        phone = (TextView) root.findViewById(R.id.cd_phone);

        name.setText(contactDet.getName());
        email.setText(contactDet.getEmail());
        address.setText(contactDet.getAddress());
        phone.setText(contactDet.getPhone());

        return root;
    }
}
