package com.infogramtelemedia.foodlist.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ModelDetailFood {
    @SerializedName("meals")
    List<DetailFood> meals;

    List<String> ingredients;

    public class DetailFood {
        @SerializedName("strYoutube")
        String youtube;

        public String getYoutube() {
            return youtube;
        }

        @SerializedName("strMeal")
        String mealsName;
        @SerializedName("strInstructions")
        String instructions;
        @SerializedName("strMealThumb")
        String mealsImage;
        @SerializedName("strIngredient1")
        String ingredient1;
        @SerializedName("strIngredient2")
        String ingredient2;
        @SerializedName("strIngredient3")
        String ingredient3;
        @SerializedName("strIngredient4")
        String ingredient4;
        @SerializedName("strIngredient5")
        String ingredient5;
        @SerializedName("strIngredient6")
        String ingredient6;
        @SerializedName("strIngredient7")
        String ingredient7;
        @SerializedName("strIngredient8")
        String ingredient8;
        @SerializedName("strIngredient9")
        String ingredient9;
        @SerializedName("strIngredient10")
        String ingredient10;
        @SerializedName("strIngredient11")
        String ingredient11;
        @SerializedName("strIngredient12")
        String ingredient12;
        @SerializedName("strIngredient13")
        String ingredient13;
        @SerializedName("strIngredient14")
        String ingredient14;
        @SerializedName("strIngredient15")
        String ingredient15;
        @SerializedName("strIngredient16")
        String ingredient16;
        @SerializedName("strIngredient17")
        String ingredient17;
        @SerializedName("strIngredient18")
        String ingredient18;
        @SerializedName("strIngredient19")
        String ingredient19;
        @SerializedName("strIngredient20")
        String ingredient20;

        @SerializedName("strMeasure1")
        String measure1;
        @SerializedName("strMeasure2")
        String measure2;
        @SerializedName("strMeasure3")
        String measure3;
        @SerializedName("strMeasure4")
        String measure4;
        @SerializedName("strMeasure5")
        String measure5;
        @SerializedName("strMeasure6")
        String measure6;
        @SerializedName("strMeasure7")
        String measure7;
        @SerializedName("strMeasure8")
        String measure8;
        @SerializedName("strMeasure9")
        String measure9;
        @SerializedName("strMeasure10")
        String measure10;
        @SerializedName("strMeasure11")
        String measure11;
        @SerializedName("strMeasure12")
        String measure12;
        @SerializedName("strMeasure13")
        String measure13;
        @SerializedName("strMeasure14")
        String measure14;
        @SerializedName("strMeasure15")
        String measure15;
        @SerializedName("strMeasure16")
        String measure16;
        @SerializedName("strMeasure17")
        String measure17;
        @SerializedName("strMeasure18")
        String measure18;
        @SerializedName("strMeasure19")
        String measure19;
        @SerializedName("strMeasure20")
        String measure20;

        public String getMealsName() {

            return mealsName;
        }

        public String getInstructions() {

            return instructions;
        }

        public String getMealsImage() {
            return mealsImage;
        }

        public String getIngredient1() {
            return ingredient1;
        }

        public String getIngredient2() {
            return ingredient2;
        }

        public String getIngredient3() {
            return ingredient3;
        }

        public String getIngredient4() {
            return ingredient4;
        }

        public String getIngredient5() {
            return ingredient5;
        }

        public String getIngredient6() {
            return ingredient6;
        }

        public String getIngredient7() {
            return ingredient7;
        }

        public String getIngredient8() {
            return ingredient8;
        }

        public String getIngredient9() {
            return ingredient9;
        }

        public String getIngredient10() {
            return ingredient10;
        }

        public String getIngredient11() {
            return ingredient11;
        }

        public String getIngredient12() {
            return ingredient12;
        }

        public String getIngredient13() {
            return ingredient13;
        }

        public String getIngredient14() {
            return ingredient14;
        }

        public String getIngredient15() {
            return ingredient15;
        }

        public String getIngredient16() {
            return ingredient16;
        }

        public String getIngredient17() {
            return ingredient17;
        }

        public String getIngredient18() {
            return ingredient18;
        }

        public String getIngredient19() {
            return ingredient19;
        }

        public String getIngredient20() {
            return ingredient20;
        }


        public String getMeasure1() {
            return measure1;
        }

        public String getMeasure2() {
            return measure2;
        }

        public String getMeasure3() {
            return measure3;
        }

        public String getMeasure4() {
            return measure4;
        }

        public String getMeasure5() {
            return measure5;
        }

        public String getMeasure6() {
            return measure6;
        }

        public String getMeasure7() {
            return measure7;
        }

        public String getMeasure8() {
            return measure8;
        }

        public String getMeasure9() {
            return measure9;
        }

        public String getMeasure10() {
            return measure10;
        }

        public String getMeasure11() {
            return measure11;
        }

        public String getMeasure12() {
            return measure12;
        }

        public String getMeasure13() {
            return measure13;
        }

        public String getMeasure14() {
            return measure14;
        }

        public String getMeasure15() {
            return measure15;
        }

        public String getMeasure16() {
            return measure16;
        }

        public String getMeasure17() {
            return measure17;
        }

        public String getMeasure18() {
            return measure18;
        }

        public String getMeasure19() {
            return measure19;
        }

        public String getMeasure20() {
            return measure20;
        }
    }

    public List<DetailFood> getMeals() {
        return meals;
    }

    public List listIngerdients(DetailFood food){

        List<String> ingredients = new ArrayList<>();

        if(food.getIngredient1() != "" && food.getIngredient1() != null )
            ingredients.add(food.getIngredient1());
        if(food.getIngredient2() != "" && food.getIngredient2() != null)
            ingredients.add(food.getIngredient2());
        if(food.getIngredient3() != "" && food.getIngredient3() != null)
            ingredients.add(food.getIngredient3());
        if(food.getIngredient4() != "" && food.getIngredient4() != null)
            ingredients.add(food.getIngredient4());
        if(food.getIngredient5() != "" && food.getIngredient5() != null)
            ingredients.add(food.getIngredient5());
        if(food.getIngredient6() != "" && food.getIngredient6() != null)
            ingredients.add(food.getIngredient6());
        if(food.getIngredient7() != "" && food.getIngredient7() != null)
            ingredients.add(food.getIngredient7());
        if(food.getIngredient8() != "" && food.getIngredient8() != null)
            ingredients.add(food.getIngredient8());
        if(food.getIngredient9() != "" && food.getIngredient9() != null)
            ingredients.add(food.getIngredient9());
        if(food.getIngredient10() != "" && food.getIngredient10() != null)
            ingredients.add(food.getIngredient10() );

        if(food.getIngredient11() != "" && food.getIngredient11() != null)
            ingredients.add(food.getIngredient11());
        if(food.getIngredient12() != "" && food.getIngredient12() != null)
            ingredients.add(food.getIngredient12());
        if(food.getIngredient13() != "" && food.getIngredient13() != null)
            ingredients.add(food.getIngredient13());
        if(food.getIngredient14() != "" && food.getIngredient14() != null)
            ingredients.add(food.getIngredient14());
        if(food.getIngredient15() != "" && food.getIngredient15() != null)
            ingredients.add(food.getIngredient15());
        if(food.getIngredient16() != "" && food.getIngredient16() != null)
            ingredients.add(food.getIngredient16());
        if(food.getIngredient17() != "" && food.getIngredient17() != null)
            ingredients.add(food.getIngredient17());
        if(food.getIngredient18() != "" && food.getIngredient18() != null)
            ingredients.add(food.getIngredient18());
        if(food.getIngredient19() != "" && food.getIngredient19() != null)
            ingredients.add(food.getIngredient19());
        if(food.getIngredient20() != "" && food.getIngredient20() != null)
            ingredients.add(food.getIngredient20());
        return ingredients;
    }

    public List listMeasure(DetailFood list){

        List<String> measurements = new ArrayList<>();

        if(list.getMeasure1() != "" && list.getMeasure1() != null)
            measurements.add(list.getMeasure1());
        if(list.getMeasure2() != "" && list.getMeasure2() != null)
            measurements.add(list.getMeasure2());
        if(list.getMeasure3() != "" && list.getMeasure3() != null)
            measurements.add(list.getMeasure3());
        if(list.getMeasure4() != "" && list.getMeasure4() != null)
            measurements.add(list.getMeasure4());
        if(list.getMeasure5() != "" && list.getMeasure5() != null)
            measurements.add(list.getMeasure5());
        if(list.getMeasure6() != "" && list.getMeasure6() != null)
            measurements.add(list.getMeasure6());
        if(list.getMeasure7() != "" && list.getMeasure7() != null)
            measurements.add(list.getMeasure7());
        if(list.getMeasure8() != "" && list.getMeasure8() != null)
            measurements.add(list.getMeasure8());
        if(list.getMeasure9() != "" && list.getMeasure9() != null)
            measurements.add(list.getMeasure9());
        if(list.getMeasure10() != "" && list.getMeasure10() != null)
            measurements.add(list.getMeasure10());

        if(list.getMeasure11() != "" && list.getMeasure11() != null)
            measurements.add(list.getMeasure11());
        if(list.getMeasure12() != "" && list.getMeasure12() != null)
            measurements.add(list.getMeasure12());
        if(list.getMeasure13() != "" && list.getMeasure13() != null)
            measurements.add(list.getMeasure13());
        if(list.getMeasure14() != "" && list.getMeasure14() != null)
            measurements.add(list.getMeasure14());
        if(list.getMeasure15() != "" && list.getMeasure15() != null)
            measurements.add(list.getMeasure15());
        if(list.getMeasure16() != "" && list.getMeasure16() != null)
            measurements.add(list.getMeasure16());
        if(list.getMeasure17() != "" && list.getMeasure17() != null)
            measurements.add(list.getMeasure17());
        if(list.getMeasure18() != "" && list.getMeasure18() != null)
            measurements.add(list.getMeasure18());
        if(list.getMeasure19() != "" && list.getMeasure19() != null)
            measurements.add(list.getMeasure19());
        if(list.getMeasure20() != "" && list.getMeasure20() != null)
            measurements.add(list.getMeasure20());

        return measurements;
    }
}
