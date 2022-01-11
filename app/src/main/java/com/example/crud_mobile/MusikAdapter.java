package com.example.crud_mobile;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MusikAdapter extends RecyclerView.Adapter<MusikAdapter.ViewHolderSaya> {

    private Context context;
    private ArrayList musik_id, musik_judul, musik_pencipta, musik_genre;

    MusikAdapter(
            Context context,
            ArrayList musik_id,
            ArrayList musik_judul,
            ArrayList musik_pencipta,
            ArrayList musik_genre
    ){
        this.context    = context;
        this.musik_id    = musik_id;
        this.musik_judul = musik_judul;
        this.musik_pencipta = musik_pencipta;
        this.musik_genre   = musik_genre;

    }

    @NonNull
    @Override
    public ViewHolderSaya onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflaterKita = LayoutInflater.from(context);
        View viewSaya = inflaterKita.inflate(R.layout.melianigulo8020180088, parent, false);
        return new ViewHolderSaya(viewSaya);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderSaya holder, @SuppressLint("RecyclerView") int position) {
        holder.txt_id_musik.setText(String.valueOf(musik_id.get(position)));
        holder.txt_judul_musik.setText(String.valueOf(musik_judul.get(position)));
        holder.txt_musik_pencipta.setText(String.valueOf(musik_pencipta.get(position)));
        holder.txt_musik_genre.setText(String.valueOf(musik_genre.get(position)));
        holder.layoutUtama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentKita = new Intent(context, UbahMusikActivity.class);
                intentKita.putExtra("id", String.valueOf(musik_id.get(position)));
                intentKita.putExtra("judul", String.valueOf(musik_judul.get(position)));
                intentKita.putExtra("pencipta", String.valueOf(musik_pencipta.get(position)));
                intentKita.putExtra("genre", String.valueOf(musik_genre.get(position)));

                context.startActivity(intentKita);
            }
        });
    }

    public int getItemCount() {
        return musik_id.size();
    }

    public class ViewHolderSaya extends RecyclerView.ViewHolder {

        TextView txt_id_musik, txt_judul_musik, txt_musik_pencipta, txt_musik_genre;
        LinearLayout layoutUtama;

        public ViewHolderSaya(@NonNull View itemView) {
            super(itemView);

            txt_id_musik        = itemView.findViewById(R.id.txt_musik_id);
            txt_judul_musik      = itemView.findViewById(R.id.txt_musik_judul);
            txt_musik_pencipta  = itemView.findViewById(R.id.txt_musik_pencipta);
            txt_musik_genre        = itemView.findViewById(R.id.txt_musik_genre);
            layoutUtama         = itemView.findViewById(R.id.layout_utama);
        }
    }
}
