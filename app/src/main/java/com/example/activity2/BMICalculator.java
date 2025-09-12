package com.example.activity2;
import android.annotation.SuppressLint;
import java.util.Arrays;
import java.util.List;

public class BMICalculator {
    float height;
    float weight;
    float bmi;

    public BMICalculator (float heights, float weights){
        this.height = heights;
        this.weight = weights;
    }

    static List<Float> bmis = Arrays.asList(15.0f, 16.0f, 18.5f, 25.0f, 30.0f, 35.0f, 40.0f);

    public float calculate_bmi (){
        if (weight > 0 && height > 0){
            bmi = weight  / (height * height);
            return bmi;
        }else{
            return -1;
        }
    }

    public float getLowerBMIThreshold(int currentClass){
        if (currentClass == 0){
            return -1;
        }

        if (currentClass == 1) {
            return 15.0f - 0.1f;
        } else {
            return bmis.get(currentClass - 1) - 0.1f;
        }
    }

    public float getHigherBMIThreshold(int currentClass){
        if (currentClass == 7){
            return -1;
        }

        return bmis.get(currentClass) + 0.1f;
    }

    public boolean validator(float BMI){
        if (BMI == -1){
            return false;
        }
        return true;
    }

    @SuppressLint("DefaultLocale")
    public String getLowerBMI (){
        int bmiClass = returnBMIclass(bmi);
        float targetBMI = getLowerBMIThreshold(bmiClass);

        if (validator(targetBMI)){
            float weightNeeded = getNeededWeight(targetBMI, height);
            return String.format("You need to lose %.2f kg to get into %s!",
                    weight - weightNeeded, category(bmiClass - 1));
        } else {
            return "You're currently at the lowest BMI class! Eat more!";
        }
    }

    @SuppressLint("DefaultLocale")
    public String getHigherBMI (){
        int bmiClass = returnBMIclass(bmi);
        float targetBMI = getHigherBMIThreshold(bmiClass);

        if (validator(targetBMI)){
            float weightNeeded = getNeededWeight(targetBMI, height);
            return String.format("You need to gain %.2f kg to get into %s!",
                    weightNeeded - weight, category(bmiClass + 1));
        }else{
            return "You're currently at the highest BMI class! Eat less!";
        }
    }

    public int returnBMIclass (float bmi){
        if (bmi <= 15){
            return 0;
        } else if (bmi <= 16) {
            return 1;
        } else if(bmi <= 18.5){
            return 2;
        } else if (bmi <= 25) {
            return 3;
        } else if (bmi <= 30) {
            return 4;
        } else if (bmi <= 35) {
            return 5;
        } else if (bmi <= 40){
            return 6;
        } else {
            return 7;
        }
    }

    public String category (float bmi){
        if (bmi <= 15){
            return "Very severely underweight";
        } else if (bmi <= 16) {
            return "Severely underweight";
        } else if(bmi <= 18.5){
            return "Underweight";
        } else if (bmi <= 25) {
            return "Normal";
        } else if (bmi <= 30) {
            return "Overweight";
        } else if (bmi <= 35) {
            return "Obese Class I";
        } else if (bmi <= 40){
            return "Obese Class II";
        } else {
            return "Obese Class III";
        }
    }

    public String category(int classIndex){
        switch(classIndex){
            case 0: return "Very severely underweight";
            case 1: return "Severely underweight";
            case 2: return "Underweight";
            case 3: return "Normal";
            case 4: return "Overweight";
            case 5: return "Obese Class I";
            case 6: return "Obese Class II";
            case 7: return "Obese Class III";
            default: return "Unknown";
        }
    }

    public float getNeededWeight(float bmi, float height){
        return bmi * (height * height);
    }
}