package com.visitamaresh.ctci.ch05;

import java.util.Random;

public class BitwiseAdd {

    public static int add(int num1, int num2) {
        int withoutCarry = num1 ^ num2;
        int carry = (num1 & num2) << 1;
        if(carry == 0) {
            return withoutCarry;
        } else {
            return add(withoutCarry, carry);
        }
    }

    private static void printResult(int a, int b, int result, int expected) {
        if(result == expected) {
            System.out.format("PASS: %3d + %3d = %4d%n", a, b, result);
        } else {
            System.out.format("FAIL: %3d + %3d = %4d, expected: %4d%n", a, b, result, expected);
        }
    }

    public static void testAdd() {
        Random random = new Random();
        for(int i = 0; i < 10; i++) {
            int a = random.nextInt(1000);
            int b = random.nextInt(1000);
            int result = add(a, b);
            int expected = a + b;
            printResult(a, b, result, expected);
        }
    }
}
