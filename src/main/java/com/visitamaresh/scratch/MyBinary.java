package com.visitamaresh.scratch;

import java.util.Arrays;

public class MyBinary {
    public static int[] decimalToBinary(int num) {
        int index = getIndex(num);
        int width = index + 1;
        int[] result = new int[width];
        result[width - 1 - index] = 1;
        num = num - (int) Math.pow(2, index);
        while (num > 0) {
            index = getIndex(num);
            result[width - 1 - index] = 1;
            num -= (int) Math.pow(2, index);
        }
        return result;
    }

    public static int getIndex(int num) {
        int base = 2;
        int index = 0;
        while (num >= base) {
            index++;
            base *= 2;
        }
        return index;
    }

    public static void testDecimalToBinary() {
        int x = 0b11100100110;
        int id = Integer.highestOneBit(15);
        String binStr1 = Integer.toBinaryString(x);
        System.out.printf("value of %s is: %d%n", binStr1, x);
        int num = 255;
        int[] binArr = decimalToBinary(num);
        System.out.printf("bin array: %s.%n", binArr);
        String binStr = Arrays.stream(binArr).mapToObj(String::valueOf).reduce("", (p, n) -> p + n + ", ");
        System.out.printf("binary of %d = %s%n", num, binStr);
    }
}
