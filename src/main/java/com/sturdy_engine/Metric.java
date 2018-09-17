package com.sturdy_engine;

import java.util.ArrayList;

/**
 * Supported statistic types for this API.
 */
enum StatTypes {
    MEAN,MEDIAN,MIN,MAX
}

/**
 * Container for a single set of metric data.
 */
class Metric {
    private ArrayList<Double> _values;

    /**
     * Creates a new instance.
     * Runs in constant time and space.
     */
    Metric () {
        this._values = new ArrayList<>();
    }

    /**
     * Adds value to values of the metric.
     * Uses the ArrayList.add method, which runs in O(N) time and constant space.
     * @param value The value to add to the list of metrics.
     */
    void postValue(Double value) {
        // The add method of the ArrayList runs in O(n) time as the size of the list increases.
        this._values.add(value);
    }

    /**
     * Returns the maximum of the metric values.
     * Time complexity: O(N).
     * Space complexity: Constant.
     * @return  the largest value in the set.
     */
    private Double myMax() {
        if(this._values.isEmpty())
            return 0.0;
        Double max = this._values.get(0); // Default to first elt.
        // size runs in constant time and space
        int size = this._values.size();
        for(int i=0; i<size; i++){
            if(this._values.get(i) > max)
                max = this._values.get(i);
        }
        return max;
    }

    /**
     * Returns the minimum of the metric values.
     * Time complexity: O(N).
     * Space complexity: Constant.
     * @return  the smallest value in the set.
     */
    private Double myMin() {
        if(this._values.isEmpty())
            return 0.0;
        Double min = this._values.get(0); // Default to first elt.
        // size runs in constant time and space
        int size = this._values.size();
        for(int i=0; i<size; i++){
            if(this._values.get(i) < min)
                min = this._values.get(i);
        }
        return min;
    }

    /**
     * Returns the median of the metric values.
     * Note that for lists of even length, the median
     * is the arithmetic mean of the 2 middle values.
     * Time Complexity: O(N log N).
     * Space Complexity: O(N).
     * @return  The median value of the metric.
     */
    private Double myMedian() {
        if(this._values.isEmpty())
            return 0.0;
        // This algorithm runs in O(N log N) time and O(N) space.
        Double[] sortedList = new MyDoubleMergeSort(this._values).sort();
        // size runs in constant time and space
        int size = sortedList.length;
        // accessing array by index runs in constant time and space
        int rightMedianIndex = (int)Math.floor(size / 2);
        if (size % 2 != 0) // odd length
            return sortedList[rightMedianIndex];
        else { // even length
            Double leftMedian = sortedList[rightMedianIndex];
            Double rightMedian = sortedList[rightMedianIndex - 1];
            return (leftMedian + rightMedian) / 2.0;
        }
    }
    /**
     * Returns the arithmetic mean of the metric values.
     * Time complexity: O(N).
     * Space complexity: Constant.
     * @return  the mean value in the set.
     */
    private Double myMean() {
        if(this._values.isEmpty())
            return 0.0;
        Double sum = 0.0;
        // size runs in constant time and space
        int size = this._values.size();
        for(int i=0; i<size; i++){
            sum += this._values.get(i);
        }
        return sum/size;
    }

    /**
     * Returns a double value of the requested stat type.
     * The worst case time complexity is O(N log N) for MEDIAN.
     * The worst case space complexity is O(N) for MEDIAN.
     * @param type  an enum indicating the type of statistic calculation to run
     * @return      the double value of the resulting calculation(0 if
     * no data available).
     */
    Double retrieveStats(StatTypes type){
        switch (type) {
            case MAX:
                return myMax();
            case MIN:
                return myMin();
            case MEDIAN:
                return myMedian();
            case MEAN:
                return myMean();
        }
        return 0.0;
    }
}
