package com.visitamaresh.ctci.ch08;

public class MultiplyWithoutMultiplication {

    public static int multiply(int smaller, int bigger) {
        if(smaller == 0) {
            return 0;
        } else if(smaller == 1) {
            return bigger;
        } else {
            int half = smaller >> 1;
            int result = multiply(half, bigger);
            result = result << 1;
            if(smaller % 2 == 0) {
                return result;
            } else {
                return result + bigger;
            }
        }
    }

    public static void testMultiply() {
        int a = 7;
        int b = 17;
        int result = multiply(a, b);
        System.out.format("Result of %d * %d = %d%n", a, b, result);
    }
}
