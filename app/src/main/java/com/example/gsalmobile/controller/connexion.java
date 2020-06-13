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

public class connexion extends AppCompatActivity {

    EditText cemail, cpassword;
    Button cloginBtn, cregister;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);

        cemail = findViewById(R.id.email);
        cpassword = findViewById(R.id.pswd);
        cloginBtn = findViewById(R.id.btn_connect);
        cregister = findViewById(R.id.btn_register);

        fAuth = FirebaseAuth.getInstance();

        cloginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = cemail.getText().toString().trim();//formater data
                String password = cpassword.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    cemail.setError("champs d'email obligé.");
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    cpassword.setError("champs de mot de passe obligé.");
                    return;
                }

                if (password.length() < 6) {
                    cpassword.setError("votre mot de passe est incorrecte.");
                    return;
                }

                // authentifier l'utilisateur

                fAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(connexion.this, "utilisateur est connecté", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), accueil.class));
                        }
                    }
                });
            }
        });

        cregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), inscription.class));
            }
        });
    }

}
