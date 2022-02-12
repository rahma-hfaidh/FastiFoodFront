package com.example.testing;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MenuActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        bottomNavigationView=(BottomNavigationView) findViewById(R.id.bottomnavigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(naviglistener);
    }
    public BottomNavigationView.OnNavigationItemSelectedListener naviglistener=new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment unFragment=null;
            switch (menuItem.getItemId())
            {
                case R.id.Acceuil:
                    unFragment= new AcceuilFragment();
                    break;
                case R.id.Commande:
                    unFragment= new CommandeFragment();
                    break;
                case R.id.Recherche:
                    unFragment= new FavoriesFragment();
                    break;
                case R.id.Profile:
                    unFragment= new ProfileFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentplaceholder,unFragment).commit();
            return  true;
        }
    };
}