package com.sturdy_engine;

import java.util.ArrayList;

class MyDoubleMergeSort {
    private Double[] _list;
    private Double[] _tmpList;

    /**
     * Instantiates provided list as raw data for sort.
     * Supports conversion of ArrayList(Double) only.
     * @param rawList   The raw list data to be converted to an array.
     */
    MyDoubleMergeSort(ArrayList<Double> rawList) {
        this._list =  new Double[rawList.size()];
        this._list = rawList.toArray(this._list);
    }

    /**
     * Implements merge sort to sort list in ascending numerical order.
     * Time Complexity: O(N log N)
     * Space Complexity: O(N)
     * @return  sorted list as Double[] in ascending numerical order.
     */
    Double[] sort() {
        this._tmpList = new Double[this._list.length];
        mergeSort(0, this._list.length - 1);
        return this._tmpList;
    }

    private void mergeSort(int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            mergeSort(left, center);
            mergeSort(center + 1, right);
            merge(left, center + 1, right);
        }
    }

    private void merge(int left, int right, int rightEnd) {
        int leftEnd = right - 1;
        int k = left;
        int num = rightEnd - left + 1;

        while(left <= leftEnd && right <= rightEnd)
            if(this._list[left].compareTo(this._list[right]) <= 0)
                this._tmpList[k++] = this._list[left++];
            else
                this._tmpList[k++] = this._list[right++];

        while(left <= leftEnd)    // Copy rest of first half
            this._tmpList[k++] = this._list[left++];

        while(right <= rightEnd)  // Copy rest of right half
            this._tmpList[k++] = this._list[right++];

        // Copy tmp back
        for(int i = 0; i < num; i++, rightEnd--)
            this._list[rightEnd] = this._tmpList[rightEnd];
    }
}
