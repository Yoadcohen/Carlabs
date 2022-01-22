package com.example.carlabs;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class CarsViewHolder extends RecyclerView.ViewHolder{
    public CardView Card;
    public ImageView Photo;
    public TextView Brand;
    public TextView Model;
    public TextView Year;

    public CarsViewHolder(@NonNull View itemView) {
        super(itemView);
        Card =itemView.findViewById(R.id.card);
        Photo = itemView.findViewById(R.id.photo);
        Brand = itemView.findViewById(R.id.brand);
        Model = itemView.findViewById(R.id.model);
        Year = itemView.findViewById(R.id.year);

    }

}
