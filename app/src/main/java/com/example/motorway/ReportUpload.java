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

public class ReportUpload extends AppCompatActivity {
    EditText report;

    public void sendMessage(View view){
        Message m = new ReportMessage(report.getText().toString(), null);
        try{
            new DAOMessage("Report").add(m).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void unused) {
                    Toast.makeText(ReportUpload.this, "Message sent!", Toast.LENGTH_SHORT).show();
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