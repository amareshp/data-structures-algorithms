package com.va.ds.sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by apatta2 on 6/27/17.
 */
public class InsertionSort {
    private static Logger logger = LoggerFactory.getLogger(InsertionSort.class);

    public static void sort(int[] arr) {
        for(int i = 1; i < arr.length; i++) {
            int j = i - 1;
            for(; j >= 0; j--) {
                if(arr[i] > arr[j]) break;
            }
            insert(arr, i, j+1);
        }
    }

    public static void insert(int[] arr, int from, int to) {
        if(from <= to) return;
        int temp = arr[from];
        for(int i = from - 1; i >= to; i--) {
            arr[i + 1] = arr[i];
        }
        arr[to] = temp;
    }

}
