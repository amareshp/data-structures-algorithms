package com.visitamaresh.sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * Created by apatta2 on 7/27/16.
 */
public class MergeSort {
    private static final Logger logger = LoggerFactory.getLogger( new Exception().getStackTrace()[0].getClassName() );

    public void mergeSort(int[] array, int start, int end) {
        if(start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(array, start, mid);
        mergeSort(array, mid+1, end);
        merge(array, start, end, mid);
    }

    public void merge(int[] array, int start, int end, int mid) {
        if( (end - start) == 1) {
            return;
        }
        //get mid and create two temp arrays
        int leftLen = mid - start + 1;
        int rightLen = end - mid;
        int[] leftArray = new int[leftLen];
        int[] rightArray = new int[rightLen];

        //copy values to left and right array
        for(int i = 0; i < leftLen; i++) {
            leftArray[i] = array[start + i];
        }
        for(int i = 0; i < rightLen; i++) {
            rightArray[i] = array[mid + 1 + i];
        }

        //merge
        int i = 0, j = 0;
        for(int k = start; k <= end; k++) {
            //if right array has been fully processed OR left array has not been processed
            if(  (j == rightLen) || ( (i < leftLen) && (leftArray[i] <= rightArray[j]) ) ) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
        }
        int[] sortedArray = Arrays.copyOfRange(array, start, end);
        logger.debug(Arrays.toString(sortedArray));

    }
}
