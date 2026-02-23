package com.vehiclefuel.interfaces;

import com.vehiclefuel.model.Vehicle;
import java.util.List;

public interface VehicleDataProvider {
    List<Vehicle> getVehicles();
}