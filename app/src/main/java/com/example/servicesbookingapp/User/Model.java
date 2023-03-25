package com.example.servicesbookingapp.User;


import android.graphics.drawable.GradientDrawable;

public class Model {


    int pic;
    String title;



    public Model(int pic,String title) {
        this.pic = pic;
        this.title=title;


    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }



}
