package com.example.lab5_q2;

public class PlaceModel
{
    private String placeName;
    private int imageResId;

    public PlaceModel(String placeName, int imageResId) {
        this.placeName = placeName;
        this.imageResId = imageResId;
    }

    public String getPlaceName() {
        return placeName;
    }

    public int getImageResId() {
        return imageResId;
    }
}
