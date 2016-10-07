package com.example.zer.task3;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ContactListFragment extends Fragment {

    private static ArrayList<Contact> contactArray;

    private ListView contactList;
    private ContactAdapter adapter;
    private Button add;

    private OnClickAddListener listener;

    public static ContactListFragment newInstance(ArrayList<Contact> list) {
        contactArray = list;
        return new ContactListFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.contact_list, container, false);
        contactList = (ListView) root.findViewById(R.id.cl_contact_list);
        add = (Button) root.findViewById(R.id.cl_add);

        adapter = new ContactAdapter(getContext(), contactArray);
        contactList.setAdapter(adapter);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClickAdd();
            }
        });

        contactList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (getContext().getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
                    getActivity().getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.container, ContactDetFragment.newInstance(adapter.getItem(position)))
                            .addToBackStack(null)
                            .commit();
                } else {
                    getActivity().getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.land_det, ContactDetFragment.newInstance(adapter.getItem(position)))
                            .commit();
                }
            }
        });

        return root;
    }

    public interface OnClickAddListener {
        void onClickAdd();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (OnClickAddListener) context;
    }
}
