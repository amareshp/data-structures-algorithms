package com.visitamaresh.ctci.ch03;

import java.util.NoSuchElementException;

public class MyQueue<T> {
    private static class MyQueueNode<T> {
        T data;
        MyQueueNode<T> next;

        MyQueueNode(T t) {
            this.data = t;
        }
    }

    MyQueueNode<T> last;
    MyQueueNode<T> first;

    public void add(T t) {
        MyQueueNode<T> node = new MyQueueNode<>(t);
        if(this.last != null) {
            this.last.next = node;
        }
        this.last = node;
        if(this.first == null) {
            this.first = this.last;
        }
        System.out.format("added to queue: %s%n", t);
    }

    public T remove() {
        if(this.first == null) throw new NoSuchElementException();
        MyQueueNode<T> olfFirst = this.first;
        this.first = this.first.next;
        if(this.first == null) {
            this.last = null;
        }
        System.out.format("removed from queue: %s%n", olfFirst.data);
        return olfFirst.data;
    }

    public T peek() {
        if(this.first == null) throw new NoSuchElementException();
        return this.first.data;
    }

    public boolean isEmpty() {
        return this.first == null;
    }
}
