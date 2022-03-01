package com.example.testing;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class MenuByCatAdapter extends ArrayAdapter {
    List<Produit> MenuByCatList= new ArrayList<>();
    public MenuByCatAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        MenuByCatList= objects;
    }
    @Override
    public int getCount() {
        return super.getCount();
    }
    @Override

    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.menubycatitem, null);
        TextView textView = (TextView) v.findViewById(R.id.titreMenuItem);
        ImageView imageView = (ImageView) v.findViewById(R.id.imageMenuItem);
        textView.setText(MenuByCatList.get(position).getNomProd());

        ApiProduit api=ApiClient.getClient().create(ApiProduit.class);
        Call<String> pic = api.getPicture(MenuByCatList.get(position).getId_prod());
        pic.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Response<String> response, Retrofit retrofit) {
                String picture=response.body();
                Picasso.get().load("http://172.16.23.70:5000/images/"+picture).into(imageView);
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });

        return v;

    }

}
