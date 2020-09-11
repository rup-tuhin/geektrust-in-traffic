package com.geektrust.in.traffic.geektrust.model;

import static java.util.Objects.requireNonNull;

public class Vehicle {

    private String instanceName;
    private int speedMPH;
    private int minToCrossCrater;

    public Vehicle(String instanceName, int speedMPH, int minToCrossCrater) {
        this.instanceName = instanceName;
        this.speedMPH = speedMPH;
        this.minToCrossCrater = minToCrossCrater;
    }

    public String getInstanceName() {
        return instanceName;
    }

    public float timeToCrossOrbit(Orbit orbit) {
        requireNonNull(orbit, "This vehicle isn't suitable to cross NULL Orbit");
        float speed = orbit.getTrafficSpeedMPH() <= this.speedMPH ? orbit.getTrafficSpeedMPH() : this.speedMPH;
        return (orbit.getDistanceToCover() * 60 / speed) + (orbit.getNumOfCraters() * this.minToCrossCrater);
    }
}
