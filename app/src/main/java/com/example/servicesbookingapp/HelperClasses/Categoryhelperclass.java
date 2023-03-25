package com.example.servicesbookingapp.HelperClasses;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;

public class Categoryhelperclass {

    GradientDrawable Gradient;
    int image;
    String catagory;


    public Categoryhelperclass(GradientDrawable gradient, int image, String catagory) {
        Gradient = gradient;
        this.image = image;
        this.catagory = catagory;
    }


    public void setGradient(GradientDrawable gradient) {
        Gradient = gradient;
    }

    public Drawable getGradient() {
        return Gradient;
    }


    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getCatagory() {
        return catagory;
    }

    public void setCatagory(String catagory) {
        this.catagory = catagory;
    }
}
