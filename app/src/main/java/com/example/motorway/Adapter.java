package com.example.motorway;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.icu.text.IDNA;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Map;

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
    public void onBindViewHolder(@NonNull Holder holder, @SuppressLint("RecyclerView") int position) {
        Message m = list.get(position);
        holder.name.setText(m.getText());

        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String type = m.getType();
                Intent i;
                switch(m.getType()){
                    case "Help":
                        i = new Intent(context, HelpDetails.class);
                        i.putExtra("pos", position);
                        context.startActivity(i);
                        break;
                    case "Info":
                        i = new Intent(context, InfoDetails.class);
                        i.putExtra("pos", position);
                        context.startActivity(i);
                        break;
                    case "Report":
                        i = new Intent(context, ReportDetails.class);
                        i.putExtra("pos", position);
                        context.startActivity(i);
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
