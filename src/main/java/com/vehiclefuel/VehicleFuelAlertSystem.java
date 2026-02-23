package com.vehiclefuel;

import com.vehiclefuel.config.AppConfig;
import com.vehiclefuel.interfaces.AlertService;
import com.vehiclefuel.interfaces.VehicleDataProvider;
import com.vehiclefuel.model.Vehicle;
import com.vehiclefuel.service.ConsoleAlertService;
import com.vehiclefuel.service.InMemoryVehicleDataProvider;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class VehicleFuelAlertSystem {

    private static Queue<String> messageQueue = new LinkedList<>();

    public static void main(String[] args) {
        int fuelThreshold = AppConfig.getInt("FUEL_THRESHOLD", 15);
        String alertMessage = AppConfig.getString("ALERT_MESSAGE", "FUEL IS LOW (%FUEL%)");

        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Vehicle("V001", 10));
        vehicles.add(new Vehicle("V002", 50));
        vehicles.add(new Vehicle("V003", 12));

        VehicleDataProvider provider = new InMemoryVehicleDataProvider(vehicles);
        AlertService alertService = new ConsoleAlertService();

        // PRODUCER
        for (Vehicle v : provider.getVehicles()) {
            if (v.getFuelLevel() <= fuelThreshold) {
                String msg = alertMessage.replace("%FUEL%", String.valueOf(v.getFuelLevel()));
                produce(alertService, v, msg);
            }
        }

        // CONSUMER
        System.out.println("\n--- Processing Alerts ---");
        while (!messageQueue.isEmpty()) {
            System.out.println(consume());
        }
    }

    private static void produce(AlertService service, Vehicle vehicle, String msg) {
        String alert = service.formatAlert(vehicle, msg);
        messageQueue.add(alert);
        System.out.println("Produced: " + alert);
    }

    private static String consume() {
        return messageQueue.poll();
    }
}