package com.visitamaresh.sort;

/**
 * Created by apatta2 on 6/27/17.
 */
public class SelectionSort {
    public static void sort(int[] arr) {
        for(int i = 0; i < (arr.length - 1); i++) {
            int smallestIndex = i;
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[j] < arr[smallestIndex]) {
                    smallestIndex = j;
                }
            }
            //move smallest to beginning
            int temp = arr[i];
            arr[i] = arr[smallestIndex];
            arr[smallestIndex] = temp;
        }
    }
}
