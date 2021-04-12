package com.example.ratingcardview;

public class Model {
     int image;
     boolean status;

    public Model(int image) {
        this.image = image;
        this.status = false;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
