package model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Main {
    private double temp;
    private int pressure;
    private int humidity;
    @JsonProperty("temp_min")
    private double min_temp;
    @JsonProperty("temp_max")
    private double max_temp;


    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public double getTemp_min() {
        return min_temp;
    }

    public void setTemp_min(double temp_min) {
        this.min_temp = temp_min;
    }

    public double getTemp_max() {
        return max_temp;
    }

    public void setTemp_max(double temp_max) {
        this.max_temp = temp_max;
    }
}
