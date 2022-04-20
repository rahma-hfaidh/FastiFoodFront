package com.example.testing.Commande;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.testing.Api.Api_Client.ApiClient;
import com.example.testing.Api.Api_Commande.ApiComR;
import com.example.testing.Commande.Adapter.comRAdapter;
import com.example.testing.Models.commandeRestau;
import com.example.testing.R;

import java.util.ArrayList;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class selectmultipleActivity extends AppCompatActivity {
    private final int VSTIMEOUT = 9000;
    private RecyclerView rv_comR;
    private RecyclerView.LayoutManager layoutManager;
    private com.example.testing.Commande.Adapter.comRAdapter comRAdapter;
    private ArrayList<commandeRestau> selectionList = new ArrayList<>();
    private int counter = 0;
    private Toolbar toolbar;
    private TextView txtToolbar;
    private ImageButton btnBack;
    public boolean isActionMode = false;
    public int position = -1;
    commandeRestau comi;
    private Spinner spnr;
    private List<commandeRestau> listCom;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selectmultiple);
        toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        txtToolbar = findViewById(R.id.text_toolbar);
        txtToolbar.setVisibility(View.GONE);
        spnr = findViewById(R.id.spinerrrr);
        spnr.setVisibility(View.GONE);
        btnBack = findViewById(R.id.btnBack);
//        System.out.println("kkkkkkkkkkkkkkkkkkk"+comi.getId_fact());


        btnBack.setVisibility(View.GONE);
        btnBack.setOnClickListener(v->{
            clearActionMode();
        });
        ApiComR api = ApiClient.getClient().create(ApiComR.class);
        Call<List<commandeRestau>> listComByRes = api.getFactByIdRestau(2);
        listComByRes.enqueue(new Callback<List<commandeRestau>>() {
            @Override
            public void onResponse(Response<List<commandeRestau>> response, Retrofit retrofit) {
                List<commandeRestau> listCom = new ArrayList<commandeRestau>();
                if (response.isSuccess()) {
                    listCom = (List<commandeRestau>) response.body();
                    // on récupére notre Recyclerview via son id
                    rv_comR = findViewById(R.id.rv_comR);
                    rv_comR.setHasFixedSize(true);
                    //on veut un recyclerview qui utilise un linearlayoutManager
                    layoutManager = new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false);
                    rv_comR.setLayoutManager(layoutManager);
                    //on donne notre adapter à notre recyclerview
                    comRAdapter = new comRAdapter(listCom,selectmultipleActivity.this);
                    rv_comR.setAdapter(comRAdapter);


                }

            }

            @Override
            public void onFailure(Throwable t) {

            }
        });



        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.array_status, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnr.setAdapter(adapter);

        spnr.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               String chaine="en attent";
                String repo = String.valueOf(spnr.getSelectedItem());

                if (position == 0) {
                    spnr.setBackgroundResource(R.drawable.attent);
                    chaine="en attent";
                    //Toast.makeText(getApplicationContext(), "Selected : " + repo, Toast.LENGTH_SHORT).show();
                }
                if (position == 1) {
                    chaine="accepté";
                    spnr.setBackgroundResource(R.drawable.accept);
                   // Toast.makeText(getApplicationContext(), "Selected : " + repo, Toast.LENGTH_SHORT).show();
                }
                if (position == 2) {
                    chaine="refusé";
                  spnr.setBackgroundResource(R.drawable.refuse);
                    //Toast.makeText(getApplicationContext(), "Selected : " + repo, Toast.LENGTH_SHORT).show();
                }


                ApiComR api = ApiClient.getClient().create(ApiComR.class);
                Call<String> putRep = (Call<String>) api.putRep(2,chaine);
                //Call<String> putRepp = (Call<String>) api.putRep(5,chaine);
                putRep.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Response<String> response, Retrofit retrofit) {
                      //  Toast.makeText(getApplicationContext(),"reponse modifié ", Toast.LENGTH_LONG).show();
                        ApiComR api = ApiClient.getClient().create(ApiComR.class);
                        Call<List<commandeRestau>> listComByRes = api.getFactByIdRestau(2);
                        listComByRes.enqueue(new Callback<List<commandeRestau>>() {
                            @Override
                            public void onResponse(Response<List<commandeRestau>> response, Retrofit retrofit) {
                                List<commandeRestau> listCom = new ArrayList<commandeRestau>();
                                if (response.isSuccess()) {
                                     listCom = (List<commandeRestau>) response.body();
                                    // on récupére notre Recyclerview via son id
                                    rv_comR = findViewById(R.id.rv_comR);
                                    rv_comR.setHasFixedSize(true);
                                    //on veut un recyclerview qui utilise un linearlayoutManager
                                    layoutManager = new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false);
                                    rv_comR.setLayoutManager(layoutManager);
                                    //on donne notre adapter à notre recyclerview
                                    comRAdapter = new comRAdapter(listCom,selectmultipleActivity.this);
                                    rv_comR.setAdapter(comRAdapter);




                                }

                            }

                            @Override
                            public void onFailure(Throwable t) {

                            }
                        });


                    }

                    @Override
                    public void onFailure(Throwable t) {
                        Toast.makeText(getApplicationContext(),"reponse n'est pas modifié !", Toast.LENGTH_LONG).show();

                    }
                });
                /*putRepp.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Response<String> response, Retrofit retrofit) {
                       // Toast.makeText(getApplicationContext(),"reponse modifié ", Toast.LENGTH_LONG).show();

                    }

                    @Override
                    public void onFailure(Throwable t) {
                        Toast.makeText(getApplicationContext(),"reponse n'est pas modifié !", Toast.LENGTH_LONG).show();

                    }
                });*/
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }
    private void clearActionMode() {
        isActionMode = false;
        txtToolbar.setVisibility(View.GONE);
        txtToolbar.setText("0 item selected");
        btnBack.setVisibility(View.GONE);
        spnr.setVisibility(View.GONE);
        toolbar.getMenu().clear();
        counter = 0 ;
        selectionList.clear();
        //toolbar.getMenu().clear();
        comRAdapter.notifyDataSetChanged();
    }
    public void startSelection(int index){
        if(!isActionMode){
            isActionMode = true;
            //selectionList.add(list.get(index));
            counter++;
            updateToolbarText(counter);
            //txtToolbar.setVisibility(View.VISIBLE);

            btnBack.setVisibility(View.VISIBLE);
            spnr.setVisibility(View.VISIBLE);

            //toolbar.inflateMenu(R.menu.menu_action);
            position = index;
            comRAdapter.notifyDataSetChanged();
        }
    }
    public void check (View v,int index){
        if((( CheckBox )v).isChecked()){
            //selectionList.add(list.get(index));
            System.out.println("marhbeeee intidharrr");
            counter++;
            updateToolbarText(counter);

        }else{
            //selectionList.remove(list.get(index));
            counter--;
            updateToolbarText(counter);
        }
    }
    private void updateToolbarText(int counter) {
        if (counter ==0){
            txtToolbar.setText("0 item selected");
        }
        if (counter ==1){
            txtToolbar.setText("1 item selected");
        }
        else {
            txtToolbar.setText(counter+" items selected");
        }
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.item_delete ){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Accepter");
            builder.setTitle("Confirm");
            builder.setPositiveButton("Accepter", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    updateToolbarText(0);
                    clearActionMode();

                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            builder.show();
        }
        else
            System.out.println("orourouuuuuuuuuuuu");














        return super.onOptionsItemSelected(item);
    }


}