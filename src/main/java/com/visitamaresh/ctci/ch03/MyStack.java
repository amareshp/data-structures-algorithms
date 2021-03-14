package com.visitamaresh.ctci.ch03;

import java.util.EmptyStackException;

public class MyStack<T> {
    private static class StackNode<T> {
        T data;
        StackNode<T> next;

        StackNode(T data) {
            this.data = data;
        }
    }

    StackNode<T> top;

    public void push(T t) {
        StackNode<T> node = new StackNode<>(t);
        node.next = this.top;
        this.top = node;
        //System.out.format("pushed: %s%n", t);
    }

    public T pop(){
        if(this.top == null) {
            throw new EmptyStackException();
        }
        T oldTop = this.top.data;
        this.top = this.top.next;
        //System.out.format("popped: %s%n", oldTop);
        return oldTop;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void printStack() {
        MyStack<T> temp = new MyStack<>();
        while (!this.isEmpty()) {
            T data = this.pop();
            System.out.format("%s, ", data);
            temp.push(data);
        }
        System.out.println();
        while (!temp.isEmpty()) {
            T data = temp.pop();
            this.push(data);
        }
    }
}
