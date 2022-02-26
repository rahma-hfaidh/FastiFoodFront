package com.example.testing;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class DfactAdapter extends RecyclerView.Adapter<DfactAdapter.DfactViewHolder> {
    List<Dfacteur> listDc;
    Context context;

    public DfactAdapter(List<Dfacteur> listDc, Context context) {
        this.listDc = listDc;
        this.context = context;
    }

    @NonNull
    @Override
    public DfactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item_detail_facteur, parent, false);
        DfactAdapter.DfactViewHolder dfactViewHolder = new DfactAdapter.DfactViewHolder(view);
        return dfactViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DfactAdapter.DfactViewHolder holder, int position) {


        Dfacteur DF = listDc.get(position);
        holder.reponse.setText(DF.getReponse());

        Picasso.get().load("http://172.16.21.123:5000/uploads/"+DF.logo).into(holder.logo);
        holder.somme_Dfacteur.setText(Double.toString(DF.getSomme_Dfacteur()));
        holder.nomRestau.setText(DF.getNomRestau());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, listDc.get(position).getNomRestau(), Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return  listDc.size();
    }


    public class DfactViewHolder extends RecyclerView.ViewHolder {
        TextView nomRestau;
        TextView reponse;
        TextView  somme_Dfacteur;
        ImageView logo,annuler;

        public DfactViewHolder(@NonNull View itemView) {
            super(itemView);
            nomRestau=itemView.findViewById(R.id.nomRest);
            reponse = itemView.findViewById(R.id.rep);


            somme_Dfacteur = itemView.findViewById(R.id.somme_Dfact);
            logo = itemView.findViewById(R.id.imageRest);
            annuler= itemView.findViewById(R.id.annD);
            annuler.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final Dialog dialog = new Dialog(v.getContext());
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
