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
import com.google.firebase.auth.FirebaseAuth;

public class MessageUpload extends AppCompatActivity {
    EditText msg, regNumber;
    String type;

    public void sendMessage(View view){
         Message m = new Message(msg.getText().toString(), type, regNumber.getText().toString(), UserDashboard.UID);
         try{
             new DAOMessage(type).add(m).addOnSuccessListener(new OnSuccessListener<Void>() {
                 @Override
                 public void onSuccess(Void unused) {
                     Toast.makeText(MessageUpload.this, "Message sent!", Toast.LENGTH_SHORT).show();
                 }
             }).addOnFailureListener(new OnFailureListener() {
                 @Override
                 public void onFailure(@NonNull Exception e) {
                     Toast.makeText(MessageUpload.this, "Message Failed!", Toast.LENGTH_SHORT).show();
                 }
             });
         }catch(Exception e){
             Log.e("******", e.getMessage());
         }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_upload);
        msg = findViewById(R.id.message_text);
        regNumber = findViewById(R.id.registration_text);

        Bundle b = getIntent().getExtras();
        type = b.getString("type");
    }
}