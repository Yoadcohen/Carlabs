package com.example.carlabs;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    CarAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(false);
        RecyclerView.LayoutManager manager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(manager);



        List<Cars> cars = new ArrayList<Cars>();
        cars.add(new Cars(R.drawable.accentse, "Hyundai", "Accent SE", "2022", "$17,670"));
        cars.add(new Cars(R.drawable.fortefe, "Kia", "Forte Fe", "2022","$20,115"));
        cars.add(new Cars(R.drawable.mirage, "Mitsubishi", "Mirage", "2022","$16,990"));
        cars.add(new Cars(R.drawable.riolx, "Kia", "Rio LX", "2022","$17,275"));
        cars.add(new Cars(R.drawable.spark, "Chevrolet", "Spark", "2022","$15,695"));
        cars.add(new Cars(R.drawable.venue, "Hyundai", "Venue SE", "2022","$20,125"));
        cars.add(new Cars(R.drawable.versas, "Nissan", "Versa SE", "2022","$17,775"));
        cars.add(new Cars(R.drawable.soullx, "Kia", "Soul LX", "2022","$20,505"));

        adapter = new CarAdapter(cars);
        recyclerView.setAdapter(adapter);

        ItemTouchHelper helper = new ItemTouchHelper(new SwipeToDelete(adapter));
        helper.attachToRecyclerView(recyclerView);

        FloatingActionButton btn = findViewById(R.id.fbtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(),AddCar.class);
                ActivityOptionsCompat options =
                        ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) v.getContext(),
                                btn,
                                "bg"
                        );
                startActivityForResult(i,1,options.toBundle());
            }

        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==1) {
            Bundle b = data.getExtras();
            Cars car = (Cars) b.getSerializable("cars");
            adapter.AddCar(car);
        }

    }


}