package com.example.prog5.secondtask;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayContact extends AppCompatActivity {
    TextView nameField, phoneField;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_contact);
        nameField=(TextView)findViewById(R.id.txtContactName);
        phoneField=(TextView)findViewById(R.id.txtContactPhone);

        Intent recieve = getIntent();

        String name = (String) recieve.getExtras().get("name");
        String phone = (String) recieve.getExtras().get("phone");

        nameField.setText(name);
        phoneField.setText(phone);

    }
}
