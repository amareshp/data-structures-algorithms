package com.visitamaresh.scratch;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MyMath {
    public static int factorial(Map<Integer, Integer> facts, int n) {
        System.out.printf("calculating factorial of %d%n", n);
        if(n == 0 || n == 1) {
            return 1;
        }
        if(facts.containsKey(n)) {
            return facts.get(n);
        }

        int r = factorial(facts,n - 1) * n;
        facts.put(n, r);
        return r;
    }

    public static int factorial(int n) {
        Map<Integer, Integer> facts = new HashMap<>();
        return factorial(facts, n);
    }

    public static void testFactorial() {
        int input = 5;
        System.out.printf("factorial of %d is: %d%n", input, factorial(input));
    }

    public static void testEmptyIntArr() {
        int[] arr = new int[20];
        //Arrays.fill(arr, 0);
        Arrays.stream(arr).forEach(System.out::println);
    }

    public static void testIntLimits() {
        int bits = 32;
        int maxPositive = 1;
        for(int i = 0; i < (bits - 2); i++) {
            maxPositive = (maxPositive << 1) + 1;
        }
        int maxNegative = 1 << (bits -1);
        assert maxPositive == Integer.MAX_VALUE : String.format("expected: %d, got: %d", Integer.MAX_VALUE, maxPositive);
        assert maxNegative == Integer.MIN_VALUE : String.format("expected: %d, got: %d", Integer.MIN_VALUE, maxNegative);
    }

    public static void testLongLimits() {
        long bits = 64;
        long maxPositive = 1;
        for(int i = 0; i < (bits - 2); i++) {
            maxPositive = (maxPositive << 1) + 1;
        }
        long one = 1L;
        long maxNegative = one << (bits -1);
        assert maxPositive == Long.MAX_VALUE : String.format("expected: %d, got: %d", Long.MAX_VALUE, maxPositive);
        assert maxNegative == Long.MIN_VALUE : String.format("expected: %d, got: %d", Long.MIN_VALUE, maxNegative);
    }

    public static void testShift() {
        int x = -1, y = x;
        for(int i = 1; i <= 5; i++) {
            y = y << 1;
            System.out.printf("%d after %2d left shift: %3d [%s]%n", x, i, y, Integer.toBinaryString(y));
        }
    }

}
