package com.example.motorway;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    EditText email_text, password_text;
    ProgressBar progressBar;
    FirebaseAuth mAuth;

    public void registerClicked(View view){
        startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
    }

    public void login(View view){
        String email = email_text.getText().toString().trim();
        String password = password_text.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            email_text.setError("Email is Required");
            return;
        }
        if(TextUtils.isEmpty(password)){
            password_text.setError("Password is Required");
            return;
        }

        if(password.length() < 6){
            password_text.setError("Password must be at at least 6 character long");
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        // authenticate the login credentials

        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(getApplicationContext(), "Login successful", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "ERROR" +
                            task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
                progressBar.setVisibility(View.INVISIBLE);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email_text = findViewById(R.id.email_id);
        password_text = findViewById(R.id.password_id);
        progressBar = findViewById(R.id.progressBar);
        mAuth = FirebaseAuth.getInstance();




    }
}