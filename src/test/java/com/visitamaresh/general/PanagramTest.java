package com.visitamaresh.general;

import java.util.*;
import org.junit.jupiter.api.Test;

/**
 * Created by apatta2 on 3/30/17.
 *
 * A panagram is a String that contains all the letters from a set of letters.
 * e.g. a quick hungry brown fox jumped over the lazy dog is a Panagram of the 26 English alphabets.
 *
 * Write a program to print the smallest panagram which is a substring of a given input String.
 *
 */
public class PanagramTest {

    @Test
    public void testPanagram() {
        String inputStr = "aaaaabbdddcccaaaacdbzzzzzz";
        Set<String> alphaSet = new HashSet<String>();
        alphaSet.addAll(Arrays.asList("a", "b", "c", "d"));
        Map<String, Integer> alphaCount = new HashMap<String, Integer>();
        int i=0, j=0;
        int start = -1;
        int end = -1;

        while (j < inputStr.length()) {
            String current = inputStr.substring(j, j+1);
            Integer count = alphaCount.get(current);
            if(alphaSet.contains(current)) {
                if(count == null || count == 0) {
                    alphaCount.put(current, 1);
                } else {
                    alphaCount.put(current, count.intValue()+1);
                }

                while (alphaCount.size() == 4 && i < j) {
                    if(start == -1 || (j-i) < (end-start) ) {
                        start = i;
                        end = j;
                    }
                    String left = inputStr.substring(i, i+1);
                    count = alphaCount.get(left);

                    if(count == 1) {
                        alphaCount.remove(left);
                    } else {
                        alphaCount.put(left, count.intValue() - 1);
                    }
                    i++;
                }

            }

            j++;
        }
        System.out.println("Shortest Panagram is: " + inputStr.substring(start, (end+1)));

    }

}
