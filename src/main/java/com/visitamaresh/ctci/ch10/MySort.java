package com.visitamaresh.ctci.ch10;

import java.util.Random;

public class MySort {
    private static int bubbleSortSteps = 0;
    private static int selectionSortSteps = 0;
    private static int mergeSortSteps = 0;
    private static int quickSortSteps = 0;

    public static void quickSort(int[] arr, int start, int end) {
        quickSortSteps++;
        if(start < end) {
            int pivotIndex = partition(arr, start, end);
            quickSort(arr, start, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, end);
        }
    }

    public static int partition(int[] arr, int start, int end) {
        quickSortSteps++;
        int pivot = arr[end];
        int i = start;
        for(int j = start; j < end; j++) {
            if(arr[j] < pivot) {
                swapIndex(arr, i, j);
                i++;
            }
        }
        swapIndex(arr, i, end);
        return i;
    }

    public static void mergeSort(int[] arr, int start, int end) {
        mergeSortSteps++;
        if(start == end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }

    public static int[] merge(int[] sortedArr, int start, int mid, int end) {
        mergeSortSteps++;
        int[] mergedArr = new int[sortedArr.length];
        int i = start, j = mid + 1;
        for(int k = start; k <= end; k++) {
            if(i > mid) {
                while (j <= end) {
                    mergedArr[k++] = sortedArr[j++];
                }
                break;
            }
            if(j > end) {
                while (i <= mid) {
                    mergedArr[k++] = sortedArr[i++];
                }
                break;
            }
            if(sortedArr[i] <= sortedArr[j]) {
                mergedArr[k++] = sortedArr[i++];
            } else {
                mergedArr[k++] = sortedArr[j++];
            }
        }

        return mergedArr;
    }

    public static void bubbleSort(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++) {
            for(int j = 0; j < arr.length - i - 1; j++) {
                bubbleSortSteps++;
                if(arr[j] > arr[j + 1]) {
                    swapIndex(arr, j, j + 1);
                }
            }
        }
    }

    public static void selectionSort(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            int smallest = i;
            for(int j = i; j < arr.length; j++) {
                selectionSortSteps++;
                if(arr[j] < arr[smallest]) {
                    smallest = j;
                }
            }
            swapIndex(arr, i, smallest);
        }
    }

    private static void swapIndex(int[] input, int index1, int index2) {
        int temp = input[index1];
        input[index1] = input[index2];
        input[index2] = temp;
    }

    private static void printArr(int[] arr) {
        for(int element : arr) {
            System.out.format("%d, ", element);
        }
        System.out.println();
    }

    public static void testSort() {
        Random random = new Random();
        int inputArr[] = new int[16];
        for(int i = 0; i < inputArr.length; i++) {
            int num = random.nextInt(1000);
            inputArr[i] = num;
        }
        System.out.println("\nUnsorted Array: ");
        printArr(inputArr);
        bubbleSort(inputArr);
        System.out.format("Bubble Sorted Array. Total Steps: %d%n", bubbleSortSteps);
        printArr(inputArr);

        inputArr = new int[16];
        for(int i = 0; i < inputArr.length; i++) {
            int num = random.nextInt(1000);
            inputArr[i] = num;
        }
        System.out.println("\nUnsorted Array: ");
        printArr(inputArr);
        selectionSort(inputArr);
        System.out.format("Slection Sorted Array. Total Steps: %d%n", selectionSortSteps);
        printArr(inputArr);

        inputArr = new int[16];
        for(int i = 0; i < inputArr.length; i++) {
            int num = random.nextInt(1000);
            inputArr[i] = num;
        }
        System.out.println("\nUnsorted Array: ");
        printArr(inputArr);
        mergeSort(inputArr, 0, inputArr.length - 1);
        System.out.format("Merge Sorted Array. Total Steps: %d%n", mergeSortSteps);
        printArr(inputArr);

        inputArr = new int[16];
        for(int i = 0; i < inputArr.length; i++) {
            int num = random.nextInt(1000);
            inputArr[i] = num;
        }
        System.out.println("\nUnsorted Array: ");
        printArr(inputArr);
        quickSort(inputArr, 0, inputArr.length - 1);
        System.out.format("Quick Sorted Array. Total Steps: %d%n", quickSortSteps);
        printArr(inputArr);

    }
}
