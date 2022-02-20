package com.example.testing;

import android.content.Context;
<<<<<<< Updated upstream
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
=======
import android.graphics.drawable.Drawable;
>>>>>>> Stashed changes
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import retrofit.Call;

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
        final Bitmap[] bmp = new Bitmap[1];

        Produit produit=listProduit.get(position);
        ApiHandler api=ApiClient.getClient().create(ApiHandler.class);
        //Call<String> image = api.getPicture(produit.getId_prod());
<<<<<<< Updated upstream





                //("http://localhost:5000/uploads/tartes.jpg"));

       Picasso.get().load("http://172.16.21.123:5000/uploads/lion.jpg").into(holder.image);
        //Glide.with(context).load("https://www.cuisinonsencouleurs.fr/wp-content/uploads/2021/02/Cheesecake-maison-16-scaled.jpg").into(holder.image);
=======
       // holder.image.setImageDrawable(Drawable.createFromPath("http://localhost:5000/uploads/tartes"));
        Picasso.get().load("https://192.168.43.19:5000/uploads/tartes.jpg").into(holder.image);
   //  Glide.with(context).load("https://www.cuisinonsencouleurs.fr/wp-content/uploads/2021/02/Cheesecake-maison-16-scaled.jpg").into(holder.image);
>>>>>>> Stashed changes
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
