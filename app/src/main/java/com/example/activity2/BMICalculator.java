package com.example.activity2;

public class BMICalculator {


    public static float calculate_bmi (float weight, float height){
        if (weight > 0 && height > 0){
            return weight  / (height * height);
        }else{
            return -1;
        }
    }

    public static String category (float bmi){
        if (bmi <= 15){
            return "Very severely underweight";
        } else if (bmi <=16) {
            return  "Severely underweight";

        }else if(bmi <= 18.5){
            return  "Underweight";
        } else if (bmi <= 25) {
            return "Normal";
        } else if (bmi <= 30) {
            return "Overweight";

        } else if (bmi <= 35) {
            return "Obese Class I";
        }else if (bmi <= 40){
            return "Obese Class II";
        }else{
            return "Obese Class III";
        }
    }


}


