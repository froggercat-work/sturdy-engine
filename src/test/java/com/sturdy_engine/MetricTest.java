package com.sturdy_engine;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MetricTest {
    @Test
    public void retrieveStatsReturnsZeroWhenEmpty() {
        Metric tester = new Metric();
        for (StatTypes type: StatTypes.values()) {
            Double expected = 0.0;
            assertEquals(expected, tester.retrieveStats(type));
        }
    }

    private Metric createTester(Double[] values){
        Metric tester = new Metric();
        for(Double value: values) {
            tester.postValue(value);
        }
        return tester;
    }

    @Test
    public void retrieveStatsMinReturnsMinOfPositiveNumbers() {
        Double[] testValues = new Double[]{0.1,2.0,5.0,9.8,1.3,0.001,20.008};
        Metric tester = createTester(testValues);
        Double expected = 0.001;
        Double actual = tester.retrieveStats(StatTypes.MIN);
        assertEquals(expected,actual);
    }

    @Test
    public void retrieveStatsMinReturnsMinOfNegativeNumbers() {
        Double[] testValues = new Double[]{-0.1,-2.0,-5.0,-9.8,-1.3,-0.001,-20.008};
        Metric tester = createTester(testValues);
        Double expected = -20.008;
        Double actual = tester.retrieveStats(StatTypes.MIN);
        assertEquals(expected,actual);
    }

    @Test
    public void retrieveStatsMinReturnsMinOfPositiveAndNegativeNumbers() {
        Double[] testValues = new Double[]{-0.1,-2.0,5.0,-9.8,1.3,-0.001,20.008};
        Metric tester = createTester(testValues);
        Double expected = -9.8;
        Double actual = tester.retrieveStats(StatTypes.MIN);
        assertEquals(expected,actual);
    }

    @Test
    public void retrieveStatsMaxReturnsMaxOfPositiveNumbers() {
        Double[] testValues = new Double[]{0.1,2.0,5.0,9.8,1.3,0.001,20.008};
        Metric tester = createTester(testValues);
        Double expected = 20.008;
        Double actual = tester.retrieveStats(StatTypes.MAX);
        assertEquals(expected,actual);
    }

    @Test
    public void retrieveStatsMaxReturnsMaxOfNegativeNumbers() {
        Double[] testValues = new Double[]{-0.1,-2.0,-5.0,-9.8,-1.3,-0.001,-20.008};
        Metric tester = createTester(testValues);
        Double expected = -0.001;
        Double actual = tester.retrieveStats(StatTypes.MAX);
        assertEquals(expected,actual);
    }

    @Test
    public void retrieveStatsMaxReturnsMaxOfPositiveAndNegativeNumbers() {
        Double[] testValues = new Double[]{-0.1,-2.0,-5.0,9.8,1.3,-0.001,-20.008};
        Metric tester = createTester(testValues);
        Double expected = 9.8;
        Double actual = tester.retrieveStats(StatTypes.MAX);
        assertEquals(expected,actual);
    }

    private static final double DELTA = 1e-12;

    @Test
    public void retrieveStatsMeanReturnsMeanOfPositiveNumbers() {
        Double[] testValues = new Double[]{0.1,2.0,5.0,9.8,1.3,0.001,20.008};
        Metric tester = createTester(testValues);
        Double expected = 5.4584285714286;
        Double actual = tester.retrieveStats(StatTypes.MEAN);
        assertEquals(expected,actual,DELTA);
    }

    @Test
    public void retrieveStatsMeanReturnsMeanOfNegativeNumbers() {
        Double[] testValues = new Double[]{-0.1,-2.0,-5.0,-9.8,-1.3,-0.001,-20.008};
        Metric tester = createTester(testValues);
        Double expected = -5.4584285714286;
        Double actual = tester.retrieveStats(StatTypes.MEAN);
        assertEquals(expected,actual,DELTA);
    }

    @Test
    public void retrieveStatsMeanReturnsMeanOfPositiveAndNegativeNumbers() {
        Double[] testValues = new Double[]{-0.1,-2.0,-5.0,9.8,1.3,-0.001,-20.008};
        Metric tester = createTester(testValues);
        Double expected = -2.287;
        Double actual = tester.retrieveStats(StatTypes.MEAN);
        assertEquals(expected,actual,DELTA);
    }

    @Test
    public void retrieveStatsMedianReturnsMedianOfPositiveNumbersEvenList() {
        Double[] testValues = new Double[]{0.0,1.0,2.2,3.0};
        Metric tester = createTester(testValues);
        Double expected = 1.6;
        Double actual = tester.retrieveStats(StatTypes.MEDIAN);
        assertEquals(expected,actual);
    }

    @Test
    public void retrieveStatsMedianReturnsMedianOfPositiveNumbersOddList() {
        Double[] testValues = new Double[]{0.0,1.0,4.0};
        Metric tester = createTester(testValues);
        Double expected = 1.0;
        Double actual = tester.retrieveStats(StatTypes.MEDIAN);
        assertEquals(expected,actual);
    }

    @Test
    public void retrieveStatsMedianReturnsMedianOfNegativeNumbersEvenList() {
        Double[] testValues = new Double[]{0.0,-1.0,-2.2,-3.0};
        Metric tester = createTester(testValues);
        Double expected = -1.6;
        Double actual = tester.retrieveStats(StatTypes.MEDIAN);
        assertEquals(expected,actual);
    }

    @Test
    public void retrieveStatsMedianReturnsMedianOfNegativeNumbersOddList() {
        Double[] testValues = new Double[]{0.0,-1.0,-3.0};
        Metric tester = createTester(testValues);
        Double expected = -1.0;
        Double actual = tester.retrieveStats(StatTypes.MEDIAN);
        assertEquals(expected,actual);
    }

    @Test
    public void retrieveStatsMedianReturnsMedianOfPositiveAndNegativeNumbersEvenList() {
        Double[] testValues = new Double[]{0.0,1.0,-2.2,-3.0};
        Metric tester = createTester(testValues);
        Double expected = -1.1;
        Double actual = tester.retrieveStats(StatTypes.MEDIAN);
        assertEquals(expected,actual);
    }

    @Test
    public void retrieveStatsMedianReturnsMedianOfPositiveAndNegativeNumbersOddList() {
        Double[] testValues = new Double[]{0.0,-1.0,-3.0, 4.0, 5.0};
        Metric tester = createTester(testValues);
        Double expected = 0.0;
        Double actual = tester.retrieveStats(StatTypes.MEDIAN);
        assertEquals(expected,actual);
    }
}
