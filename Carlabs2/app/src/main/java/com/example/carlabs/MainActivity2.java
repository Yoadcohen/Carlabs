package com.example.carlabs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        Bundle b = getIntent().getExtras();
        Cars cars = (Cars) b.getSerializable("cars");

        ImageView photo = findViewById(R.id.photo);
        TextView brand = findViewById(R.id.brand);
        TextView model = findViewById(R.id.model);
        TextView year = findViewById(R.id.year);
        TextView price = findViewById(R.id.price);


        photo.setImageResource(cars.getPhoto());
        brand.setText(cars.getBrand());
        model.setText(cars.getModel());
        year.setText(cars.getYear());
        price.setText(cars.getPrice());
    }
}