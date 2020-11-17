package com.example.timer;

public class DataModeling {

    private static DataModeling instance = new DataModeling();

    private float temperature;
    private float bloodPresure;
    private float oxygen;
    private float heartBeats;

    public static DataModeling getInstance()
    {
        return instance;
    }

    public String Diagnostic(float _temp, float _blood, float _heart, float _oxygen)
    {
        return "Sanatos :)";
    }

    public void setBloodPresure(float bloodPresure) {
        this.bloodPresure = bloodPresure;
    }

    public float getBloodPresure() {
        return bloodPresure;
    }

    public void setHeartBeats(float heartBeats) {
        this.heartBeats = heartBeats;
    }

    public float getHeartBeats() {
        return heartBeats;
    }

    public void setOxygen(float oxygen) {
        this.oxygen = oxygen;
    }

    public float getOxygen() {
        return oxygen;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getTemperature() {
        return temperature;
    }

}
