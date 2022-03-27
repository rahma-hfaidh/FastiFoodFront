package com.example.testing;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    TextView addPromo;
    GridView simpleList;
    List<Categorie> CatList;
    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
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
        View v = inflater.inflate(R.layout.fragment_profile, container, false);
        simpleList=(GridView) v.findViewById(R.id.gridViewListPromoClient);
        addPromo=v.findViewById(R.id.promo);
        addPromo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getContext(),addPromotion.class);
                getContext().startActivity(intent);

            }
        });


        APIPromo api=ApiClient.getClient().create(APIPromo.class);
        Call<List<Promotion>> list = api.getListPromo();
        list.enqueue(new Callback<List<Promotion>>() {
            @Override
            public void onResponse(Response<List<Promotion>> response, Retrofit retrofit) {
                if(response.isSuccess())
                {
                    List<Promotion> PrmoList=new ArrayList<Promotion>();
                    PrmoList=response.body();
                    System.out.println("listtt "+PrmoList);
                    promoAdapter promoAdap=new promoAdapter(getContext(),R.layout.promogriditem,PrmoList);
                    simpleList.setAdapter(promoAdap);
                }
            }

            @Override
            public void onFailure(Throwable t) {
                System.out.println("failure ");
            }
        });


        return v;
    }
}