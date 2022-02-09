package com.example.motorway;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

public class InformationUpload extends AppCompatActivity {
    EditText query;
    public void sendMessage(View view){
        String qry = query.getText().toString().trim();
        if(TextUtils.isEmpty(qry)){
            query.setError("Information Query is Required");
            return;
        }

        InformationMsg m = new InformationMsg(query.getText().toString(), UserDashboard.UID);
        try{
            new DAOMessage("Info").add(m).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void unused) {
                    Toast.makeText(InformationUpload.this, "Message sent!", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(InformationUpload.this, "Message Failed!", Toast.LENGTH_SHORT).show();
                }
            });
        }catch(Exception e){
            Log.e("******", e.getMessage());
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_upload);

        query = findViewById(R.id.message_text);
    }
}