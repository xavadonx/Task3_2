package com.example.zer.task3;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class ContactAddFragment extends Fragment {

    private EditText name;
    private EditText email;
    private EditText address;
    private EditText phone;
    private Button add;

    private OnClickAddListener listener;

    public static ContactAddFragment newInstance() {
        return new ContactAddFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.contact_add, container, false);
        name = (EditText) root.findViewById(R.id.ca_name);
        email = (EditText) root.findViewById(R.id.ca_email);
        address = (EditText) root.findViewById(R.id.ca_address);
        phone = (EditText) root.findViewById(R.id.ca_phone);
        add = (Button) root.findViewById(R.id.ca_add);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClickAddDet(name.getText().toString(), email.getText().toString(),
                        address.getText().toString(), phone.getText().toString());
            }
        });

        return root;
    }

    public interface OnClickAddListener {
        void onClickAddDet(String name, String email, String address, String phone);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (OnClickAddListener) context;
    }
}
