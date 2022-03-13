package com.example.testing;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PanierActivity extends AppCompatActivity {

    private RecyclerView rv_panier;
    private RecyclerView.LayoutManager layoutManager;
    private PanierAdapter panierAdapter;
    List<Cart> listPanier;
    TextView tvcount;
    ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panier);
       listPanier = new ArrayList<Cart>();
        listPanier=ListMenuByIdCatActivity.myDatabase.cartDao().getData();
       // listPanier.add(new Cart(1,"cheeseCake",R.drawable.cheesecake,"restau",12,5));
       // listPanier.add(new Cart(1,"Jus fraise",R.drawable.jusfraise,"restau",20,5));
       // listPanier.add(new Cart(1,"Lasagne",R.drawable.lasagne,"restau",7,5));


        rv_panier=findViewById(R.id.rv_panier);
        //on veut un recyclerview qui utilise un linearlayoutManager
        layoutManager = new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false);
        rv_panier.setLayoutManager(layoutManager);
        //on donne notre adapter à notre recyclerview
        panierAdapter = new PanierAdapter(listPanier, getApplicationContext());
        rv_panier.setAdapter(panierAdapter);
        //on sépare chaque ligne de notre liste par un trait
        DividerItemDecoration dividerItemDecoration;
        dividerItemDecoration = new DividerItemDecoration(rv_panier.getContext(),DividerItemDecoration.VERTICAL);
        rv_panier.addItemDecoration(dividerItemDecoration);

       // tvcount=(TextView)findViewById(R.id.txtcartcount);
     //
        //   int count=cartProductAdapter.getItemCount();


      //  updatacartcount();
        LocalBroadcastManager.getInstance(this).registerReceiver(mMasage,new IntentFilter("mymsg"));

        back =(ImageView) findViewById(R.id.img_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),ListCategorieClientActivity.class);
                startActivity(i);
            }
        });
    }

 /*   private void updatacartcount() {
        int count=panierAdapter.getItemCount();

        if (count==0){
            tvcount.setText("Your Cart is Empty");
        }else {
            tvcount.setText(String.valueOf(count));
        }



    }*/



    @Override
    protected void onResume() {
        super.onResume();
        //updatacartcount();
    }

    public BroadcastReceiver mMasage=new BroadcastReceiver(){

        @Override
        public void onReceive(Context context, Intent intent) {
            String cartcount=intent.getStringExtra("cartcount");
            if (listPanier.size()  ==0){
                tvcount.setText("Your Cart is Empty");
            }else {
                tvcount.setText(String.valueOf(listPanier.size()));
            }
        }
    };
}