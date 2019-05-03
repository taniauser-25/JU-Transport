package com.example.jutransport;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class loginActivity extends AppCompatActivity {
    EditText emailEditText,passwordEditText;
    Button loginButton;
    TextView linkSignUpTextView;
    DatabaseHelper db;
    ViewGroup progressView;
    protected boolean isProgressShowing = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db = new DatabaseHelper(this);
        emailEditText=findViewById(R.id.input_email_editText);
        passwordEditText=findViewById(R.id.input_password_editText);
        loginButton=findViewById(R.id.btn_login);
        linkSignUpTextView=findViewById(R.id.link_signup);

        linkSignUpTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(loginActivity.this,registerActivity.class);
                startActivity(intent);
                finish();
            }
        });
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=emailEditText.getText().toString().trim();
                String pwd = passwordEditText.getText().toString().trim();
                Boolean res = db.checkUser(email, pwd);
                if(res == true)
                {
                    Toast.makeText(loginActivity.this, "Successfully Login!", Toast.LENGTH_SHORT).show();
                    Intent HomePage = new Intent(loginActivity.this,BasicActivity.class);
                    startActivity(HomePage);
                }
                else
                {
                    Toast.makeText(loginActivity.this,"Login Error",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
