package com.example.motorway;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    EditText mname, memail, mpassword, mphone;
    Button mRegisterBtn;
    TextView mLoginBtn;
    FirebaseAuth fAuth;

    public void loginClicked(View view){
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mname = findViewById(R.id.name_id);
        memail = findViewById(R.id.email_id);
        mpassword = findViewById(R.id.password_id);
        mphone = findViewById(R.id.phone_id);

        mRegisterBtn = findViewById(R.id.register_button_id);

        fAuth = FirebaseAuth.getInstance();

        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = memail.getText().toString().trim();
                String password = mpassword.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    mpassword.setError("Email is Required");
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    memail.setError("Password is Required");
                    return;
                }
                if(password.length() < 6){
                    mpassword.setError("Password must be at at least 6 character long");
                    return;
                }
                fAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(getApplicationContext(), "User Created", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                        else{
                            Toast.makeText(getApplicationContext(), "ERROR" +task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}