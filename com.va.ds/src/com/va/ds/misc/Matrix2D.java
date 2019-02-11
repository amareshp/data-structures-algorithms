package com.va.ds.misc;

public class Matrix2D {

    private String[][] matrix;

    public Matrix2D(String[][] matrix) {
        this.matrix = matrix;
    }

    public void rotateMatrix() {
        for(int i = 0; i < matrix.length / 2; i++) {
            int first = i;
            int last = matrix.length - 1 - i;
            for(int j = first; j < last; j++) {
                int offset = j - first;
                String temp = matrix[first][j];
                matrix[first][j] = matrix[last-offset][first];
                matrix[last-offset][first] = matrix[last][last-offset];
                matrix[last][last-offset] = matrix[offset][last];
                matrix[j][last] = temp;

            }
        }
    }

    public void printMatrix() {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public String[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(String[][] matrix) {
        this.matrix = matrix;
    }
}
