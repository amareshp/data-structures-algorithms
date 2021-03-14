package com.visitamaresh.ctci.ch02;

import java.util.LinkedList;

public class Chapter02 {

    public static class Node {
        Node next = null;
        int data;

        public Node(int d) {
            this.data = d;
        }

        void appendToEnd(int d) {
            Node newNode = new Node(d);
            Node n = this;
            while (n.next != null) {
                n = n.next;
            }
            n.next = newNode;
        }

        Node deleteNode(int d) {
            //will be called from head node only
            if(this.data == d) {
                return this.next;
            }
            Node n = this;
            while (n.next != null) {
                if(n.next.data == d) {
                    n.next = n.next.next;
                    return this;
                }
                n = n.next;
            }
            return this;
        }

        void printLinkedList() {
            Node n = this;
            while (n != null) {
                System.out.format("%d, ", n.data);
                n = n.next;
            }
            System.out.println();
        }
    }

    public static void kthToLast() {
        Node head = new Node(1);
        for(int i = 2; i <= 10; i++) {
            head.appendToEnd(i);
        }
        head.printLinkedList();
        Chapter02.kthToLastRecursive(head, 3);
        System.out.println();
    }

    public static int kthToLastRecursive(Node head, int k) {
        if(head == null) {
            return 0;
        }
        int index = kthToLastRecursive(head.next, k) + 1;
        if(index == k) {
            System.out.format("%d: %d, ", index, head.data);
        }
        return index;
    }
}
