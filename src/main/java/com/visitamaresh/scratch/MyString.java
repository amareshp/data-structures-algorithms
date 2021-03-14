package com.visitamaresh.scratch;

import java.util.ArrayList;
import java.util.List;

public class MyString {
    public static void permutations(List<String> result, String prefix, String input) {
        if(input.length() == 1) {
            result.add(prefix + input);
            return;
        }
        for(int i = 0; i < input.length(); i++) {
            String p1 = prefix + input.substring(i, i+1);
            String p2 = input.substring(0, i) + input.substring(i+1);
            permutations(result, p1, p2);
        }
    }

    public static boolean allUnique(String input) {
        boolean[] arr = new boolean[26];
        for(int i = 0; i < input.length(); i++) {
            int id = input.charAt(i) - 'a';
            if(arr[id]) {
                System.out.printf("found duplicate %c%n", input.charAt(i));
                return false;
            }
            arr[id] = true;
        }
        return true;
    }

    public static boolean allUniqueBits(String input) {
        long mask = 0;
        for(int i = 0; i < input.length(); i++) {
            int id = input.charAt(i) - 'a';
            long bitVal = 1 << id;
            long present = bitVal & mask;
            if(present > 0) {
                System.out.printf("found duplicate %c%n", input.charAt(i));
                return false;
            }
            mask |= bitVal;
        }
        return true;
    }

    public static String urlify(String input, int trueLen) {
        char[] arr = input.toCharArray();
        int id2 = input.length() - 1;
        for(int i = 1; i <= trueLen; i++) {
            int id1 = trueLen - i;
            if(input.charAt(id1) == ' ') {
                arr[id2--] = '0';
                arr[id2--] = '2';
                arr[id2--] = '%';
            } else {
                arr[id2--] = input.charAt(id1);
            }
        }
        return new String(arr);
    }

    public static void testAllUnique() {
        String input = "abcxyzst";
        String input2 = "abcxyzab";
        System.out.printf("input: %s, are all chars unique: %b%n", input, allUnique(input));
        System.out.printf("input: %s, test if all unique chars using bits: %b%n", input, allUniqueBits(input));
        System.out.printf("input: %s, test if all unique chars using bits: %b%n", input2, allUniqueBits(input2));
    }

    public static void testPermutations() {
        List<String> result = new ArrayList<>();
        permutations(result, "", "abc");
        result.stream().forEach(System.out::println);
    }

    public static void testUrlify() {
        String input = "Hello John How are you?        ";
        int trueLen = 23;
        System.out.printf("input: %s, true length: %d%n", input, trueLen);
        System.out.printf("urlified string: %s%n", urlify(input, trueLen));
    }

    public static void testUtf8() {
        //16 bit utf-8 characters - \u0000 to \uFFFF - 0 to 65,535 inclusive
        for(int i = 0; i <= 65535; i++) {
            if(i % 100 == 0) {
                System.out.println("\n########  printing 100 chars starting from: " + i);
            }
            System.out.printf("%c, ", i);
        }
        System.out.println();
    }
}
