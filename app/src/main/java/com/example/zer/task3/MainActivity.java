package com.example.zer.task3;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ContactAddFragment.OnClickAddListener,
        ContactListFragment.OnClickAddListener {

    public static final String KEY = "key";

    public ArrayList<Contact> contacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null && savedInstanceState.containsKey(KEY)) {
            contacts = (ArrayList<Contact>) savedInstanceState.getSerializable(KEY);
        } else {
            contacts = new ArrayList();
            fillContacts();
        }

        showFragments();
    }

    private void showFragments() {
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, ContactListFragment.newInstance(contacts))
                    .commit();
        } else {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.land_container, ContactListFragment.newInstance(contacts))
                    .commit();

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.land_det, ContactDetFragment.newInstance(contacts.get(0)))
                    .commit();
        }
    }

    private void fillContacts() {
        for (int i = 0; i < 20; i++) {
            contacts.add(new Contact("test" + i, "test" + i + "@gmail.com", "address" + i,
                    "+3805077489" + (10 + i), android.R.drawable.sym_action_call));
        }
    }

    @Override
    public void onClickAddDet(String name, String email, String address, String phone) {
        contacts.add(new Contact(name, email, address, phone, android.R.drawable.sym_action_call));
    }

    @Override
    public void onClickAdd() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, ContactAddFragment.newInstance())
                .addToBackStack(null)
                .commit();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(KEY, contacts);
    }
}
