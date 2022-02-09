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

import java.io.IOException;

public class HelpUpload extends AppCompatActivity {
    Location location_current;
    EditText regNumber, message;

    public void sendMessage(View view){
        String rg = regNumber.getText().toString().trim();
        if(TextUtils.isEmpty(rg)){
            regNumber.setError("Registration Number is Required");
            return;
        }

        int p = ContextCompat.checkSelfPermission(getApplicationContext(),
                Manifest.permission.ACCESS_FINE_LOCATION);
        if(p!= PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(HelpUpload.this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},1);
        }
        else {
            LocationManager lm = (LocationManager) getSystemService(LOCATION_SERVICE);
            location_current = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        }

        HelpMessage m = new HelpMessage(message.getText().toString(),
                regNumber.getText().toString(),
                UserDashboard.UID, location_current.getLatitude(), location_current.getLongitude());
        try{
            new DAOMessage("Help").add(m).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void unused) {
                    Toast.makeText(HelpUpload.this, "Message sent!", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(HelpUpload.this, "Message Failed!", Toast.LENGTH_SHORT).show();
                }
            });
        }catch(Exception e){
            Log.e("******", e.getMessage());
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_upload);

        regNumber = findViewById(R.id.registration_text);
        message = findViewById(R.id.message_text);
    }
}