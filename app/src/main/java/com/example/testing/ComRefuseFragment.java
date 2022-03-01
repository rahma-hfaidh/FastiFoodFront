package com.example.testing;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ComRefuseFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ComRefuseFragment extends Fragment {
    int id_restau=2;
    private RecyclerView rv_com;
    private RecyclerView.LayoutManager layoutManager;
    private ComAdapterAcceptRefuse comAdapter;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ComRefuseFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ComRefuseFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ComRefuseFragment newInstance(String param1, String param2) {
        ComRefuseFragment fragment = new ComRefuseFragment();
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
        View v= inflater.inflate(R.layout.fragment_com_refuse, container, false);

        ApiComm api = ApiClient.getClient().create(ApiComm.class);
        Call<List<commande>> list=api.getCommandesRefuseByIdRestau(id_restau);
        list.enqueue(new Callback<List<commande>>() {
            @Override
            public void onResponse(Response<List<commande>> response, Retrofit retrofit) {
                List<commande> CommList=new ArrayList<commande>();
                CommList=response.body();

                // on récupére notre Recyclerview via son id
                rv_com = v.findViewById(R.id.rv_com);
                //on veut un recyclerview qui utilise un linearlayoutManager
                layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
                rv_com.setLayoutManager(layoutManager);
                //on donne notre adapter à notre recyclerview
                comAdapter = new ComAdapterAcceptRefuse(CommList, getContext());
                rv_com.setAdapter(comAdapter);
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });



        return v;
    }
}