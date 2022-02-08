package com.example.motorway;

import static com.firebase.ui.auth.AuthUI.getApplicationContext;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.Holder> {

    Context context;
    ArrayList<Message> list;

    public Adapter(Context context, ArrayList<Message> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new Holder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        Message m = list.get(position);
        holder.name.setText(m.getText());
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (m.getType()){
                    case "Help":
                        context.startActivity(new Intent(context, HelpDetails.class));
                        break;
                    case "Info":
                        context.startActivity(new Intent(context, InfoDetails.class));
                        break;
                    case "Report":
                        context.startActivity(new Intent(context, Reportdetails.class));
                        break;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class Holder extends RecyclerView.ViewHolder{
        TextView name;
        Button button;

        public Holder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.title_text);
            button = itemView.findViewById(R.id.resolve_button);
        }
    }
}
