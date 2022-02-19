package com.example.testing;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import static com.example.testing.R.drawable.*;

public class DetailFacteur extends AppCompatActivity {
    private RecyclerView rv_dfact;
    private RecyclerView.LayoutManager layoutManager;
    private DfactAdapter dfactAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_facteur);


        //Repas

        List<Dfacteur> list = new ArrayList<>();
        list.add(new Dfacteur(1, "KFC", "accepté", 100, baguette, 1));
        list.add(new Dfacteur(1, "Baguette Baguette", "accepté", 100, baguette, 1));
        list.add(new Dfacteur(1, "Mix Max", "accepté", 100, baguette, 1));


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