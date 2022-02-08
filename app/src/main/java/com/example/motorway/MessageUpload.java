package com.example.motorway;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

public class MessageUpload extends AppCompatActivity {

    EditText msg;
    DAOMessage dao;

    public void sendMessage(View view){
         Message m = new Message(msg.getText().toString());
         try{
             dao.add(m).addOnSuccessListener(new OnSuccessListener<Void>() {
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
        dao = new DAOMessage();

        Bundle b = getIntent().getExtras();
        switch (b.getInt("type")){
            case 0:
                msg.setHint("help");
                break;
            case 1:
                msg.setHint("report");
                break;
            case 2:
                msg.setHint("info");
                break;
        }
    }
}