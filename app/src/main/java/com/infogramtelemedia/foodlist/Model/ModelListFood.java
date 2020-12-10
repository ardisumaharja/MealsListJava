package com.infogramtelemedia.foodlist.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ModelListFood {

//    @SerializedName("meals")
//    String meals;

    @SerializedName("meals")
    List<Meals> meals;

    public class Meals {
        @SerializedName("idMeal")
        String idMeal;

        @SerializedName("strMeal")
        String mealName;

        @SerializedName("strMealThumb")
        String mealImage;

        public String getIdMeal() {
            return idMeal;
        }

        public String getMealName() {
            return mealName;
        }

        public String getMealImage() {
            return mealImage;
        }
    }

    public List<Meals> getMeals() {
        return meals;
    }
}
