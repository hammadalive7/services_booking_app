package com.example.servicesbookingapp.User;

public class Model1 {


    int pic,pic1;
    String title;


    public Model1(int pic,int pic1,String title) {
        this.pic = pic;
        this.pic1=pic1;
        this.title=title;

    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    public int getPic1() {
        return pic1;
    }

    public void setPic1(int pic1) {
        this.pic1 = pic1;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }



}
