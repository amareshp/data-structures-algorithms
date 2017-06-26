package com.visitamaresh.misc;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by apatta2 on 10/5/16.
 */
public class AnagramsTest {
    Logger logger = LoggerFactory.getLogger(AnagramsTest.class);

    @Test
    public void test() {
        List<String> anaList = Anagrams.anagrams("abcd");

        int i = 1;
        for(String str : anaList) {
            logger.info(i + ": " + str);
            i++;
        }
    }
}
