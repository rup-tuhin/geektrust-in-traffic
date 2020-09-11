package com.geektrust.in.traffic.geektrust.model;

public class Option {
    private Vehicle vehicle;
    private Orbit orbit;

    public Option(Vehicle vehicle, Orbit orbit) {
        this.vehicle = vehicle;
        this.orbit = orbit;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Orbit getOrbit() {
        return orbit;
    }


}
