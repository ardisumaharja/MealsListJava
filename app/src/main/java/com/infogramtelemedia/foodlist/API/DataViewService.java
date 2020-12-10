package com.infogramtelemedia.foodlist.API;

import com.infogramtelemedia.foodlist.Model.ModelDetailFood;
import com.infogramtelemedia.foodlist.Model.ModelListFood;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface DataViewService {

    @GET("/api/json/v1/1/filter.php?c=Beef")
    Call<ModelListFood> getListFood();

    @POST("/api/json/v1/1/lookup.php")
    Call<ModelDetailFood> getDetailFood(@Query("i") String i);

}
