package com.infogramtelemedia.foodlist.Presenter;

import android.util.Log;

import com.infogramtelemedia.foodlist.API.DataViewService;
import com.infogramtelemedia.foodlist.API.RetrofitIntance;
import com.infogramtelemedia.foodlist.Activity.MainActivity;
import com.infogramtelemedia.foodlist.BaseAndContract.ActivityContract;
import com.infogramtelemedia.foodlist.Model.ModelListFood;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PresenterListFood extends ActivityContract.BasePresenter<MainActivity> {
    public PresenterListFood(MainActivity mainActivity) {
        super(mainActivity);
        mActivity.setPresenter(this);
    }

    public void getListFood(){
        Log.e("test", "test");
        DataViewService apiService = RetrofitIntance.getRetrofitIntance().create(DataViewService.class);
        Call<ModelListFood> call = apiService.getListFood();
        call.enqueue(new Callback<ModelListFood>() {
            @Override
            public void onResponse(Call<ModelListFood> call, Response<ModelListFood> response) {
                if(response.code() == 200){
                    Log.e("Success", "success");
                    mActivity.showListFood(response.body().getMeals());
                }else{
                    Log.e("Success", " no success");
                }
            }

            @Override
            public void onFailure(Call<ModelListFood> call, Throwable t) {
                Log.e("getListFoods_Failed", t.getMessage());
            }
        });
    }
}
