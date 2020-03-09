package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etName;
    EditText etSurName;
    EditText etAge;
    TextView tvError;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvError=findViewById(R.id.textView5);

        etName=findViewById(R.id.eName);
        etSurName=findViewById(R.id.eSName);
        etAge=findViewById(R.id.eAge);
    }

    public void onClick(View v){
        Intent intent=new Intent(this,UserActivity.class);


        intent.putExtra("name",etName.getText().toString());
        intent.putExtra("surName",etSurName.getText().toString());


        try {
            int age= Integer.parseInt(etAge.getText().toString());
            intent.putExtra("age",age);
            tvError.setVisibility(View.INVISIBLE);
            startActivity(intent);
        }catch (NumberFormatException e){
            if(!etAge.getText().toString().equals("")){
                intent.putExtra("age",1000);
                startActivity(intent);
            }
            else tvError.setVisibility(View.VISIBLE);
        }


    }
}
