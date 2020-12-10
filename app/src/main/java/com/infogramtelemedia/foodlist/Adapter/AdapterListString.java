package com.infogramtelemedia.foodlist.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.infogramtelemedia.foodlist.R;

import java.util.List;

public class AdapterListString extends RecyclerView.Adapter<AdapterListString.MyViewHolderString> {

    List<String> ingredients, measure;

    public AdapterListString(List<String> ingredients, List<String> measure) {
        this.ingredients = ingredients;
        this.measure = measure;
    }

    @NonNull
    @Override
    public MyViewHolderString onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_detail_food, parent, false);
        MyViewHolderString myViewHolderString = new MyViewHolderString(view);
        return myViewHolderString;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderString holder, int position) {
        holder.ingredients.setText(ingredients.get(position)+ " " + "("+measure.get(position)+")");
//        holder.measure.setText("("+measure.get(position)+")");
    }

    @Override
    public int getItemCount() {
        return ingredients.size();
    }

    public class MyViewHolderString extends RecyclerView.ViewHolder{
        TextView ingredients, measure;
        public MyViewHolderString(@NonNull View itemView) {
            super(itemView);
            ingredients = itemView.findViewById(R.id.tvIngredients);
//            measure = itemView.findViewById(R.id.tvMeasure);
        }
    }

}
