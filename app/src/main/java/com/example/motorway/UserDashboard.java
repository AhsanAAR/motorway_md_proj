package com.example.motorway;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class UserDashboard extends AppCompatActivity {

    public void help(View view){
        Intent i = new Intent(getApplication(), MessageUpload.class);
        i.putExtra("type", "Help");
        startActivity(i);
    }

    public void report(View view){
        Intent i = new Intent(getApplication(), MessageUpload.class);
        i.putExtra("type", "Report");
        startActivity(i);
    }

    public void info(View view){
        Intent i = new Intent(getApplication(), MessageUpload.class);
        i.putExtra("type", "Info");
        startActivity(i);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dashboard);
    }
}