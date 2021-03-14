package com.visitamaresh.misc;

import java.util.ArrayList;
import java.util.List;

public class Primes {
    public static int[] getPrimesSieveOfEratosthenes(int max) {
        boolean[] arr = new boolean[max + 1];
        //set all to true except index 0 and 1. We will cross off the ones that are not prime
        for(int i = 2; i < arr.length; i++) {
            arr[i] = true;
        }
        int prime = 2;
        List<Integer> primeList = new ArrayList<>();
        while (prime * prime < arr.length) {
            primeList.add(prime);
            crossOffMultiples(prime, arr);
            prime = nextPrime(prime, arr);
        }
        int[] primeArr = primeList.stream().mapToInt(Integer::intValue).toArray();
        return primeArr;
    }

    private static int nextPrime(int prime, boolean[] arr) {
        int next = prime + 1;
        while (next < arr.length && !arr[next]) {
            next++;
        }
        return next;
    }

    private static void crossOffMultiples(int prime, boolean[] arr) {
        for(int i = prime * prime; i < arr.length; i += prime) {
            arr[i] = false;
        }
    }

    public static void testSieveOfEratosthenes() {
        int max = 31 * 31;
        int[] primes = getPrimesSieveOfEratosthenes(max);
        for(int i = 0; i < primes.length; i++) {
            System.out.format("%d, ", primes[i]);
        }
        System.out.println();
    }
}
