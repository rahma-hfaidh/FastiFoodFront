package com.example.testing;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

import static com.example.testing.R.drawable.*;

public class DetailFacteur extends AppCompatActivity {
    private RecyclerView rv_dfact;
    private RecyclerView.LayoutManager layoutManager;
    private DfactAdapter dfactAdapter;
int id_fact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_facteur);
        Bundle extras = getIntent().getExtras();
        id_fact= extras.getInt("id_fact");



        ApiDfact api = ApiClient.getClient().create(ApiDfact.class);
        Call<List<Dfacteur>> listComByF = api.getComtByIdFact(id_fact);
        System.out.println("listeeee " + listComByF);
        listComByF.enqueue(new Callback<List<Dfacteur>>() {
            @Override
            public void onResponse(Response<List<Dfacteur>> response, Retrofit retrofit) {
                List<Dfacteur> list = new ArrayList<Dfacteur>();
                if (response.isSuccess()) {
                    list = (List<Dfacteur>) response.body();
                    System.out.println("liste commande " + list);




/*
        //Repas

        List<Dfacteur> list = new ArrayList<>();
        list.add(new Dfacteur(1, "KFC", "accepté", 100, baguette, 1));
        list.add(new Dfacteur(1, "Baguette Baguette", "accepté", 100, baguette, 1));
        list.add(new Dfacteur(1, "Mix Max", "accepté", 100, baguette, 1));
*/

                    // on récupére notre Recyclerview via son id
                    rv_dfact = findViewById(R.id.rv_Dfact);
                    //on veut un recyclerview qui utilise un linearlayoutManager
                    layoutManager = new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false);
                    rv_dfact.setLayoutManager(layoutManager);
                    //on donne notre adapter à notre recyclerview
                    dfactAdapter = new DfactAdapter(list, getApplicationContext());
                    rv_dfact.setAdapter(dfactAdapter);
                }
            }

            @Override
            public void onFailure(Throwable t) {

            }

        });
    }
    @Override
    protected void onRestart() {

        super.onRestart();
        finish();

    }

}