package com.geektrust.in.traffic.geektrust;


import com.geektrust.in.traffic.geektrust.model.Option;
import com.geektrust.in.traffic.geektrust.service.TrafficService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class TrafficServiceTest {

    private TrafficService service = new TrafficService();

    @Test
    public void testCasePositive() {
        Option ans = service.selectBestRoute("RAINY", 40, 25);
        assertEquals("CAR", ans.getVehicle().getInstanceName());
        assertEquals("ORBIT2", ans.getOrbit().getInstanceName());

        ans = service.selectBestRoute("SUNNY", 12, 10);
        assertEquals("TUKTUK", ans.getVehicle().getInstanceName());
        assertEquals("ORBIT1", ans.getOrbit().getInstanceName());

        ans = service.selectBestRoute("WINDY", 14, 20);
        assertEquals("CAR", ans.getVehicle().getInstanceName());
        assertEquals("ORBIT2", ans.getOrbit().getInstanceName());

        ans = service.selectBestRoute("RAINY", 8, 15);
        assertEquals("TUKTUK", ans.getVehicle().getInstanceName());
        assertEquals("ORBIT2", ans.getOrbit().getInstanceName());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testCaseNegativeNull() {
        Option ans = service.selectBestRoute(null, 40, 25);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testCaseNegativeUnknown() {
        Option ans = service.selectBestRoute("UNKNOWN", 40, 25);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testCaseNegativeZeroSpeed1() {
        Option ans = service.selectBestRoute("RAINY", 0, 25);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testCaseNegativeZeroSpeed2() {
        Option ans = service.selectBestRoute("RAINY", 40, 0);
    }

}
