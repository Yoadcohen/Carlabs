package com.example.carlabs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddCar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car);

        Button btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText brand = findViewById(R.id.brand);
                EditText model = findViewById(R.id.model);
                EditText year = findViewById(R.id.year);
                EditText price = findViewById(R.id.price);
                Cars car = new Cars(R.drawable.accentse,brand.getText().toString(),model.getText().toString(),year.getText().toString(), price.getText().toString());

                Intent i = new Intent();
                i.putExtra("cars",car);
                setResult(1,i);
                finish();



            }
        });


    }
}