package com.va.ds.misc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StringPermutations {
    private static final Logger logger = LoggerFactory.getLogger( new Exception().getStackTrace()[0].getClassName() + "123456789");

    private int permutationCount = 1, permStepCount = 1;

    public void printPermutations(String input) {
        permutations("", input);
    }

    public void permutations(String prefix, String input) {
        if(input.length() == 0) {
            //System.out.println("Permutation count: " + permutationCount);
            logger.info("Permutation count: " + permutationCount);

            permutationCount++;
            System.out.println(prefix);
            return;
        }

        for(int i = 0; i < input.length(); i++) {
            String newInput = input.substring(0, i) + input.substring(i+1);
            logger.info("prefix: " + input.charAt(i) + " input: " + newInput + " Permutation step count: " + permStepCount);
            //System.out.println("prefix: " + input.charAt(i) + " input: " + newInput + " Permutation step count: " + permStepCount);
            permStepCount++;
            permutations(prefix + input.charAt(i), newInput);
        }
    }
}
