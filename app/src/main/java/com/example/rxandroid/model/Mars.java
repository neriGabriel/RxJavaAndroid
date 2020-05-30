package com.example.rxandroid.model;

import com.google.gson.annotations.SerializedName;

public class Mars {
    private String season;
    private Air air;

    public Mars() {
    }

    public Mars(String season, Air air) {
        this.season = season;
        this.air = air;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public Air getAir() {
        return air;
    }

    public void setAir(Air air) {
        this.air = air;
    }
}

