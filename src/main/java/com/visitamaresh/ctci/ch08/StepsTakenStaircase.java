package com.visitamaresh.ctci.ch08;

import java.util.ArrayList;
import java.util.List;

public class StepsTakenStaircase {
    public static final int STEPS = 10;
    private static int stepsBottomUp = 0;
    private static int getStepsBottomUpMemoized = 0;

    public static void testSteps() {
        List<Integer> possibleSteps = new ArrayList<>();
        possibleSteps.add(1);
        possibleSteps.add(2);
        possibleSteps.add(3);
        List<Integer> stepList = new ArrayList<>();
        takeSteps(stepList, possibleSteps, 0);

        int totalSteps = topDown(10);
        System.out.format("Using top down: %d%n", totalSteps);

        int totalStepsBottomUp = bottomUp(0, 10);
        System.out.format("Using bottom up: %d, steps: %d%n", totalStepsBottomUp, stepsBottomUp);

        int[] arr = new int[15];
        int totalStepsBottomUpMemoized = bottomUpMemoized(0, 10, arr);
        System.out.format("Using bottom up memoized: %d, steps: %d%n", totalStepsBottomUpMemoized, getStepsBottomUpMemoized);

    }

    public static void takeSteps(List<Integer> stepList, List<Integer> possibleSteps, int stepsTaken) {
        for(Integer possibleStep : possibleSteps) {
            if(stepsTaken + possibleStep.intValue() <= STEPS) {
                stepList.add(possibleStep);
                stepsTaken += possibleStep.intValue();
                if(stepsTaken == STEPS) {
                    stepList.stream().forEach(i -> System.out.format("%d, ", i));
                    System.out.println();
                }
                takeSteps(stepList, possibleSteps, stepsTaken);
                stepList.remove(stepList.size() - 1);
                stepsTaken -= possibleStep.intValue();
            }
        }
    }

    public static int topDown(int n) {
        if(n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else {
            return topDown(n - 1) + topDown(n - 2) + topDown(n - 3);
        }
    }

    public static int bottomUp(int n, int max) {
        stepsBottomUp++;
        if(n > max) {
            return 0;
        } else if(n == max) {
            return 1;
        } else {
            return bottomUp(n + 1, max) + bottomUp(n + 2, max) + bottomUp(n + 3, max);
        }
    }

    public static int bottomUpMemoized(int n, int max, int arr[]) {
        getStepsBottomUpMemoized++;
        if(n > max) {
            return 0;
        } else if(n == max) {
            arr[n] += 1;
            return 1;
        } else {
            if(arr[n] != 0) {
                return arr[n];
            } else {
                arr[n] = bottomUpMemoized(n + 1, max, arr) + bottomUpMemoized(n + 2, max, arr) + bottomUpMemoized(n + 3, max, arr);
                return arr[n];
            }
        }
    }
}
