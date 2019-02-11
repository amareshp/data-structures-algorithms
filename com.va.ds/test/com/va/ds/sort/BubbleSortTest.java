package com.va.ds.sort;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * Created by apatta2 on 10/5/16.
 */
public class BubbleSortTest {
    private static final Logger logger = LoggerFactory.getLogger( new Exception().getStackTrace()[0].getClassName() );

    @Test
    public void test() {
        int[] arr = new int[] {7, 2, 5, 1, 3, 6, 4};
        BubbleSort.sort(arr);
        logger.info(Arrays.toString(arr));

        int[] arr2 = new int[] {7, 2, 5, 1, 3, 6, 4};
        BubbleSort.sort2(arr2);
        logger.info(Arrays.toString(arr2));

    }
}
