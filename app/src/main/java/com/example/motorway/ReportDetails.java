package com.example.motorway;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ReportDetails extends AppCompatActivity {
    TextView msg;
    double latitude, longitude;
    ReportMessage m;

    public void resolve(View view){
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Report");
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
        setContentView(R.layout.activity_report_details);

        int pos = getIntent().getExtras().getInt("pos");
        m = (ReportMessage) MessageDisplay.list.get(pos);

        msg = findViewById(R.id.message_text);
        msg.setText(m.getText());
        latitude = m.getLatitude();
        longitude = m.getLongitude();
    }
}