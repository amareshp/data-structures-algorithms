package com.visitamaresh.ctci.ch04;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MyMinHeap {
    private static final int FRONT = 1;
    private int size = 0;
    private int maxSize;
    private int[] heap;

    public MyMinHeap(int maxSize) {
        this.maxSize = maxSize;
        this.heap = new int[maxSize + 1];
        this.heap[0] = Integer.MIN_VALUE;
    }

    public int leftChildPos(int parentPos) {
        return (parentPos * 2);
    }

    public int rightChildPos(int parentPos) {
        return (parentPos * 2 + 1);
    }

    public int parentPos(int childPos) {
        return (childPos / 2);
    }

    public void swap(int pos1, int pos2) {
        int temp = this.heap[pos1];
        this.heap[pos1] = this.heap[pos2];
        this.heap[pos2] = temp;
    }

    public boolean isLeaf(int pos) {
        if(pos > this.size / 2 && pos <= this.size) {
            return true;
        }
        return false;
    }

    public void minHeapify(int pos) {
        if(!isLeaf(pos)) {
            if(this.heap[pos] > this.heap[leftChildPos(pos)] || this.heap[pos] > this.heap[rightChildPos(pos)]) {
                if(this.heap[leftChildPos(pos)] < this.heap[rightChildPos(pos)]) {
                    swap(pos, leftChildPos(pos));
                    minHeapify(leftChildPos(pos));
                } else {
                    swap(pos, rightChildPos(pos));
                    minHeapify(rightChildPos(pos));
                }
            }
        }
    }

    public void insert(int value) {
        if(this.size >= this.maxSize) {
            return;
        }
        this.heap[++this.size] = value;
        int current = this.size;
        while (this.heap[current] < this.heap[parentPos(current)]) {
            swap(current, parentPos(current));
            current = parentPos(current);
        }
    }

    public void print() {
        if(this.size == 1) {
            System.out.println("Parent: " + this.heap[FRONT]);
        }
        for(int i = 1; i <= this.size/2; i++) {
            System.out.println("Parent: " + this.heap[i]);
            System.out.println("  Left child: " + this.heap[i * 2]);
            if((i * 2 + 1) <= this.size) {
                System.out.println("  Right child: " + this.heap[i * 2 + 1]);
            }
        }
    }

    public int remove() {
        int popped = this.heap[FRONT];
        this.heap[FRONT] = this.heap[this.size--];
        minHeapify(FRONT);
        return popped;
    }

    private static class MyIntComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    }

    public static void testMinHeap() {
        MyMinHeap myMinHeap = new MyMinHeap(7);
        myMinHeap.insert(7);
        myMinHeap.print();
        System.out.println("++++++++++++++++ DONE ++++++++++++++++");
        myMinHeap.insert(6);
        myMinHeap.print();
        System.out.println("++++++++++++++++ DONE ++++++++++++++++");
        myMinHeap.insert(5);
        myMinHeap.print();
        System.out.println("++++++++++++++++ DONE ++++++++++++++++");
        myMinHeap.insert(4);
        myMinHeap.print();
        System.out.println("++++++++++++++++ DONE ++++++++++++++++");
        myMinHeap.insert(3);
        myMinHeap.print();
        System.out.println("++++++++++++++++ DONE ++++++++++++++++");
        myMinHeap.insert(2);
        myMinHeap.print();
        System.out.println("++++++++++++++++ DONE ++++++++++++++++");
        myMinHeap.insert(1);
        myMinHeap.print();
        System.out.println("++++++++++++++++ DONE ++++++++++++++++");
        myMinHeap.remove();
        myMinHeap.print();
        System.out.println("++++++++++++++++ DONE ++++++++++++++++");
    }

    public static void testPriorityQ() {
        MyIntComparator comparator = new MyIntComparator();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(comparator);
        priorityQueue.add(7);
        priorityQueue.forEach(i -> System.out.format("%d, ", i));
        System.out.println("++++++++++++++++ DONE ++++++++++++++++");
        priorityQueue.add(6);
        priorityQueue.forEach(i -> System.out.format("%d, ", i));
        System.out.println("++++++++++++++++ DONE ++++++++++++++++");
        priorityQueue.add(5);
        priorityQueue.forEach(i -> System.out.format("%d, ", i));
        System.out.println("++++++++++++++++ DONE ++++++++++++++++");
        priorityQueue.add(4);
        priorityQueue.forEach(i -> System.out.format("%d, ", i));
        System.out.println("++++++++++++++++ DONE ++++++++++++++++");
        priorityQueue.add(3);
        priorityQueue.forEach(i -> System.out.format("%d, ", i));
        System.out.println("++++++++++++++++ DONE ++++++++++++++++");
        priorityQueue.add(2);
        priorityQueue.forEach(i -> System.out.format("%d, ", i));
        System.out.println("++++++++++++++++ DONE ++++++++++++++++");
        priorityQueue.add(1);
        priorityQueue.forEach(i -> System.out.format("%d, ", i));
        System.out.println("++++++++++++++++ DONE ++++++++++++++++");

        System.out.format("Removed: %d%n", priorityQueue.poll());
        priorityQueue.forEach(i -> System.out.format("%d, ", i));
        System.out.println("++++++++++++++++ DONE ++++++++++++++++");
        System.out.format("Removed: %d%n", priorityQueue.poll());
        priorityQueue.forEach(i -> System.out.format("%d, ", i));
        System.out.println("++++++++++++++++ DONE ++++++++++++++++");
        System.out.format("Removed: %d%n", priorityQueue.poll());
        priorityQueue.forEach(i -> System.out.format("%d, ", i));
        System.out.println("++++++++++++++++ DONE ++++++++++++++++");
        System.out.format("Removed: %d%n", priorityQueue.poll());
        priorityQueue.forEach(i -> System.out.format("%d, ", i));
        System.out.println("++++++++++++++++ DONE ++++++++++++++++");
        System.out.format("Removed: %d%n", priorityQueue.poll());
        priorityQueue.forEach(i -> System.out.format("%d, ", i));
        System.out.println("++++++++++++++++ DONE ++++++++++++++++");

    }
}
