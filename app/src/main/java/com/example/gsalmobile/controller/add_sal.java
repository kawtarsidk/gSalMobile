package com.example.gsalmobile.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gsalmobile.R;
import com.example.gsalmobile.database.SalariesDataSource;
import com.example.gsalmobile.model.Salaries;

public class add_sal extends AppCompatActivity {


    EditText prenom;
    EditText nom;
    EditText cin;
    EditText addresse;
    EditText telephone;
    EditText dateNaissance;
    EditText departement;
    EditText emploiOccupe;
    EditText anciennete;
    EditText salaireBase;
    EditText email;
    EditText prime;
    Button btnSaveSal;
    Button btnExit;
    SalariesDataSource dataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add_sal);
        prenom=findViewById(R.id.add_sal_prenom);
        nom=findViewById(R.id.add_sal_nom);
        cin=findViewById(R.id.add_sal_cin);
        addresse=findViewById(R.id.add_sal_addresse);
        telephone=findViewById(R.id.add_sal_telephone);
        email=findViewById(R.id.add_sal_mail);
        dateNaissance=findViewById(R.id.add_sal_date);
        departement=findViewById(R.id.add_sal_departement);
        emploiOccupe=findViewById(R.id.add_sal_emploi);
        anciennete=findViewById(R.id.add_sal_anciennete);
        salaireBase=findViewById(R.id.add_sal_salaire);
        prime=findViewById(R.id.add_sal_prime);

        btnSaveSal=findViewById(R.id.add_sal_btn_save);
        btnExit=findViewById(R.id.add_sal_btn_exit);

        //si on clique sur enregistrer
        btnSaveSal.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dataSource = new SalariesDataSource(getApplicationContext());

                Salaries s = new Salaries();

//                int anc =Integer.parseInt(anciennete.getText().toString());
//                int salaire =Integer.parseInt(salaireBase.getText().toString());
//                int pr =Integer.parseInt(prime.getText().toString());

                s.setNom(nom.getText().toString());
                s.setPrenom(prenom.getText().toString());
                s.setCin(cin.getText().toString());
                s.setAdresse(addresse.getText().toString());
                s.setTelephone(telephone.getText().toString());
                s.setEmail(email.getText().toString());
                s.setDateNaissance(dateNaissance.getText().toString());
                s.setDepartement(departement.getText().toString());
                s.setEmploiOccupe(emploiOccupe.getText().toString());
                s.setAnciennete(Integer.parseInt(anciennete.getText().toString()));
                s.setSalaireBase(Integer.parseInt(salaireBase.getText().toString()));
                s.setPrime(Integer.parseInt(prime.getText().toString()));
                //////////////////////////////////////////////////////
                String n = nom.getText().toString();
                String p = prenom.getText().toString();
                String c = cin.getText().toString();
                String a = addresse.getText().toString();
                String t = telephone.getText().toString();
                String e = email.getText().toString();
                String d = dateNaissance.getText().toString();
                String dpt = departement.getText().toString();
                String empl = emploiOccupe.getText().toString();
               /* int an =Integer.parseInt(*/ String an=anciennete.getText().toString();
                /*int sa = Integer.parseInt(*/String sa =salaireBase.getText().toString();
                /*int pr =Integer.parseInt(*/String pr = prime.getText().toString();


                int anc=Integer.parseInt(an);
                int salBase=Integer.parseInt(sa);
                double primeAnc;
                double cnss;
                double cimr;
                double impot;

                // calculer prime anciennete

                int prm=Integer.parseInt(pr);
                if(anc<2){
                    primeAnc=0;
                }
                else if(anc>2 & anc<5){
                    primeAnc=salBase * 0.05;
                }
                else if(anc>5 & anc<12){
                    primeAnc=salBase * 0.1;
                }
                else if(anc>12 & anc<20){
                    primeAnc=salBase * 0.15;
                }
                else if(anc>20 & anc<25){
                    primeAnc=salBase * 0.2;
                }
                else {
                    primeAnc=salBase * 0.25;
                }

                //SalaireBrut = SalaireBase + primeAnciennete + prime

                double salaireBrut = salBase + primeAnc + prm;

                // calculer prelevement cnss

                if(salaireBrut<=6000){
                    cnss =salaireBrut * 0.0429;
                }
                else {
                    cnss = 6000 * 0.0429;
                }

                //calculer prelevement cimr

                cimr = salaireBrut * 0.06;

                // calculer prelevemnt des impots

                if(salaireBrut <=2500){
                    impot= salaireBrut* 0;
                }
                else if( salaireBrut > 2500 & salaireBrut< 4167){
                    impot = salaireBrut * 0.1;
                }
                else if( salaireBrut > 4166 & salaireBrut< 5001){
                    impot = salaireBrut * 0.2;
                }

                else if( salaireBrut > 5000 & salaireBrut< 6667){
                    impot = salaireBrut * 0.3;
                }
                else if( salaireBrut > 6666 & salaireBrut< 15001){
                    impot = salaireBrut * 0.3;
                }
                else {
                    impot = salaireBrut * 0.38;
                }

                // calculer salaire net

                double salaireNet = salaireBrut - cnss -cimr - impot;

                //////////////////////////////////////////////////////
                 boolean res=dataSource.insertSal(s);
                        if( false ){
                                Toast.makeText(getApplicationContext(),"erreur!!",Toast.LENGTH_LONG).show();

                        }
                        else {
                            Toast.makeText(getApplicationContext(), "success!!", Toast.LENGTH_LONG).show();

                            //Intent intent= new Intent(getApplicationContext(),liste_Salaries.class);
                            Intent intent = new Intent(add_sal.this, infos_salarie.class);
                            intent.putExtra("keynom", n);
                            intent.putExtra("keyprenom", p);
                            intent.putExtra("keyc", c);
                            intent.putExtra("keya", a);
                            intent.putExtra("keyt", t);
                            intent.putExtra("keye", e);
                            intent.putExtra("keyd", d);
                            intent.putExtra("keydpt", dpt);
                            intent.putExtra("keyempl", empl);
                            intent.putExtra("keyan", an);
                            intent.putExtra("keysa", sa);
                            intent.putExtra("keypr", pr);
                            intent.putExtra("i", salaireNet);

                            startActivity(intent);
                        }

            }
        }));

        //si on clique sur annuler
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), accueil.class);
                startActivity(intent);
            }
        });
    }
}
