package com.visitamaresh.ctci.ch05;

/**
 * CTCI question - 5.8
 */
public class DrawLine {
    public static void drawLine(byte[] screen, int width, int x1, int x2, int y) {
        int screenArea = screen.length * 8;
        int height = screenArea / width;
        int startByte = getBytePos(width, x1, y);
        byte startVal = setBits(x1 % 8, 7);
        screen[startByte] = startVal;

        int endByte = getBytePos(width, x2, y);
        byte endValue = setBits(0, x2 % 8);
        screen[endByte] = endValue;

        for(int i = startByte; i < endByte; i++) {
            screen[i] = (byte) 0xFF;
        }
    }

    public static int getBytePos(int width, int x, int y) {
        int pixPos = (width * y) + x;
        int bytePos = pixPos / 8;
        return bytePos;
    }

    public static void testDrawLine() {
        byte[] screen = new byte[30];
        drawLine(screen, 48, 10, 29, 3);
    }

    public static byte setBits(int from, int to) {
        int value = 0;
        for(int i = from; i <= to; i++) {
            int next = 1 << (7 - i);
            next = next & 0xFF;
            value = value | next;
            value = value & 0xFF;
        }
        return (byte) (value & 0xFF);
    }

    public static void testSetBits() {
        byte x = setBits(0, 3);
        System.out.printf("setting bits 0 to 3: signed byte: %d, unsigned int: %d%n", x, Byte.toUnsignedInt(x));
        System.out.printf("value of 0b11110000 is: %d%n", 0b11110000);
    }
}
