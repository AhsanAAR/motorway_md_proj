package com.example.motorway;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

public class HelpUpload extends AppCompatActivity {

    EditText regNumber;

    public void sendMessage(View view){
        Message m = new HelpMessage(regNumber.getText().toString(),
                UserDashboard.UID, null);
        try{
            new DAOMessage("Help").add(m).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void unused) {
                    Toast.makeText(HelpUpload.this, "Message sent!", Toast.LENGTH_SHORT).show();
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
    }
}