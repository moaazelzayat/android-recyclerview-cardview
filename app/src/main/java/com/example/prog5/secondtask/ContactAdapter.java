package com.example.prog5.secondtask;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by prog5 on 3/19/2018.
 */

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.MyViewHolder> {



    private List<Contact> contacts;
    private Context context;



    public ContactAdapter(List<Contact> contacts, Context context) {
        this.contacts = contacts;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_layout, parent, false);
        return new MyViewHolder(row);
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final Contact contact = contacts.get(position);
        holder.contactName.setText(contact.getName());
        holder.contactPhone.setText(Integer.toString(contact.getPhone()));
        holder.contactPhoto.setImageResource(contact.getImageId());

        holder.call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final int REQUEST_PHONE_CALL = 1;
                Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.parse(
                        "tel:" + Integer.toString(contact.getPhone())));

                if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (ContextCompat.checkSelfPermission((Activity)context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.CALL_PHONE},REQUEST_PHONE_CALL);
                    }
                    else
                    {
                        context.startActivity(callIntent);
                    }
                }
                else
                {
                    context.startActivity(callIntent);
                }
            }
        });

        holder.msg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final int REQUEST_SEND_SMS = 2;
                Intent sendSmsIntent = new Intent(Intent.ACTION_VIEW);
                sendSmsIntent.putExtra("sms_body", "Type Message here");
                sendSmsIntent.putExtra("address", Integer.toString(contact.getPhone()));
                sendSmsIntent.setType("vnd.android-dir/mms-sms");


                if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (ContextCompat.checkSelfPermission((Activity)context, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.SEND_SMS},REQUEST_SEND_SMS);
                    }
                    else
                    {
                        context.startActivity(sendSmsIntent);
                    }
                }
                else
                {
                    context.startActivity(sendSmsIntent);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView contactName, contactPhone;
        ImageView contactPhoto;
        Button call, msg;

        public MyViewHolder(View itemView) {
            super(itemView);
            contactName=(TextView)itemView.findViewById(R.id.person_name);
            contactPhone=(TextView)itemView.findViewById(R.id.person_phone);
            contactPhoto=(ImageView)itemView.findViewById(R.id.person_photo);
            call=(Button)itemView.findViewById(R.id.call_button);
            msg=(Button)itemView.findViewById(R.id.msg_button);
        }


    }
}
