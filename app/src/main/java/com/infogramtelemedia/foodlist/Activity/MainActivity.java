package com.infogramtelemedia.foodlist.Activity;

import androidx.annotation.Nullable;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SearchView;

//import com.infogramtelemedia.foodlist.Adapter.AdapterListFood;
import com.infogramtelemedia.foodlist.Adapter.AdapterListFood;
import com.infogramtelemedia.foodlist.BaseAndContract.ActivityContract;
import com.infogramtelemedia.foodlist.BaseAndContract.BaseActivity;
import com.infogramtelemedia.foodlist.Model.ModelListFood;
import com.infogramtelemedia.foodlist.Presenter.PresenterListFood;
import com.infogramtelemedia.foodlist.R;

import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements ActivityContract.BaseActivityView<PresenterListFood> {

    @BindView(R.id.svFood)
    SearchView searchView;
    @BindView(R.id.listFood)
    RecyclerView recyclerView;

    AdapterListFood adapterListFood;
    PresenterListFood presenterListFood;

    @Override
    public int getLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    public void initListenerView() {

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapterListFood.getFilter().filter(newText);
                return false;
            }
        });


    }

    @Override
    public void setPresenter(PresenterListFood presenterListFood) {
        this.presenterListFood = presenterListFood;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.presenterListFood = new PresenterListFood(this);
        this.presenterListFood.getListFood();
    }

    public void showListFood(final List<ModelListFood.Meals> listFood){
        adapterListFood = new AdapterListFood(listFood, getApplicationContext());

//        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(gridLayoutManager);

        recyclerView.setAdapter(adapterListFood);
        adapterListFood.setOnItemClickListener(new AdapterListFood.OnItemClickListener() {
            @Override
            public void OnClick(int position) {
                Intent intent = new Intent(MainActivity.this, DetailFoodActivity.class);
                intent.putExtra("idFood", listFood.get(position).getIdMeal());
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onSearchRequested() {
        return super.onSearchRequested();

    }
}
