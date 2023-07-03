package com.example.ccdpcobamvvm;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class Celcius {
    private static Celcius instance;

    private double celsius;

    private MutableLiveData<String> reamur;
    private MutableLiveData<String> fahrenheit;

    private Celcius() {
        this.celsius = 0;
        this.reamur = new MutableLiveData<>();
        this.fahrenheit = new MutableLiveData<>();
    }

    public static synchronized Celcius getInstance() {
        if (instance == null) {
            instance = new Celcius();
        }

        return instance;
    }

    public static void destroy() {
        instance = null;
    }

    public LiveData<String> getReamur() {
        return reamur;
    }

    public LiveData<String> getFahrenheit() {
        return fahrenheit;
    }

    public void setCelsius(double celsius) {
        this.celsius = celsius;
    }

    public void toReamur() {
        double reamur = 0.8 * celsius;
        this.reamur.setValue(reamur + "");
    }

    public void toFahrenheit() {
        double fahrenheit = (1.8 * celsius) + 32;
        this.fahrenheit.setValue(fahrenheit + "");
    }
}
