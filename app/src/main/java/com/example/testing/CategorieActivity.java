package com.example.testing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class CategorieActivity extends AppCompatActivity {

    RelativeLayout rl_submit_cat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorie);
        rl_submit_cat=(RelativeLayout) findViewById(R.id.rl_submit_cat);
        rl_submit_cat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(),AjouterProduitActivity.class);
                startActivity(i);
            }
        });
    }
}