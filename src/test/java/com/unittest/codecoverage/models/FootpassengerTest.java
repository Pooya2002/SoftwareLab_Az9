package com.unittest.codecoverage.models;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class FootpassengerTest {
    @Test
    void testCrossedTheCrosswalk() {
        Footpassenger footpassenger = new Footpassenger();
        footpassenger.setCrossedTheCrosswalk(true);

        boolean result = footpassenger.crossedTheCrosswalk();

        assertTrue(result, "Footpassenger should have crossed the crosswalk.");
    }
}