package com.visitamaresh.ctci.ch05;

public class BitManipulation {

    public static int[] getBits(int number) {
        int[] result = new int[32];
        if(number < 0) {
            result[0] = 1;
        }
        for(int i = 0; i <31; i++) {
            int value = number & (1 << i);
            int iValue = 0;
            if(value != 0) {
                iValue = 1;
            }
            result[31 - i] = iValue;
        }
        return result;
    }

    public static int setBit(int number, int index, boolean isOne) {
        int bitValue = 1 << index;
        int mask = ~bitValue;
        int bitUpdated = (number & mask) | bitValue;
        return bitUpdated;
    }

    public static int setBitsIToJ(int N, int M, int fromIndex, int toIndex) {
        int movedM = M << fromIndex;
        printBits(N);
        printBits(M);
        printBits(movedM);
        int mask1 = (1 << (toIndex + 1)) - 1;
        printBits(mask1);
        int mask2 = (1 << fromIndex) - 1;
        printBits(mask2);
        int mask3 = mask1 ^ mask2;
        printBits(mask3);
        int mask4 = ~mask3;
        printBits(mask4);
        int NCleared = N & mask4;
        printBits(NCleared);
        int result = NCleared | movedM;
        printBits(result);
        return result;
    }

    public static void printArr(int[] input) {
        for (int i = 0; i < input.length; i++) {
            System.out.format("%d, ", input[i]);
        }
        System.out.println();
    }

    public static void printBits(int input) {
        int[] inputArr = getBits(input);
        System.out.format("%5d = ", input);
        for (int i = 0; i < inputArr.length; i++) {
            System.out.format("%d, ", inputArr[i]);
        }
        System.out.println();
    }

    public static void testToBits() {
        int[] bits = getBits(32);
        for(int i = 0; i < bits.length; i++) {
            System.out.format("%d, ", bits[i]);
        }
        System.out.println();
        bits = getBits(-32);
        for(int i = 0; i < bits.length; i++) {
            System.out.format("%d, ", bits[i]);
        }
        System.out.println();

        int input = (int) Math.pow(2, 10);
        printBits(input);
        int updated = setBit(input, 3, true);
        printBits(updated);

        setBitsIToJ(input, 11, 3, 6);
    }
}
