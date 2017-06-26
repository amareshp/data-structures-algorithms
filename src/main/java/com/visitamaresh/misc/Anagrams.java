package com.visitamaresh.misc;

import java.util.*;

/**
 * Created by apatta2 on 10/5/16.
 */
public class Anagrams {
    public static List<String> anagramsList = new ArrayList<String>();

    public static List<String> anagrams(String str) {
        return anagrams("", str);
    }

    private static List<String> anagrams(String prefix, String str) {
        int n = str.length();
        if (n == 0) {
            anagramsList.add(prefix);
        }
        else {
            for (int i = 0; i < n; i++)
                anagrams(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
        }
        return anagramsList;
    }
}
