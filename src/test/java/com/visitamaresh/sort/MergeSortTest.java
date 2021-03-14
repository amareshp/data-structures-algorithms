package com.visitamaresh.sort;

import com.visitamaresh.sort.MergeSort;
import org.junit.jupiter.api.Test;

/**
 * Created by apatta2 on 7/27/16.
 */
public class MergeSortTest {

    @Test
    public void test1() {
        int[] array = {12, 7, 3, 1, 9, 3, 5, 8, 2, 4, 6};
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(array, 0, array.length-1);
    }

}
