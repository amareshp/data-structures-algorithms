package com.visitamaresh.ctci.ch01;

public class Chapter01 {

    public static void checkUnique(String input) {
        boolean[] arr = new boolean[62];
        for(char ch : input.toCharArray()) {
            if(arr[ch%62] == true) {
                System.out.format("%s is not unique.%n", input);
                return;
            } else {
                arr[ch%62] = true;
            }
        }
        System.out.format("%s is unique.%n", input);
    }

    public static void isPermuatation(String str1, String str2) {
        if(str1 == null || str2 == null) {
            System.out.println("Bad data");
            return;
        } else if(str1.length() != str2.length()) {
            System.out.format("%s and %s are not permutations of each other.%n", str1, str2);
            return;
        }
        int[] arr = new int[62];
        for(char ch : str1.toCharArray()) {
            arr[ch%62] += 1;
        }
        for(char ch : str2.toCharArray()) {
            if(arr[ch%62] < 1) {
                System.out.format("%s and %s are not permutations of each other.%n", str1, str2);
                return;
            }
            arr[ch%62] -= 1;
        }
        for(char ch : str1.toCharArray()) {
            if(arr[ch%62] != 0) {
                System.out.format("%s and %s are not permutations of each other.%n", str1, str2);
                return;
            }
        }

        System.out.format("%s and %s are permutations of each other.%n", str1, str2);
    }

    public static void urlify(String input, int true_len) {
        char[] inputArr = input.toCharArray();
        int resultIndex = input.length() - 1;
        for(int i = (true_len-1); i >=0; i--) {
            if(inputArr[i] == ' ') {
                inputArr[resultIndex--] = '0';
                inputArr[resultIndex--] = '2';
                inputArr[resultIndex--] = '%';
            } else {
                inputArr[resultIndex--] = inputArr[i];
            }
        }
        System.out.format("Input: %s, urlified: %s%n", input, String.valueOf(inputArr));
    }

    public static void oneEditAway(String str1, String str2) {
        if(Math.abs(str1.length() - str2.length()) > 1) {
            System.out.format("%s and %s are not one edit away.%n", str1, str2);
            return;
        }
        String smaller = str1.length() <= str2.length() ? str1 : str2;
        String bigger = str1.length() > str2.length() ? str1 : str2;
        boolean oneEdit = false;

        for(int i=0,j=0; i<smaller.length(); i++,j++) {
            if(smaller.charAt(i) != bigger.charAt(j)) {
                if(oneEdit) {
                    System.out.format("%s and %s are not one edit away.%n", str1, str2);
                    return;
                } else if(smaller.length() != bigger.length()) {
                    j++;
                    if(smaller.charAt(i) != bigger.charAt(j)) {
                        System.out.format("%s and %s are not one edit away.%n", str1, str2);
                        return;
                    }
                }
                oneEdit = true;
            }
        }
        System.out.format("%s and %s are one edit away.%n", str1, str2);
    }

    public static String compress(String str) {
        StringBuilder sb = new StringBuilder();
        char current = str.charAt(0);
        int count = 0;
        for(int i = 0; i < str.length(); i++) {
            if(current == str.charAt(i)) {
                count++;
            } else {
                sb.append(current);
                sb.append(count);
                current = str.charAt(i);
                count = 1;
            }
        }
        sb.append(current);
        sb.append(count);
        String compressed = sb.toString();
        if(compressed.length() < str.length()) {
            System.out.format("Compressed string: %s%n", compressed);
            return compressed;
        } else {
            System.out.format("Compressed string: %s%n", str);
            return str;
        }
    }
}
