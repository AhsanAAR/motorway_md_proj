package com.example.motorway;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class HelpDetails extends AppCompatActivity {
    TextView reg_num, msg, name, phone_num;
    double latitude, longitude;
    HelpMessage m;
    DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Users");

    public void resolve(View view){
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Help");
        reference.child(m.getMsgID()).removeValue();
        finish();
    }

    public void showLocation(View view){
        Intent i = new Intent(getApplicationContext(), MapsActivity.class);
        i.putExtra("lat", latitude);
        i.putExtra("long", longitude);
        startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_details);
        int pos = getIntent().getExtras().getInt("pos");
        m = (HelpMessage) MessageDisplay.list.get(pos);

        reg_num = findViewById(R.id.registration_text);
        msg = findViewById(R.id.message_text);
        name = findViewById(R.id.name_text);
        phone_num  = findViewById(R.id.phone_text);

        reg_num.setText(m.getRegistrationNumber());
        msg.setText(m.getText());
        latitude = m.getLatitude();
        longitude = m.getLongitude();

        reference.child(m.getUId()).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if(task.isSuccessful()) {
                    User u = task.getResult().getValue(User.class);
                    name.setText(u.getName());
                    phone_num.setText(u.getPhoneNumber());
                }
            }
        });
    }
}