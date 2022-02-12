package com.example.testing;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AcceuilFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AcceuilFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    // recyclerview

    private RecyclerView rv_repas;
    private RecyclerView rv_boissons;
    private RecyclerView rv_desserts;
    private RecyclerView.LayoutManager layoutManager;
    private ProduitAdapter produitAdapter;


    public AcceuilFragment() {
        // Required empty public constructor
    }



    // TODO: Rename and change types and number of parameters
    public static AcceuilFragment newInstance(String param1, String param2) {
        AcceuilFragment fragment = new AcceuilFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_acceuil, container, false);



        //menu

        //Repas

        List<Produit> listRepas = new ArrayList<>();
        listRepas.add(new Produit(1,"Lasagne",R.drawable.lasagne,1,1));
        listRepas.add(new Produit(1,"Tagliatelle",R.drawable.tagliatelle,1,1));
        listRepas.add(new Produit(1,"Spaghetti",R.drawable.spaghetti,1,1));
        listRepas.add(new Produit(1,"Spaghetti",R.drawable.spaghetti,1,1));


        // on récupére notre Recyclerview via son id
        rv_repas=v.findViewById(R.id.rv_repas);
        //on veut un recyclerview qui utilise un linearlayoutManager
        layoutManager = new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false);
        rv_repas.setLayoutManager(layoutManager);
        //on donne notre adapter à notre recyclerview
        produitAdapter = new ProduitAdapter(listRepas, getContext());
        rv_repas.setAdapter(produitAdapter);
        //on sépare chaque ligne de notre liste par un trait
        DividerItemDecoration dividerItemDecoration;
        dividerItemDecoration = new DividerItemDecoration(rv_repas.getContext(),DividerItemDecoration.VERTICAL);
        rv_repas.addItemDecoration(dividerItemDecoration);


        // boissons


        List<Produit> listBoissons = new ArrayList<>();
        listBoissons.add(new Produit(1,"Jus de fraise",R.drawable.jusfraise,1,1));
        listBoissons.add(new Produit(1,"Jus d'orange",R.drawable.jusorange,1,1));
        listBoissons.add(new Produit(1,"Gazeuse",R.drawable.gazeuse,1,1));
        listBoissons.add(new Produit(1,"Gazeuse",R.drawable.coca,1,1));


        // on récupére notre Recyclerview via son id
        rv_boissons=v.findViewById(R.id.rv_boissons);
        //on veut un recyclerview qui utilise un linearlayoutManager
        layoutManager = new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false);
        rv_boissons.setLayoutManager(layoutManager);
        //on donne notre adapter à notre recyclerview
        produitAdapter = new ProduitAdapter(listBoissons, getContext());
        rv_boissons.setAdapter(produitAdapter);
        //on sépare chaque ligne de notre liste par un trait
        dividerItemDecoration = new DividerItemDecoration(rv_boissons.getContext(),DividerItemDecoration.VERTICAL);
        rv_boissons.addItemDecoration(dividerItemDecoration);


        // desserts

        List<Produit> listDesserts = new ArrayList<>();
        listDesserts.add(new Produit(1,"Tarte",R.drawable.tartes,1,1));
        listDesserts.add(new Produit(1,"Cheesecake",R.drawable.cheesecake,1,1));
        listDesserts.add(new Produit(1,"Verrine",R.drawable.verrine,1,1));
        listDesserts.add(new Produit(1,"Verrine",R.drawable.verrine,1,1));


        // on récupére notre Recyclerview via son id
        rv_desserts=v.findViewById(R.id.rv_desserts);
        //on veut un recyclerview qui utilise un linearlayoutManager
        layoutManager = new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false);
        rv_desserts.setLayoutManager(layoutManager);
        //on donne notre adapter à notre recyclerview
        produitAdapter = new ProduitAdapter(listDesserts, getContext());
        rv_desserts.setAdapter(produitAdapter);
        //on sépare chaque ligne de notre liste par un trait
        dividerItemDecoration = new DividerItemDecoration(rv_desserts.getContext(),DividerItemDecoration.VERTICAL);
        rv_desserts.addItemDecoration(dividerItemDecoration);
        return v;

    }
}