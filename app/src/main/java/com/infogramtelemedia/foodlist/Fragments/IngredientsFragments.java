package com.infogramtelemedia.foodlist.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.infogramtelemedia.foodlist.Adapter.AdapterListString;
import com.infogramtelemedia.foodlist.Adapter.AdapterPages;
import com.infogramtelemedia.foodlist.Model.ModelDetailFood;
import com.infogramtelemedia.foodlist.R;

import java.io.Serializable;

import butterknife.BindView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link IngredientsFragments#newInstance} factory method to
 * create an instance of this fragment.
 */
public class IngredientsFragments extends Fragment {

    RecyclerView recyclerView;
    AdapterListString adapterListString;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public IngredientsFragments() {
        // Required empty public constructor
    }

    public void initDataIngredients(ModelDetailFood.DetailFood detailFood){
        Gson gson = new Gson();
        Log.e("data", gson.toJson(detailFood));
        ModelDetailFood ingredients = new ModelDetailFood();
        adapterListString = new AdapterListString(ingredients.listIngerdients(detailFood), ingredients.listMeasure(detailFood));
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ingredients_fragments, container, false);
        recyclerView = view.findViewById(R.id.frvIngredients);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(adapterListString);
        return view;
    }
}
