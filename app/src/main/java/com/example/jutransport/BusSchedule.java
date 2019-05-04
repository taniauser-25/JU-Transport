package com.example.jutransport;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class BusSchedule extends AppCompatActivity {
    TextView CtoD,DtoC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_schedule);
        CtoD=findViewById(R.id.CtoD);
        DtoC=findViewById(R.id.DtoC);
        CtoD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(BusSchedule.this,CampusToDhaka.class);
                startActivity(intent);
            }
        });
        DtoC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(BusSchedule.this,DhakaToCampus.class);
                startActivity(intent);
            }
        });
    }
}
