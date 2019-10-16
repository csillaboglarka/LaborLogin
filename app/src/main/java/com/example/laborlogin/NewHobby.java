package com.example.laborlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;


import android.os.Bundle;
import android.view.View;


public class NewHobby extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_hobby);
    }
    public void addNewHobby (View view) {

        Intent intent = new Intent();
        String hobbie = findViewById(R.id.hobbyyy).toString();
        Hobbie h1 = new Hobbie(hobbie);


    }
    // public void ViewHobbys (View view)

}
