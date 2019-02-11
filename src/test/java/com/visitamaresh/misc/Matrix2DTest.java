package com.visitamaresh.misc;

import org.junit.Test;

public class Matrix2DTest {

    @Test
    public void rotateTest() {
        String matrix[][] = new String[][] {{"00", "01", "02", "03"}, {"10", "11", "12", "13"}, {"20", "21", "22", "23"}, {"30", "31", "32", "33"}};
        Matrix2D matrix2D = new Matrix2D(matrix);
        matrix2D.printMatrix();
        matrix2D.rotateMatrix();
        System.out.println("\nRotating the matrix...\n");
        matrix2D.printMatrix();

    }
}
