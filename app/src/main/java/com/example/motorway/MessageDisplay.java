package com.example.motorway;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MessageDisplay extends AppCompatActivity {
    DatabaseReference reference;
    RecyclerView recyclerView;
    Adapter adapter;
    ArrayList<Message> list;
    String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_display);
        Bundle b = getIntent().getExtras();
        type = b.getString("type");

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        adapter = new Adapter(this, list);
        recyclerView.setAdapter(adapter);

        reference = FirebaseDatabase.getInstance().getReference(type);
        reference.addValueEventListener(new ValueEventListener() {

            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list.clear();
                for(DataSnapshot d: snapshot.getChildren()){
                    Message m =  d.getValue(Message.class);
                    list.add(m);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}