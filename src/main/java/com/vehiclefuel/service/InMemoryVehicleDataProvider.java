package com.vehiclefuel.service;

import com.vehiclefuel.interfaces.VehicleDataProvider;
import com.vehiclefuel.model.Vehicle;

import java.util.List;

public class InMemoryVehicleDataProvider implements VehicleDataProvider {
    private final List<Vehicle> vehicles;

    public InMemoryVehicleDataProvider(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    @Override
    public List<Vehicle> getVehicles() {
        return vehicles;
    }
}