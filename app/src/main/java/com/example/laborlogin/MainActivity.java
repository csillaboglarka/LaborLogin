package com.example.laborlogin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.icu.text.DateFormat;
//import android.icu.util.Calendar;
import android.os.Bundle;
import android.view.View;
import java.util.Calendar;

import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Calendar cal;
    DatePickerDialog pick;
    EditText spassword,semail;
    TextView sbirthdate;
    CheckBox checksaving;
    TextView birth;
    SharedPreferences sharedpreferences;
    public static final String mypreference = "mypref";
    public static final String Password = "passKey";
    public static final String Email = "emailKey";
    public static final String Birthdates= "dateKey";
    public static final String Checkbox = "checkKey";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        checksaving = (CheckBox) findViewById(R.id.save);
        semail =  (EditText) findViewById(R.id.email);
        spassword = (EditText) findViewById(R.id.password);
        sbirthdate = (TextView) findViewById(R.id.birthDate);
        CheckPreferencies();

    }


    public void logIn (View view) {
       Intent intent = new Intent(this,NewHobby.class);
        if (checksaving.isChecked()) {
            String n = spassword.getText().toString();
            String e = semail.getText().toString();
            String b = sbirthdate.getText().toString();
            String f = checksaving.getText().toString();
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putString(Password, n);
            editor.putString(Email, e);
            editor.putString(Birthdates, b);
            editor.putString(Checkbox, f);
            editor.commit();
        }
        else {

            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putString(Password, "");
            editor.putString(Email, "");
            editor.putString(Birthdates, "");
            editor.putString(Checkbox, "false");
            editor.commit();

        }
        if(spassword.getText().toString()!= "" && semail.getText().toString()!= "" && sbirthdate.getText().toString()!= "") {
            Toast.makeText(getApplicationContext(),"Succesful Log in",Toast.LENGTH_SHORT).show();
            startActivity(intent);
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Can't log in..Please fill all them",Toast.LENGTH_SHORT).show();
        }





    }


    public void goClick(View view){
        cal=Calendar.getInstance();
        int day=cal.get(Calendar.DAY_OF_MONTH);
        int month=cal.get(Calendar.MONTH);
        int year=cal.get(Calendar.YEAR);
        pick=new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener(){
            @Override
            public void onDateSet(DatePicker datePicker, int mYear, int mMonth, int mDay){
                birth = findViewById(R.id.birthDate);
               birth.setText(mDay+"/"+(mMonth+1)+"/"+mYear);
            }
        },day,month,year);
        pick.show();
    }
    public void CheckPreferencies() {

        sharedpreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);
        if (sharedpreferences.contains(Checkbox)){

                checksaving.setChecked(true);


        }

        if (sharedpreferences.contains(Password)) {
            spassword.setText(sharedpreferences.getString(Password, ""));
        }
        if (sharedpreferences.contains(Email)) {
            semail.setText(sharedpreferences.getString(Email, ""));

        }
        if (sharedpreferences.contains(Birthdates)) {

            sbirthdate.setText(sharedpreferences.getString(Birthdates, ""));
        }




    }
}







