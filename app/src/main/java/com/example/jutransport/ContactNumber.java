package com.example.jutransport;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

public class ContactNumber extends AppCompatActivity {
    ImageView makeCall1,makeCall2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_number);
        makeCall1=findViewById(R.id.makeCall_button1);
        makeCall2=findViewById(R.id.makeCall_button2);

        makeCall1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                        Intent callIntent = new Intent(Intent.ACTION_DIAL);
                        callIntent.setData(Uri.parse("tel: 01939507607"));
                        startActivity(callIntent);
            }
        });
        makeCall2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel: 01670082545"));
                startActivity(callIntent);
            }
        });

    }
}
