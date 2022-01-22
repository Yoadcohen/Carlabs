package com.example.carlabs;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityOptionsCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CarAdapter extends RecyclerView.Adapter<CarsViewHolder> {

    public List<Cars> Cars;

    public CarAdapter(List<Cars> cars) {

        this.Cars = cars;
    }

    public void DeleteCar(int position) {
        Cars.remove(position);
        notifyDataSetChanged();
    }

    public void AddCar(Cars car) {
        Cars.add(car);
        notifyDataSetChanged();
    }


    @NonNull
    @Override


    public CarsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cars, parent, false);
        CarsViewHolder cvw = new CarsViewHolder(view);
        return cvw;
    }

    @Override
    public void onBindViewHolder(@NonNull CarsViewHolder holder, int position) {
        Cars car = Cars.get(position);
        holder.Photo.setImageResource(car.getPhoto());
        holder.Brand.setText(car.getBrand());
        holder.Model.setText(car.getModel());
        holder.Year.setText(car.getYear());
        holder.Card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), MainActivity2.class);
                i.putExtra("cars", car);
                ActivityOptionsCompat options =
                        ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) v.getContext(),
                                holder.Photo,
                                "avatarTrasnition"
                        );
                v.getContext().startActivity(i, options.toBundle());
            }
        });
    }

    @Override
    public int getItemCount() {
        return Cars.size();
    }

}

