package com.example.testing;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PanierAdapter extends RecyclerView.Adapter<PanierAdapter.PanierViewHolder>{

    List<Cart> listPanier;
    Context context;

    public PanierAdapter(List<Cart> listPanier,Context context)
    {
        this.listPanier=listPanier;
        this.context=context;
    }
    @NonNull
    @Override
    public PanierViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.panier_item,parent,false);
        PanierAdapter.PanierViewHolder panierViewHolder= new PanierAdapter.PanierViewHolder(view);
        return panierViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PanierViewHolder holder, int position) {
        Cart panier=listPanier.get(position);
        //holder.imageProd.setImageResource(panier.getImageProd());
        holder.nomProd.setText(panier.getNomProd());
        holder.designation.setText(panier.getNomRest());
        String price=panier.getPrixProd()+" DT";
        holder.prixprod.setText(price);
        // holder.quantite.setText((panier.getQuantite());
        Picasso.get().load("http://192.168.43.19:5000/uploads/"+panier.getImageProd()).into(holder.imageProd);


    }

    @Override
    public int getItemCount() {
        return listPanier.size();
    }

    public class PanierViewHolder extends  RecyclerView.ViewHolder{
        ShapeableImageView imageProd;
        TextView designation,nomProd,prixprod,quantite;
        public PanierViewHolder(@NonNull View itemView) {
            super(itemView);
            imageProd=itemView.findViewById(R.id.imageProd);
            designation=itemView.findViewById(R.id.nomRest);
            nomProd=itemView.findViewById(R.id.nomProd);
            prixprod=itemView.findViewById(R.id.prixProd);
            quantite=itemView.findViewById(R.id.quantite);
        }
    }
}
