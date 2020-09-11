package com.geektrust.in.traffic.geektrust.service;

import com.geektrust.in.traffic.geektrust.model.Option;
import com.geektrust.in.traffic.geektrust.model.Orbit;
import com.geektrust.in.traffic.geektrust.model.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class TrafficService {

    private Orbit orbit1 = new Orbit("ORBIT1", 18, 20);
    private Orbit orbit2 = new Orbit("ORBIT2", 20, 10);

    private Vehicle bike = new Vehicle("BIKE", 10, 2);
    private Vehicle tuktuk = new Vehicle("TUKTUK", 12, 1);
    private Vehicle car = new Vehicle("CAR", 20, 3);

    public Option selectBestRoute(String weather, int orb1Speed, int orb2Speed) {
        /*System.out.println(String.format("Selecting best route in %s weather", weather));
        System.out.println(String.format("Orbit 1 Speed : %s", orb1Speed));
        System.out.println(String.format("Orbit 2 Speed : %s", orb2Speed));*/
        List<Vehicle> allowedVehicles = new ArrayList<>();
        orbit1.setTrafficSpeedMPH(orb1Speed);
        orbit2.setTrafficSpeedMPH(orb2Speed);
        // process weather conditions.
        if (weather != null) {
            switch (weather.toLowerCase()) {
                case "sunny":
                    orbit1.modifyNumOfCraters(-10);
                    orbit2.modifyNumOfCraters(-10);
                    allowedVehicles.add(bike);
                    allowedVehicles.add(tuktuk);
                    allowedVehicles.add(car);
                    break;
                case "rainy":
                    orbit1.modifyNumOfCraters(20);
                    orbit2.modifyNumOfCraters(20);
                    allowedVehicles.add(tuktuk);
                    allowedVehicles.add(car);
                    break;
                case "windy":
                    allowedVehicles.add(bike);
                    allowedVehicles.add(car);
                    break;
                default:
                    throw new IllegalArgumentException("Not programmed for this weather : " + weather);
            }
        } else {
            throw new IllegalArgumentException("Not programmed for this weather : " + weather);
        }

        TreeMap<Float, Option> answer = new TreeMap<>();
        allowedVehicles.forEach(v -> {
            answer.put(v.timeToCrossOrbit(orbit1), new Option(v, orbit1));
            answer.put(v.timeToCrossOrbit(orbit2), new Option(v, orbit2));
        });

        return answer.firstEntry().getValue();
    }
}
