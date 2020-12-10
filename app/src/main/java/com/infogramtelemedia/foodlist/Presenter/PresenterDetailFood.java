package com.infogramtelemedia.foodlist.Presenter;

import android.util.Log;

import com.google.gson.Gson;
import com.infogramtelemedia.foodlist.API.DataViewService;
import com.infogramtelemedia.foodlist.API.RetrofitIntance;
import com.infogramtelemedia.foodlist.Activity.DetailFoodActivity;
import com.infogramtelemedia.foodlist.BaseAndContract.ActivityContract;
import com.infogramtelemedia.foodlist.Model.ModelDetailFood;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PresenterDetailFood extends ActivityContract.BasePresenter<DetailFoodActivity> {
    public PresenterDetailFood(DetailFoodActivity detailFoodActivity) {
        super(detailFoodActivity);
    }

    public void detailFood(String idMeals){
        DataViewService apiService = RetrofitIntance.getRetrofitIntance().create(DataViewService.class);
        Call<ModelDetailFood> call = apiService.getDetailFood(idMeals);
        call.enqueue(new Callback<ModelDetailFood>() {
            @Override
            public void onResponse(Call<ModelDetailFood> call, Response<ModelDetailFood> response) {
                if(response.code() == 200){
                    Log.e("Detail Success ", "success");
                    Log.e("Detail Success ", response.body().getMeals().get(0).getMealsName());
                    Gson gson = new Gson();
                    Log.e("Detail food", gson.toJson(response.body().getMeals()));
                    mActivity.initView(response.body().getMeals().get(0));
                    mActivity.videoId = response.body().getMeals().get(0).getYoutube();
                    mActivity.modelDetailFood_ = response.body().getMeals().get(0);
                }else{
                    Log.e("Detail Success", response.code()+"");
                }
            }

            @Override
            public void onFailure(Call<ModelDetailFood> call, Throwable t) {
                Log.e("Detail Failed", t.getMessage());
            }
        });
    }
}
