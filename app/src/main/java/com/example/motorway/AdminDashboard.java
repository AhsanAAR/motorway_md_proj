package com.example.motorway;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class AdminDashboard extends AppCompatActivity {

    public void help(View view){
        Intent i = new Intent(getApplication(), MessageDisplay.class);
        i.putExtra("type", "Help");
        startActivity(i);
    }

    public void report(View view){
        Intent i = new Intent(getApplication(), MessageDisplay.class);
        i.putExtra("type", "Report");
        startActivity(i);
    }

    public void info(View view){
        Intent i = new Intent(getApplication(), MessageDisplay.class);
        i.putExtra("type", "Info");
        startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);
    }
}