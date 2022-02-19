package com.example.testing;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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
        holder.logo.setImageResource(DF.getLogo());
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
        ImageView logo;

        public DfactViewHolder(@NonNull View itemView) {
            super(itemView);
            nomRestau=itemView.findViewById(R.id.nomRest);
            reponse = itemView.findViewById(R.id.rep);


            somme_Dfacteur = itemView.findViewById(R.id.somme_Dfact);
            logo = itemView.findViewById(R.id.imageRest);

        }
    }
}
