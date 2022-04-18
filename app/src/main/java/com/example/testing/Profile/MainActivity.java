package com.example.testing.Profile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.testing.Calendrier.CalendarActivity;
import com.example.testing.Commande.AcceptRefuseActivity;
import com.example.testing.Commande.selectmultipleActivity;
import com.example.testing.G_Produit.CategorieActivity;
import com.example.testing.G_Produit.DetailProdActivity;
import com.example.testing.G_Produit.ListCategorieClientActivity;
import com.example.testing.G_Produit.MenuActivity;
import com.example.testing.R;
import com.example.testing.Reclamation.ReclamationActivity;

public class MainActivity extends AppCompatActivity {

    Button gomenu;
    Button godetail;
    Button goadd,goTest,ListCat;

    public static final String BASE_URL_IMAGE="http://192.168.43.178:5000/";

    Button gocalendar;
    Button goreclamtion;
    Button SelectMultiple;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SelectMultiple=(Button) findViewById(R.id.SM);
        SelectMultiple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(getApplicationContext(), selectmultipleActivity.class);
                startActivity(i);

            }
        });
        goreclamtion=(Button) findViewById(R.id.goReclamation);
        goreclamtion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(getApplicationContext(), ReclamationActivity.class);
                startActivity(i);

            }
        });
        gocalendar=(Button) findViewById(R.id.goCalendar);
        gocalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(getApplicationContext(), CalendarActivity.class);
                startActivity(i);

            }
        });
        gomenu=(Button) findViewById(R.id.goMenu);
        gomenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(getApplicationContext(), MenuActivity.class);
                startActivity(i);

            }
        });
        godetail=(Button)findViewById(R.id.goDetail);
        godetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(getApplicationContext(), DetailProdActivity.class);
                startActivity(i);
            }
        });

        goadd=(Button) findViewById(R.id.goAddProd);
        goadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(getApplicationContext(), CategorieActivity.class);
                startActivity(i);
            }
        });
        goTest=(Button) findViewById(R.id.goTest);
        goTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(getApplicationContext(), AcceptRefuseActivity.class);
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