package com.visitamaresh.ctci.ch01;

import java.util.ArrayList;
import java.util.List;

public class Chapter01_1 {
    public static boolean checkUniqueBitVector(String input) {
        long mask = 0;
        for(int i = 0; i < input.length(); i++) {
            char charVal = input.charAt(i);
            int offset = input.charAt(i) - 'a';
            int checker = (1 << offset);
            long checked = checker & mask;
            if(checked > 0) {
                System.out.printf("%s is does not have unique chars%n", input);
                return false;
            }
            mask |= checker;
        }
        System.out.printf("%s has all unique chars%n", input);
        return true;
    }

    public static boolean checkUniqueArray(String input) {
        for(int i = 0; i < 256; i++) {
            char x = (char) i;
            System.out.printf("%3d: %c%n", i, x);
        }
        if(input.length() > 256) return false;

        boolean[] charsPresent = new boolean[256];
        for(int i = 0; i < input.length(); i++) {
            int offset = input.charAt(i);
            if(charsPresent[offset]) return false;
            charsPresent[offset] = true;
        }
        return true;
    }

    public static List<String> allPermutations(String input) {
        List<String> result = new ArrayList<>();
        if(input.length() == 1) {
            result.add(input);
            return result;
        }

        for(int i = 0; i < input.length(); i++) {
            String left = input.substring(0, i);
            String right = input.substring(i+1);
            String input2 = left + right;
            List<String> subPermutations = allPermutations(input2);
            for(String result1 : subPermutations) {
                String result2 = input.charAt(i) + result1;
                result.add(result2);
            }
        }

        return result;
    }

}
