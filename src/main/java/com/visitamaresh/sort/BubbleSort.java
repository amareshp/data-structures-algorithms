package com.visitamaresh.sort;

/**
 * Created by apatta2 on 10/5/16.
 */
public class BubbleSort {

    public static void sort(int[] arr) {
        for(int i = (arr.length - 1); i >=0; i--) {
            for(int j = 0; j < i; j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
