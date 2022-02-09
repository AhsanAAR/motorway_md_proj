package com.example.motorway;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

public class ReportUpload extends AppCompatActivity {
    EditText report;
    Location location_current;
    public void sendMessage(View view){
        String rprt = report.getText().toString().trim();
        if(TextUtils.isEmpty(rprt)){
            report.setError("Report Message is Required");
            return;
        }

        int p = ContextCompat.checkSelfPermission(getApplicationContext(),
                Manifest.permission.ACCESS_FINE_LOCATION);
        if(p!= PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(ReportUpload.this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},1);
        }
        else {
            LocationManager lm = (LocationManager) getSystemService(LOCATION_SERVICE);
            location_current = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        }
        ReportMessage m = new ReportMessage(report.getText().toString(),
                location_current.getLatitude(),
                location_current.getLongitude());
        try{
            new DAOMessage("Report").add(m).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void unused) {
                    Toast.makeText(ReportUpload.this, "Message sent!", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(ReportUpload.this, "Message Failed!", Toast.LENGTH_SHORT).show();
                }
            });
        }catch(Exception e){
            Log.e("******", e.getMessage());
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_upload);
        report = findViewById(R.id.message_text);
    }
}