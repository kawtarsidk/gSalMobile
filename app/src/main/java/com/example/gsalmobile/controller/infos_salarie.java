package com.example.gsalmobile.controller;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gsalmobile.R;

public class infos_salarie extends AppCompatActivity {
    private TextView nom,prenom,cin,adresse,telephone,datenaiss,email,departm,emploi,anc,salaire,prime,saln;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infos_salarie);

        nom=findViewById(R.id.show_nom);
        prenom=findViewById(R.id.show_prenom);
        cin=findViewById(R.id.show_c);
        adresse=findViewById(R.id.show_a);
        telephone=findViewById(R.id.show_t);
        datenaiss=findViewById(R.id.show_d);
        email=findViewById(R.id.show_e);
        departm=findViewById(R.id.show_dpt);
        emploi=findViewById(R.id.show_emp);
        anc=findViewById(R.id.show_an);
        salaire=findViewById(R.id.show_sa);
        prime=findViewById(R.id.show_pr);
        saln=findViewById(R.id.show_sal);

        String n = getIntent().getStringExtra("keynom");
        String p = getIntent().getStringExtra("keyprenom");
        String c = getIntent().getStringExtra("keyc");
        String a = getIntent().getStringExtra("keya");
        String t = getIntent().getStringExtra("keyt");
        String e = getIntent().getStringExtra("keye");
        String d = getIntent().getStringExtra("keyd");
        String dpt = getIntent().getStringExtra("keydpt");
        String empl = getIntent().getStringExtra("keyempl");
        String an = getIntent().getStringExtra("keyan");
        String sa = getIntent().getStringExtra("keysa");
        String pr = getIntent().getStringExtra("keypr");

        Intent intent = getIntent();
        double in = intent.getDoubleExtra("i",0.0);



        nom.setText(n);
        prenom.setText(p);
        cin.setText(c);
        adresse.setText(a);
        telephone.setText(t);
        datenaiss.setText(d);
        email.setText(e);
        departm.setText(dpt);
        emploi.setText(empl);
        anc.setText(an);
        salaire.setText(sa);
        prime.setText(pr);
        saln.setText(String.valueOf(in));


    }

}