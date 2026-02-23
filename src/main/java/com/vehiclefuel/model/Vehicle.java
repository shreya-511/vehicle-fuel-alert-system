package com.vehiclefuel.model;

public class Vehicle {
    private String id;
    private int fuelLevel;

    public Vehicle(String id, int fuelLevel) {
        this.id = id;
        this.fuelLevel = fuelLevel;
    }

    public String getId() { return id; }
    public int getFuelLevel() { return fuelLevel; }
}