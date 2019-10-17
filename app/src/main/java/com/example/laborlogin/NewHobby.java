package com.example.laborlogin;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;



import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import android.widget.Toast;


public class NewHobby extends AppCompatActivity {

    DatabaseHelper hobbyDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_hobby);
        hobbyDB = new DatabaseHelper(this);


    }
    public void addNewHobby(View view){

      //  Intent intent = new Intent(NewHobby.this,NewHobby.class);

        EditText hob = findViewById(R.id.hobbyyy);
        String txt = hob.getText().toString();
        boolean insertData = hobbyDB.addData(txt);
        if (insertData == true) {
            Toast.makeText(NewHobby.this, "Hobby hozzaadva", Toast.LENGTH_LONG).show();

        }
        else{
            Toast.makeText(NewHobby.this, "Hobby nem lett hozzaadva", Toast.LENGTH_LONG).show();

        }




    }
     public void ListYourHobby (View view){
         Intent intent = new Intent(NewHobby.this, LisrHobby.class);
         startActivity(intent);
     }


}
