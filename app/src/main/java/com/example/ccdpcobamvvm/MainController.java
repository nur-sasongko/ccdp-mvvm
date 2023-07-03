package com.example.ccdpcobamvvm;

public class MainController {
    private MainView view;
    private Celcius model;

    public MainController(MainView view) {
        this.view = view;
        this.model = Celcius.getInstance();
    }

    public void calculateTemperature() {
        String celsius = view.getCelsius();
        if (celsius.isEmpty())
            celsius = "0";

        double parsedCelsius = Double.parseDouble(celsius);
        model.setCelsius(parsedCelsius);

        model.toFahrenheit();
        model.toReamur();
    }
}
