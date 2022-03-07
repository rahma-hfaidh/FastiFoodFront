package com.example.testing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.imageview.ShapeableImageView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class DetailProdActivity extends AppCompatActivity {

    int id_prod,id_cat,id_unite;
    String nomProduit;
    RelativeLayout rl_submit_cat,rl_app_choice;
    RadioGroup rg;
    RadioButton rb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_prod);

        // recupére id cat

        Intent intent=getIntent();
        if(intent.hasExtra("id_prod"))
        {
            id_prod=intent.getIntExtra("id_prod",0);
        }
        if(intent.hasExtra("id_cat"))
        {
            id_cat=intent.getIntExtra("id_cat",0);
        }

        // radio buttonn
        rl_app_choice=(RelativeLayout) findViewById(R.id.rl_app_choice);
        rb= new RadioButton(this);
        rg=new RadioGroup(this);

        // traitement

        // traitement


        ApiUnite apiUnite = ApiClient.getClient().create(ApiUnite.class);
        Call<List<Unite>> listUnitByCat = apiUnite.getUnitByIdCat(this.id_cat);

        listUnitByCat.enqueue(new Callback<List<Unite>>() {
            @Override
            public void onResponse(Response<List<Unite>> response, Retrofit retrofit) {
                List<Unite> listUnit = new ArrayList<Unite>();
                if(response.isSuccess())
                {
                    listUnit =(List<Unite>) response.body();
                    System.out.println("liste unite "+listUnit.size());


                    int length= listUnit.size();
                    for (int i=0; i<length; i++)
                    {

                        rb= new RadioButton(getApplicationContext());
                        rb.setText(listUnit.get(i).getNomUnite());
                        rb.setId(listUnit.get(i).getId_unite());
                        rg.addView(rb);

                    }
                }
                rg.setOrientation(RadioGroup.VERTICAL);
                rl_app_choice.addView(rg);
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });





        // image

        ShapeableImageView imageView=(ShapeableImageView) findViewById(R.id.imgDetailProd);
        ApiHandler api=ApiClient.getClient().create(ApiHandler.class);
        Call<String> pic = api.getPicture(id_prod);
        pic.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Response<String> response, Retrofit retrofit) {
                String picture=response.body();

                // holder.image.setImageDrawable(Drawable.createFromPath("http://localhost:5000/uploads/tartes"));
               // Picasso.get().load("http://172.16.23.70:5000/uploads/"+picture).into(imageView);
                Picasso.get().load("http://192.168.43.19:5000/uploads/"+picture).into(imageView);
            }

            @Override
            public void onFailure(Throwable t) {
                Log.d(" fl", "failed");
            }
        });



        // recupére nom

        TextView tv_nomprod=(TextView) findViewById(R.id.tv_nomProd);
        ApiProduit apiProd=ApiClient.getClient().create(ApiProduit.class);
        Call<String> nomProd = apiProd.getProdByIdProd(id_prod);
        nomProd.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Response<String> response, Retrofit retrofit) {
                nomProduit = response.body();
                System.out.println("issmouuuu "+nomProduit);
                tv_nomprod.setText(nomProduit);
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
        //checkeddd


        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = (RadioButton) findViewById(checkedId);
                id_unite=radioButton.getId();

                System.out.println("iddd"+id_unite);
                ApiProduit apiPro=ApiClient.getClient().create(ApiProduit.class);
                Call<String> prixProd = apiPro.getPriceProd(id_prod,id_unite);
                prixProd.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Response<String> response, Retrofit retrofit) {
                        String prix=response.body();
                        System.out.println("prix"+prix);
                        TextView tv_prixProd=(TextView) findViewById(R.id.tv_prixProd);
                        tv_prixProd.setText(prix);
                    }

                    @Override
                    public void onFailure(Throwable t) {

                    }
                });
                Toast.makeText(getApplicationContext(),radioButton.getText(),Toast.LENGTH_LONG).show();
            }
        });
    }
}