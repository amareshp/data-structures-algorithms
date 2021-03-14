package com.visitamaresh.sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * Created by apatta2 on 6/27/17.
 */
public class InsertionSortTest {
    private static Logger logger = LoggerFactory.getLogger(InsertionSortTest.class);

    public void test1() {
        int[] arr = new int[] {7, 2, 5, 1, 3, 6, 4};
        InsertionSort.sort(arr);
        logger.info(Arrays.toString(arr));
    }

}
