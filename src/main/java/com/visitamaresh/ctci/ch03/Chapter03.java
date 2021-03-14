package com.visitamaresh.ctci.ch03;

import java.util.Random;

public class Chapter03 {
    public static void testMyStack() {
        MyStack<Integer> myStack = new MyStack();
        for(int i = 0; i < 10; i++) {
            myStack.push(i);
        }
        for(int i = 0; i < 11; i++) {
            myStack.pop();
        }
    }

    public static void testMyQueue() {
        MyQueue<Integer> myQueue = new MyQueue();
        for(int i = 0; i < 10; i++) {
            myQueue.add(i);
        }
        for(int i = 0; i < 11; i++) {
            myQueue.remove();
        }
    }

    public static void sortStack() {
        MyStack<Integer> stack1 = new MyStack<>();
        Random random = new Random();
        for(int i = 0; i < 10; i++) {
            stack1.push(random.nextInt(1000));
        }
        System.out.format("stack1 before sorting: ");
        stack1.printStack();
        MyStack<Integer> stack2 = new MyStack<>();

        int sortCount = 0;

        while (true) {
            Integer smallest = Integer.MAX_VALUE;
            //move sorted data to stack2
            for(int i = 0; i < sortCount; i++) {
                Integer sortedData = stack1.pop();
                stack2.push(sortedData);
            }
            if(stack1.isEmpty()) break;
            //move unsorted data to stack2 and find smallest
            while (!stack1.isEmpty()) {
                Integer unsortedData = stack1.pop();
                if( !unsortedData.equals(smallest) ) {
                    stack2.push(unsortedData);
                    if(unsortedData.compareTo(smallest) < 0) {
                        smallest = unsortedData;
                    }
                }
            }
            //move unsorted data back from stack2 to stack1 except smallest
            //push smallest at the top
            while (!stack2.isEmpty()) {
                Integer data = stack2.pop();
                if(!data.equals(smallest)) {
                    stack1.push(data);
                }
            }
            stack1.push(smallest);
            sortCount++;
        }

        System.out.format("stack1 after sorting: ");
        stack1.printStack();
        System.out.format("stack2 after sorting: ");
        stack2.printStack();
    }
}
