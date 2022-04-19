package com.example.testing.Commande.Adapter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.testing.Api.Api_Client.ApiClient;
import com.example.testing.Api.Api_GProduit.ApiProduit;
import com.example.testing.Api.Api_Reclamation.ApiRec;
import com.example.testing.R;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class AjouterAREcActivity extends AppCompatActivity {
    public int id_com;
    ImageView imgBack;
    EditText Designation_rec,descr_rec;
    String designation,description;
    Button sendAR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter_arec);
        imgBack=(ImageView)findViewById(R.id.img_back);
        sendAR=(Button)findViewById(R.id.sendreclm);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        // recupére type_reclamation et description


        Designation_rec=(EditText) findViewById(R.id.type_rec);
        descr_rec=(EditText) findViewById(R.id.descr_rec);

        // recupére id cat

        Intent intent=getIntent();
        if(intent.hasExtra("id_com"))
        {
            id_com=intent.getIntExtra("id_com",0);

        }
        //recuperer designation et description du reclamation

        sendAR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                designation= Designation_rec.getText().toString();
                description= descr_rec.getText().toString();
                ApiRec api = ApiClient.getClient().create(ApiRec.class);
                Call<String> postAutretReclamation = (Call<String>) api.PostTR(designation,"Restaurant",description);
                postAutretReclamation.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Response<String> response, Retrofit retrofit) {
                        Toast.makeText(getApplicationContext(),"ajoutee avec succes ", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Throwable t) {
                        Toast.makeText(getApplicationContext(),"ajoutee avec succes", Toast.LENGTH_LONG).show();
                    }
                });
                ApiRec api2 = ApiClient.getClient().create(ApiRec.class);
                Call<String> postAutreReclamation = (Call<String>) api2.postAutreReclamation(1,id_com,0);
                System.out.println(id_com);
                postAutreReclamation.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Response<String> response, Retrofit retrofit) {
                        Toast.makeText(getApplicationContext(),"ajoutee avec succes ", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Throwable t) {
                        Toast.makeText(getApplicationContext(),"ajoutee avec succes", Toast.LENGTH_LONG).show();
                    }
                });


            }
        });







    }
    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
    }
}