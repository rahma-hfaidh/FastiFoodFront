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
        holder.date.setText(com.getDate());
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
        ImageView annuler;

        public ComViewHolder(@NonNull View itemView) {
            super(itemView);
            modepaye=itemView.findViewById(R.id.modepaye);
            status = itemView.findViewById(R.id.status);


            adresse = itemView.findViewById(R.id.adresse);
            date = itemView.findViewById(R.id.date);
            somme_com = itemView.findViewById(R.id.somme_com);
             annuler= itemView.findViewById(R.id.ann);
            annuler.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final Dialog dialog = new Dialog(context);
                    dialog.setContentView(R.layout.alert_annuler);
                    Button dialogButton = (Button) dialog.findViewById(R.id.cancel2);
                    Button dialogButtonA = (Button) dialog.findViewById(R.id.confirm2);

                    // if button is clicked, close the custom dialog
                    dialogButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                            Toast.makeText(context,"Cancel..!!",Toast.LENGTH_LONG).show();
                        }
                    });
                    // if button is clicked, close the custom dialog

                    // if button is clicked, close the custom dialog
                    dialogButtonA.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                            Toast.makeText(context,"Confirm..",Toast.LENGTH_LONG).show();
                            //startActivity(new Intent(PlantsActivity.this, PayementActivity.class));
                        }
                    });
                    dialog.show();

                }
            });
        }

    }



}