package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class UserActivity extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        tv=findViewById(R.id.tvHello);

        String name;
        String surName;
        int age;

        Bundle arg=getIntent().getExtras();//достали всю КАРТУ

        if (arg != null) {
            name = (String)arg.get("name");//достали объект из карты по имени (достали Object)
            if(name.equals(""))name="Аноним";

            surName = (String)arg.get("surName");
            age = (int)arg.get("age");


            if(age<3||age>60){
                tv.setText(getString(R.string.Dear)+", "+name+"! "+getString(R.string.ErrorInputAge) );
            }
            if(age<18)tv.setText(getString(R.string.Dear)+", "+name+"! "+ getString(R.string.AgeLess18));
            if(age>=18&&age<=60) tv.setText(getString(R.string.welcome)+", "+name+" "+surName+"!");

        }



    }
}
