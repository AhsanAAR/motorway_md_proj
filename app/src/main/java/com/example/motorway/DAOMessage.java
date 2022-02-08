package com.example.motorway;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DAOMessage {
    private DatabaseReference reference;

    public DAOMessage(){
        reference = FirebaseDatabase.getInstance().getReference(Message.class.getSimpleName());
    }

    public Task<Void> add(Message m){
        return reference.child(m.text_).setValue(m);
    }

}
