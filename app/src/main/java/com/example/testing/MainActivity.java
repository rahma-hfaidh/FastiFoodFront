package com.example.testing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button gomenu;
    Button godetail;
    Button goadd,goTest,ListCat;
    public static final String BASE_URL_Image="http://172.16.13.168:5000/images/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gomenu=(Button) findViewById(R.id.goMenu);
        gomenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(getApplicationContext(),MenuActivity.class);
                startActivity(i);

            }
        });
        godetail=(Button)findViewById(R.id.goDetail);
        godetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(getApplicationContext(),DetailProdActivity.class);
                startActivity(i);
            }
        });

        goadd=(Button) findViewById(R.id.goAddProd);
        goadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(getApplicationContext(),CategorieActivity.class);
                startActivity(i);
            }
        });
        goTest=(Button) findViewById(R.id.goTest);
        goTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(getApplicationContext(),AcceptRefuseActivity.class);
                startActivity(i);
            }
        });
        ListCat=(Button) findViewById(R.id.goListCat);
        ListCat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(getApplicationContext(), ListCategorieClientActivity.class);
                startActivity(i);
            }
        });

    }
}