package com.sturdy_engine;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class APIController {
    private MetricsSingleton metrics = MetricsSingleton.getInstance();

    /**
     * Not part of the API. Use as a test that the
     * app is running.
     * @return  A silly message to verify app is running.
     */
    @GetMapping("/")
    public String index() {
        return "Conglatulation you have won the game";
    }

    /**
     * Creates/clears metric with the provided title.
     * @param title the title of the metric
     * @return  Success message with status.
     */
    @GetMapping("/create/{title}")
    public String create(@PathVariable String title) {
        return metrics.createMetric(title);
    }

    /**
     * Adds a value to the metric.
     * @param title the metric to add to
     * @param value the value to add to the metric
     * @return  Success message with status.
     */
    @GetMapping("/update/{title}")
    public String update(@PathVariable String title, @RequestParam Double value) {
        return metrics.postToMetric(title, value);
    }

    /**
     * Retrieves the requested statistic for the metric.
     * @param title     the metric to return stats on
     * @param statType  the statistic to return
     * @return  Double indicating statistic result.
     * If the metric does not exist, returns zero.
     * If an invalid statType is requested, or any exceptions
     * occur while generating the statistic, throws the exception.
     */
    @GetMapping("/retrieve/{title}")
    public Double retrieve(@PathVariable String title, @RequestParam StatTypes statType) {
        return metrics.retrieveStats(title, statType);
    }
}
