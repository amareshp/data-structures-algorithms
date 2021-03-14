package com.visitamaresh.ctci.ch08;

public class RobotMoveOneStep {

    public static boolean findPath(int startRow, int startCol, int endRow, int endCol, boolean[][] forbidden, int totalRows, int totalCols) {
        if(forbidden[startRow][startCol]) {
            return false;
        } else if(startRow > totalRows - 1 || startCol > totalCols - 1) {
            return false;
        } else {
            System.out.format("[%d, %d], ", startRow, startCol);
            if(startRow == endRow && startCol == endCol) {
                System.out.println("DONE.");
                return true;
            } else {
                return findPath(startRow + 1, startCol, endRow, endCol, forbidden, totalRows, totalCols) ||
                        findPath(startRow, startCol + 1, endRow, endCol, forbidden, totalRows, totalCols);
            }
        }
    }

    public static void testRobotPath() {
        int totalRows = 3;
        int totalCols = 3;
        boolean [][] forbidden = new boolean[totalRows + 1][totalCols + 1];
        forbidden[1][0] = true;
        forbidden[0][2] = true;
        findPath(0, 0, totalRows - 1, totalCols - 1, forbidden, totalRows, totalCols);
    }
}
