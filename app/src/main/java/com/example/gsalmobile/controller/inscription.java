package com.example.gsalmobile.controller;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.gsalmobile.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class inscription extends AppCompatActivity {
    EditText rname, remail, rpassword;
    Button inscriptionBtn, cancel;
    FirebaseAuth fAuth;


    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);
        rname = findViewById(R.id.reg_log);
        remail = findViewById(R.id.reg_email);
        rpassword = findViewById(R.id.reg_pswd1);
        inscriptionBtn = findViewById(R.id.btn_register_validate);
        cancel = findViewById(R.id.btn_register_cancel);

        fAuth = FirebaseAuth.getInstance();

        // si l'utilisateur a deja un comte

        if (fAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(), connexion.class));
            finish();
        }

        // creation d'un nouveau utilisateur
        inscriptionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email= remail.getText().toString().trim();//formater data
                String password= rpassword.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    remail.setError("champs d'email obligé.");
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    rpassword.setError("champs de mot de passe obligé.");
                    return;
                }

                if(password.length()< 6){
                    rpassword.setError("vous devez entrez au moins 6 characteres.");
                    return;
                }

                // enregistrer l'utulisateur

                fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(inscription.this, "utilisateur crée", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), connexion.class)); //redirection vers la page connexion
                        }else{
                            Toast.makeText(inscription.this, "erreur !" , Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),connexion.class));

            }
        });

    }
}
