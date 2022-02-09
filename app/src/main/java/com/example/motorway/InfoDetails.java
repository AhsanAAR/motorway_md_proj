package com.example.motorway;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class InfoDetails extends AppCompatActivity {
    TextView msg, name, phone_num;
    DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Users");
    InformationMsg m;

    public void resolve(View view){
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Info");
        reference.child(m.getMsgID()).removeValue();
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_details);

        int pos = getIntent().getExtras().getInt("pos");
        m = (InformationMsg) MessageDisplay.list.get(pos);

        msg = findViewById(R.id.message_text);
        name = findViewById(R.id.name_text);
        phone_num  = findViewById(R.id.phone_text);

        msg.setText(m.getText());

        reference.child(m.getUid()).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if(task.isSuccessful()) {
                    User u = task.getResult().getValue(User.class);
                    name.setText(u.getName());
                    phone_num.setText(u.getPhoneNumber());
                }
            }
        });
    }
}