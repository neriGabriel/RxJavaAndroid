package com.example.rxandroid.model;

import com.google.gson.annotations.SerializedName;

public class Temperature {

    @SerializedName("average")
    private float average;
    private float minimum;
    private float maximum;

    public Temperature() {
    }

    public Temperature(float average, float minimum, float maximum) {
        this.average = average;
        this.minimum = minimum;
        this.maximum = maximum;
    }

    public float getAverage() {
        return average;
    }

    public void setAverage(float average) {
        this.average = average;
    }

    public float getMinimum() {
        return minimum;
    }

    public void setMinimum(float minimum) {
        this.minimum = minimum;
    }

    public float getMaximum() {
        return maximum;
    }

    public void setMaximum(float maximum) {
        this.maximum = maximum;
    }
}
