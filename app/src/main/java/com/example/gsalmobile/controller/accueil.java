package com.example.gsalmobile.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gsalmobile.R;
import com.google.firebase.auth.FirebaseAuth;

public class accueil extends AppCompatActivity {

    public Button btnAddSal;
    public Button btnShowSal;
    public Button btnquiter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);
        btnAddSal =findViewById(R.id.btn_add_salarie);
        btnShowSal =findViewById(R.id.btn_list_salaries);
        btnquiter = findViewById(R.id.btn_quitter);

        //si on clique sur btn_add_sal
        btnAddSal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),add_sal.class);
                startActivity(intent);
            }
        });

        //si on clique sur le btn_list_salaries
        btnShowSal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),liste_Salaries.class);
                startActivity(intent);
            }
        });

        //si on clique sur btn_quitter (deconnexion)

        btnquiter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(),connexion.class);
                startActivity(intent);
            }
        });
    }
}
