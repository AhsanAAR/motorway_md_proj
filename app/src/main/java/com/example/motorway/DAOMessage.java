package com.example.motorway;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DAOMessage {
    private DatabaseReference reference;

    public DAOMessage(String type){
        reference = FirebaseDatabase.getInstance().getReference(type);
    }

    public Task<Void> add(Message m){
        String key = reference.push().getKey();
        m.setMsgID(key);
        return reference.child(key).setValue(m);
    }

}
