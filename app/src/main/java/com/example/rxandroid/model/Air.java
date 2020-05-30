package com.example.rxandroid.model;

public class Air {
    private Temperature temperature;

    public Air() {
    }

    public Air(Temperature temperature) {
        this.temperature = temperature;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }
}
