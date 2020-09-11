package com.geektrust.in.traffic.geektrust;


import com.geektrust.in.traffic.geektrust.model.Option;
import com.geektrust.in.traffic.geektrust.service.TrafficService;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GeektrustApplication {

    private static TrafficService service = new TrafficService();

    public static void main(String[] args) {
        try {
            String filePath = args[0];
            File file = new File(filePath);
            Scanner s = new Scanner(file);
            String weather = s.next();
            Option ans = service.selectBestRoute(weather, s.nextInt(), s.nextInt());
            System.out.println(ans.getVehicle().getInstanceName() + " " + ans.getOrbit().getInstanceName());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
