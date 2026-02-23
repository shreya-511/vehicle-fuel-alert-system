package com.vehiclefuel.interfaces;

import com.vehiclefuel.model.Vehicle;

public interface AlertService {
    String formatAlert(Vehicle vehicle, String message);
}