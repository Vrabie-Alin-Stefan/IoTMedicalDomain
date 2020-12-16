package com.example.authentification;

import org.junit.Test;

import static org.junit.Assert.*;

public class PulseStatisticsTest {

    @Test
    public void statisticByAge() {
        PulseStatistics ps = new PulseStatistics(84);
        assertTrue(ps.statisticByAge(18).equals("Not normal"));
    }

    @Test
    public void statisticByGender() {
        PulseStatistics ps = new PulseStatistics(90);
        assertEquals(ps.statisticByGender("male"), 0);
    }

    @Test
    public void evaluateBMI() {
        PulseStatistics ps = new PulseStatistics(90);
        assert (ps.evaluateBMI(60, 165).equals("Normal"));
    }

    @Test
    public void statisticsByBMI() {
        PulseStatistics ps = new PulseStatistics(90);
        assertEquals(ps.statisticsByBMI(60, 165), 0);
    }
}