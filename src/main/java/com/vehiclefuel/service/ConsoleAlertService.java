package com.vehiclefuel.service;

import com.vehiclefuel.interfaces.AlertService;
import com.vehiclefuel.model.Vehicle;

public class ConsoleAlertService implements AlertService {
    @Override
    public String formatAlert(Vehicle vehicle, String message) {
        return "ALERT for " + vehicle.getId() + ": " + message;
    }
}