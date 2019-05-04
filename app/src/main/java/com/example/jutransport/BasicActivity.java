package com.example.jutransport;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BasicActivity extends AppCompatActivity {
    Button busScheduleButton,contactNuberButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic);
        busScheduleButton=findViewById(R.id.busScedule_button);
        contactNuberButton=findViewById(R.id.contactNumber_button);
        busScheduleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(BasicActivity.this,BusSchedule.class);
                startActivity(intent);
            }
        });
        contactNuberButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(BasicActivity.this,ContactNumber.class);
                startActivity(intent);
            }
        });
    }
}
