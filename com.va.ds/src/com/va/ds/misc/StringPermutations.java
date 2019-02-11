package com.va.ds.misc;

public class StringPermutations {
    private int permutationCount = 1, permStepCount = 1;

    public void printPermutations(String input) {
        permutations("", input);
    }

    public void permutations(String prefix, String input) {
        if(input.length() == 0) {
            System.out.println("Permutation count: " + permutationCount);
            permutationCount++;
            System.out.println(prefix);
            return;
        }

        for(int i = 0; i < input.length(); i++) {
            String newInput = input.substring(0, i) + input.substring(i+1);
            System.out.println("prefix: " + input.charAt(i) + " input: " + newInput + " Permutation step count: " + permStepCount);
            permStepCount++;
            permutations(prefix + input.charAt(i), newInput);
        }
    }
}
