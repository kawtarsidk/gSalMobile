package com.example.gsalmobile.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class databaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="contacts.db";
    public static final String TABLE_SAL="Salaries";
    public static final String TABLE_USER="users";
    private String sql="create table salaries (id INTEGER primary key autoincrement, nom TEXT, prenom TEXT, email TEXT, " +
            "telephone TEXT, cin TEXT , addresse TEXT, dateNaissance TEXT, departement TEXT , emploiOccupe TEXT, anciennete INTEGER, salairebase INTEGER, prime INTEGER) ";

    private String sqlite="create table "+TABLE_USER+" (login TEXT, password1 TEXT, password2 TEXT) ";

    public databaseHelper( Context context) {
        super(context, DATABASE_NAME, null , 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(sql);
        db.execSQL(sqlite);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    String sql ="DROP TABLE IF EXISTS "+TABLE_SAL;
    db.execSQL(sql);

    String sql1 ="DROP TABLE IF EXISTS "+TABLE_USER;
    db.execSQL(sql1);

    onCreate(db);
    }
}
