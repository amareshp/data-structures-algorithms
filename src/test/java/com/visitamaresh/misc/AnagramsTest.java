package com.visitamaresh.misc;

import org.junit.Test;

import java.util.List;

/**
 * Created by apatta2 on 10/5/16.
 */
public class AnagramsTest {

    @Test
    public void test() {
        List<String> anaList = Anagrams.anagrams("abcd");

        int i = 1;
        for(String str : anaList) {
            System.out.println(i + ": " + str);
            i++;
        }
    }
}
