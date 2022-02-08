package com.example.motorway;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Reportdetails extends AppCompatActivity {
    TextView msg;
    double latitude, longitude;

    public void showLocation(View view){
        Uri u = Uri.parse("geo:"+latitude+","+longitude);
        Intent i = new Intent(Intent.ACTION_VIEW, u);
        startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_details);

        int pos = getIntent().getExtras().getInt("pos");
        ReportMessage m = (ReportMessage) MessageDisplay.list.get(pos);

        msg = findViewById(R.id.message_text);
        msg.setText(m.getText());
        latitude = m.getLatitude();
        longitude = m.getLongitude();
    }
}