package com.visitamaresh.ds;

import java.util.EmptyStackException;

public class MyStack<T> {
    public class MyStackNode<T> {
        public T data;
        public MyStackNode<T> next;

        public MyStackNode(T value) {
            this.data = value;
        }
    }

    MyStackNode<T> top;

    public void push(T ele) {
        MyStackNode<T> node = new MyStackNode<>(ele);
        node.next = top;
        top = node;
    }

    public T pop() throws EmptyStackException {
        if(top == null) throw new EmptyStackException();
        MyStackNode<T> oldTop = top;
        top = top.next;
        return oldTop.data;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        MyStackNode<T> node = top;
        while (node != null) {
            sb.append(node.data);
            sb.append(", ");
            node = node.next;
        }
        return sb.toString();
    }

}
