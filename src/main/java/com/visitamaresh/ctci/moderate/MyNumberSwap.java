package com.visitamaresh.ctci.moderate;

public class MyNumberSwap {
    public static void swap(int a, int b) {
        int origA = a, origB = b;
        System.out.format("Before int swap: %d, %d%n", origA, origB);
        a = a - b;
        b = a + b;
        a = b - a;
        System.out.format("After int swap: %d, %d%n%n", a, b);

        System.out.format("Before swap: %d, %d%n", origA, origB);
        a = origA;
        b = origB;
        
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.format("After bitwise swap: %d, %d%n%n", a, b);
    }

    public static void testSwap() {
        swap(7, 17);
    }
}
