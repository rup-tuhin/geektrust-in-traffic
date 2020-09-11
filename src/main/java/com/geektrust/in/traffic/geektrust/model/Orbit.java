package com.geektrust.in.traffic.geektrust.model;

public class Orbit {

    private String instanceName;
    private int distanceToCover;
    private float numOfCraters;
    private int trafficSpeedMPH;

    public Orbit(String instanceName, int distanceToCover, int numOfCraters) {
        this.instanceName = instanceName;
        this.distanceToCover = distanceToCover;
        this.numOfCraters = numOfCraters;
    }

    public String getInstanceName() {
        return instanceName;
    }

    public int getDistanceToCover() {
        return distanceToCover;
    }

    public float getNumOfCraters() {
        return numOfCraters;
    }

    public float getTrafficSpeedMPH() {
        return trafficSpeedMPH;
    }

    public void setTrafficSpeedMPH(int trafficSpeedMPH) {
        if (trafficSpeedMPH == 0) {
            throw new IllegalArgumentException("Speed should not be zero");
        }
        this.trafficSpeedMPH = trafficSpeedMPH;
    }

    public void modifyNumOfCraters(float percentage) {
        this.numOfCraters = this.numOfCraters * (1 + (percentage / 100));
    }
}
