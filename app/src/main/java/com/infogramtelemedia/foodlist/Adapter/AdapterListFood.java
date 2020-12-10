package com.infogramtelemedia.foodlist.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.infogramtelemedia.foodlist.Model.ModelDetailFood;
import com.infogramtelemedia.foodlist.Model.ModelListFood;
import com.infogramtelemedia.foodlist.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AdapterListFood extends RecyclerView.Adapter<AdapterListFood.MyViewHolder> implements Filterable {
    Context context;
    List<ModelListFood.Meals> list;
    List<ModelListFood.Meals> listFull;

    public AdapterListFood(List<ModelListFood.Meals> listFood, Context context) {
        Log.e("listSize", listFood.size()+"");
        this.list = listFood;
        this.context = context;
        this.listFull = new ArrayList<>(listFood);
    }

    @Override
    public Filter getFilter() {
        return FilterFood;
    }

    private Filter FilterFood = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            String searchText = constraint.toString().toLowerCase();
            List<ModelListFood.Meals> temptList = new ArrayList<>();
            if(searchText.length() == 0 || searchText.isEmpty()){
                temptList.addAll(listFull);
            }else{
                for(ModelListFood.Meals item : listFull){
                    if(item.getMealName().toLowerCase().contains(searchText)){
                        temptList.add(item);
                    }
                }
            }

            FilterResults filterResults = new FilterResults();
            filterResults.values = temptList;
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            list.clear();
            list.addAll((Collection<? extends ModelListFood.Meals>) results.values);
            notifyDataSetChanged();
        }
    };

    public interface OnItemClickListener{
        void OnClick(int position);
    }

    OnItemClickListener mListener;

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(context).inflate(R.layout.item_list_food, parent, false);
        final MyViewHolder viewHolder = new MyViewHolder(view, mListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvFoodName.setText(list.get(position).getMealName());
        Picasso.get()
                .load(list.get(position).getMealImage())
                .into(holder.imgFood);
    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
//        CardView container;
        ImageView imgFood;
        TextView tvFoodName;
        public MyViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
//            container = itemView.findViewById(R.id.containerItemListFood);
            imgFood = itemView.findViewById(R.id.imgFood);
            tvFoodName = itemView.findViewById(R.id.tvFoodName);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.OnClick(getAdapterPosition());
                }
            });
        }
    }
}
