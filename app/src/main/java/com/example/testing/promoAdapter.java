package com.example.testing;

import android.content.Context;
import android.content.Intent;
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

public class promoAdapter extends ArrayAdapter{
        List<Promotion> PromoList= new ArrayList<>();
        Context context;
        public promoAdapter(@NonNull Context context, int resource, @NonNull List objects) {
            super(context, resource, objects);
            PromoList= objects;
            context=context;
        }
        @Override
        public int getCount() {
            return super.getCount();
        }

        @Override

        public View getView(int position, View convertView, ViewGroup parent) {

            View v = convertView;
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.promogriditem, null);
            TextView textView = (TextView) v.findViewById(R.id.titrePromoItem);
            ImageView imageView = (ImageView) v.findViewById(R.id.imagePromoItem);
            textView.setText(String.valueOf(PromoList.get(position).getPrix_promo()) + "  DT");

            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    /*
                    Intent i=new Intent(getContext(),ListMenuByIdCatActivity.class);
                    int id_cat=PromoList.get(position).getId_cat();
                    i.putExtra("id_cat",id_cat);
                    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    getContext().startActivity(i);

                    */

                }
            });
            APIPromo api=ApiClient.getClient().create(APIPromo.class);
            Call<String> pic = api.getPicture(PromoList.get(position).getId_promo());
            pic.enqueue(new Callback<String>() {
                @Override
                public void onResponse(Response<String> response, Retrofit retrofit) {
                    String picture=response.body();
                    Picasso.get().load("http://172.16.20.193:5000/images/"+picture).into(imageView);
                    //  Picasso.get().load("http://172.16.23.70:5000/images/"+picture).into(imageView);
                }

                @Override
                public void onFailure(Throwable t) {

                }
            });

            return v;

        }
    }

