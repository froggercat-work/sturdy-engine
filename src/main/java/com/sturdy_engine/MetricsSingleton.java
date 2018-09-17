package com.sturdy_engine;

import java.util.HashMap;
import java.util.Map;

/**
 * Singleton holding all Metric classes for the instance.
 * Access the singleton using getInstance().
 */
class MetricsSingleton {
    /**
     * The list of all metrics created since the start of the instance.
     */
    private Map<String,Metric> metrics;

    /**
     * The singleton instance.
     */
    private static MetricsSingleton instance = null;

    /**
     * Use this method to create/ access the singleton.
     * @return  The existing (newed up as needed) instance of MetricsSingleton.
     */
    static MetricsSingleton getInstance(){
        if(instance==null){
            instance = new MetricsSingleton();
            // Will provide constant-time and O(N) space get/ put performance.
            instance.metrics = new HashMap<>();
        }
        return instance;
    }

    /**
     * Adds value to corresponding metric in memory.
     * Time Complexity: O(N).
     * Space Complexity: O(N).
     * @param title the title associated with the metric
     * @param value the value to add to the metric
     * @return  String indicating success. Throws exceptions.
     */
    String postToMetric(String title, Double value) {
        // Getting the metric is constant-time, O(N) space.
        if(this.metrics.get(title)==null) {
            return "Error: Metric does not exist.";
        }
        // postValue is O(N) time and space.
        this.metrics.get(title).postValue(value);
        return "Success: Updated metric.";
    }

    /**
     * Adds a new metric with empty value set.
     * If the metric already exists, replaces it with a new, empty metric.
     * Time Complexity: Constant.
     * Space Complexity: O(N).
     * @param title The metric to create/ clear.
     * @return  String indicating success. Throws exceptions.
     */
    String createMetric(String title) {
        String response = "Success: Created metric.";
        // Getting the metric is constant-time, O(N) space.
        if(this.metrics.get(title)!=null) {
            this.metrics.remove(title);
            response = "Success: Cleared metric.";
        }
        // Putting the metric is constant-time, O(N) space.
        this.metrics.put(title, new Metric());
        return response;
    }

    /**
     * Returns a double value of the requested stat type.
     * The worst case time complexity is O(N log N) for MEDIAN.
     * The worst case space complexity is O(N) for MEDIAN.
     * @param title the title of the metric to retrieve stats for
     * @param type  the type of statistic to retrieve stats for
     * @return  Double containing the calculated value. If the
     * metric does not exist, returns 0.0. If there is an exception
     * (i.e. invalid stat type, concurrency violation), throws
     * the exception.
     */
    Double retrieveStats(String title, StatTypes type) {
        if(this.metrics.get(title)==null) {
            return 0.0;
        }
        return this.metrics.get(title).retrieveStats(type);
    }
}
