package com.unittest.codecoverage.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TrafficTest {

    private Traffic traffic;

    @BeforeEach
    public void initiate() {
        traffic = new Traffic();
    }


    @Test
    public void testIntenseCarTraffic() {
        traffic.setIntenseCarTraffic(true);
        assertTrue(traffic.intenseCarTraffic());
    }

    @Test
    public void testMinSpeedAllowed() {
        short expected = 30;
        traffic.setMinSpeedAllowed(expected);
        assertEquals(expected, traffic.getMinSpeedAllowed());
    }

    @Test
    public void testMaxSpeedAllowed() {
        short expected = 80;
        traffic.setMaxSpeedAllowed(expected);
        assertEquals(expected, traffic.getMaxSpeedAllowed());
    }


}