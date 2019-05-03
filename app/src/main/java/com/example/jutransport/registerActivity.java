package com.example.jutransport;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class registerActivity extends AppCompatActivity {
    EditText emailEditText,passwordEditText,cnfConfirmPassword,mobileEditText;
    Button signupButton;
    TextView linkloginTextView;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        db = new DatabaseHelper(this);
        emailEditText=findViewById(R.id.input_email_editText);
        mobileEditText=findViewById(R.id.input_mobile_editText);
        passwordEditText=findViewById(R.id.input_password_editText);
        cnfConfirmPassword=findViewById(R.id.input_cnf_password_editText);
        signupButton=findViewById(R.id.btn_signup);
        linkloginTextView=findViewById(R.id.link_login);
        linkloginTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(registerActivity.this,loginActivity.class);
                startActivity(intent);
            }
        });
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean error = false;
                String email = emailEditText.getText().toString().trim();
                 String mobile=mobileEditText.getText().toString().trim();
                String pwd = passwordEditText.getText().toString().trim();
                String cnf_pwd = cnfConfirmPassword.getText().toString().trim();

                if(pwd.equals(cnf_pwd)){
                    long val = db.addUser(email,mobile,pwd);
                    if(val > 0){
                        if(email.isEmpty()){
                            emailEditText.setError("Email is empty!");
                            error = true;
                        }else{
                            if(email.length()<6){
                                emailEditText.setError("Email is too short!");
                                error = true;
                            }
                        }
                        if(mobile.isEmpty()){
                            mobileEditText.setError("Phone No is required!");
                            error = true;
                        }else if(mobile.length()==11){
                            if(mobile.startsWith("017") || mobile.startsWith("015")|| mobile.startsWith("019")|| mobile.startsWith("016") || mobile.startsWith("018")){

                            }else{
                                mobileEditText.setError("Phone No is not valid!");
                                error = true;
                            }
                        }else{
                            mobileEditText.setError("Phone No should be 11 digit!");
                            error = true;
                        }
                        if(email.isEmpty()){
                            emailEditText.setError("Email is missing!");
                            error = true;
                        }else if(email.length()>30){
                            emailEditText.setError("Email should have max 30 characters!");
                            error = true;
                        }
                        if(error){
                            Toast.makeText(registerActivity.this, "Please insert proper data!", Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(registerActivity.this,"You have registered",Toast.LENGTH_SHORT).show();
                            Intent moveToLogin = new Intent(registerActivity.this,loginActivity.class);
                            startActivity(moveToLogin);
                        }
                    }
                }
                else{
                    Toast.makeText(registerActivity.this,"Password is not matching",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
