package com.example.prog5.secondtask;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Contact> contacts = new ArrayList<>();
    RecyclerView recyclerView;
    ContactAdapter contactAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=(RecyclerView)findViewById(R.id.recycler_view);
        contactAdapter = new ContactAdapter(contacts, this);

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(contactAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new ClickListener() {

            @Override
            public void onClick(View view, int position) {
                Contact contact = contacts.get(position);
                Toast.makeText(getApplicationContext(),
                        contact.getName() + " is selected!" + "\n" + contact.getPhone() ,
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {
                Contact contact = contacts.get(position);
                Intent openDisplayActivity = new Intent(
                        MainActivity.this, DisplayContact.class);

                openDisplayActivity.putExtra("name", contact.getName());
                openDisplayActivity.putExtra("phone", Integer.toString(contact.getPhone()));

                startActivity(openDisplayActivity);


            }
        }));

        initalizeData();
    }

    private void initalizeData() {
        Contact contact = new Contact("Ahmed", 12345, R.drawable.a);
        contacts.add(contact);

        contact = new Contact("Mohamed", 5000, R.drawable.b);
        contacts.add(contact);

        contact = new Contact("Mahmoud", 12345, R.drawable.c);
        contacts.add(contact);

        contact = new Contact("Omar", 458, R.drawable.d);
        contacts.add(contact);

        contact = new Contact("Ali", 165, R.drawable.e);
        contacts.add(contact);

        contact = new Contact("Khaled", 259, R.drawable.f);
        contacts.add(contact);

        contact = new Contact("Taha", 645, R.drawable.g);
        contacts.add(contact);

        contact = new Contact("Sameer", 523, R.drawable.h);
        contacts.add(contact);

        contactAdapter.notifyDataSetChanged();

    }
}
