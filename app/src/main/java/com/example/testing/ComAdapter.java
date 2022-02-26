package com.example.testing;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Date;
import java.util.List;



public class ComAdapter extends RecyclerView.Adapter<ComAdapter.ComViewHolder> {

    List<commande> listCom;
    Context context;

    public ComAdapter(List<commande> listCom, Context context) {
        this.listCom = listCom;
        this.context = context;
    }


    @NonNull
    @Override
    public ComViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lc_item_commande, parent, false);
        ComAdapter.ComViewHolder comViewHolder = new ComAdapter.ComViewHolder(view);
        return comViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ComViewHolder holder, int position) {

        commande com = listCom.get(position);
        holder.modepaye.setText(com.getMode_payement());
        holder.date.setText(com.getDate().substring(0,10));
        holder.somme_com.setText(Double.toString(com.getSomme_fact()));
        holder.adresse.setText(com.getAdresse());
        holder.status.setText(com.getStatus());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, listCom.get(position).getAdresse(), Toast.LENGTH_LONG).show();
                Intent intent =new Intent(context,DetailFacteur.class);
                context.startActivity(intent);





            }
        });


    }

    @Override
    public int getItemCount() {
        {
            return listCom.size();
        }
    }


    public class ComViewHolder extends RecyclerView.ViewHolder {
        TextView status;
        TextView adresse;
        TextView  somme_com;
        TextView date;
        TextView modepaye;

        public ComViewHolder(@NonNull View itemView) {
            super(itemView);
            modepaye=itemView.findViewById(R.id.modepaye);
            status = itemView.findViewById(R.id.status);


            adresse = itemView.findViewById(R.id.adresse);
            date = itemView.findViewById(R.id.date);
            somme_com = itemView.findViewById(R.id.somme_com);

        }

    }



}