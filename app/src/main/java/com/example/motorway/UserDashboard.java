package com.example.motorway;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.database.core.Repo;

public class UserDashboard extends AppCompatActivity {
    public static String UID;

    public void help(View view){
        Intent i = new Intent(getApplication(), HelpUpload.class);
        startActivity(i);
    }

    public void report(View view){
        Intent i = new Intent(getApplication(), ReportUpload.class);
        startActivity(i);
    }

    public void info(View view){
        Intent i = new Intent(getApplication(), InformationUpload.class);
        startActivity(i);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dashboard);
    }
}