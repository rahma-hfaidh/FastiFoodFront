package com.example.testing;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommandeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    // recyclerview

    private RecyclerView rv_com;
    private RecyclerView.LayoutManager layoutManager;
    private ComAdapter comAdapter;
    private Spinner spinner;

    public CommandeFragment() {
        // Required empty public constructor
    }

    public static CommandeFragment newInstance(String param1, String param2) {
        CommandeFragment fragment = new CommandeFragment();
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
        View v = inflater.inflate(R.layout.fragment_commande, container, false);
        spinner = v.findViewById(R.id.rl_submit_catR);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.array_status, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        //Repas

        List<commande> listCom = new ArrayList<>();
        listCom.add(new commande(1, "9 rue kahra tunis", 1,500,"en cours","12/10/2020","à livré"));
        listCom.add(new commande(1, "10 rue kahra marsa", 1, 250,"en cours","12/11/2020","à livré"));
        listCom.add(new commande(1, "11 rue kahra ben arous", 1, 1, "en cours","10/10/2020","à livré"));
        listCom.add(new commande(1, "2 rue kahra ariana", 1, 100, "en cours","12/08/2020","à livré"));


        // on récupére notre Recyclerview via son id
        rv_com = v.findViewById(R.id.rv_com);
        //on veut un recyclerview qui utilise un linearlayoutManager
        layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        rv_com.setLayoutManager(layoutManager);
        //on donne notre adapter à notre recyclerview
        comAdapter = new ComAdapter(listCom, getContext());
        rv_com.setAdapter(comAdapter);









        //on sépare chaque ligne de notre liste par un trait
        /*
        DividerItemDecoration dividerItemDecoration;
        dividerItemDecoration = new DividerItemDecoration(rv_com.getContext(), DividerItemDecoration.VERTICAL);
        rv_com.addItemDecoration(dividerItemDecoration);
        */
        return v;

    }





















}