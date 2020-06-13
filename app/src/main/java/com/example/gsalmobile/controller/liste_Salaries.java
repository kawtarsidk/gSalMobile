package com.example.gsalmobile.controller;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gsalmobile.R;
import com.example.gsalmobile.database.SalariesDataSource;
import com.example.gsalmobile.model.Salaries;

import java.util.ArrayList;
import java.util.List;

public class liste_Salaries extends AppCompatActivity {

    Button btnAddSal;
    ListView listeSal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste__salaries);

        listeSal=findViewById(R.id.liste_sal);

        SalariesDataSource dataSource=new SalariesDataSource(liste_Salaries.this);

        //recuperer la liste des salaries
        List<Salaries> s=new ArrayList<Salaries>();
        //s=dataSource.getAllSalaries();

        // ajouter un adapteur
        ArrayAdapter<Salaries> adapter=new ArrayAdapter<Salaries>(liste_Salaries.this, android.R.layout.simple_list_item_1, s);
        listeSal.setAdapter(adapter);




    }
}
