package com.example.jutransport;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void login(View view) {
        Intent intent=new Intent(HomeActivity.this,loginActivity.class);
        startActivity(intent);
    }

    public void register(View view) {
        Intent intent=new Intent(HomeActivity.this,registerActivity.class);
        startActivity(intent);
    }

    public void logout(View view) {
        Intent intent=new Intent(HomeActivity.this,logoutActivity.class);
        startActivity(intent);
    }
}
