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

public class ProduitAdapter extends RecyclerView.Adapter<ProduitAdapter.ProduitViewHolder> {

    List<Produit> listProduit;
    Context context;

    public  ProduitAdapter(List<Produit> listProduit,Context context)
    {
        this.listProduit=listProduit;
        this.context=context;
    }



    @NonNull
    @Override
    public ProduitViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item_homepage,parent,false);
        ProduitViewHolder produitViewHolder= new ProduitViewHolder(view);
        return produitViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProduitViewHolder holder, int position) {

        Produit produit=listProduit.get(position);
        holder.image.setImageResource(produit.getImageProd());
        holder.titre.setText(produit.getNomProd());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,listProduit.get(position).getNomProd(),Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return listProduit.size();
    }

    public class ProduitViewHolder extends  RecyclerView.ViewHolder{
        ImageView image;
        TextView titre;
        public ProduitViewHolder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.image);
            titre= itemView.findViewById(R.id.titre);

        }
    }
}
