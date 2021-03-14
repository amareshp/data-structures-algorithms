package com.visitamaresh.misc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Temp {
    private static class Node {
        public int data;
        public Node next;
    }
    private static Node result = null;

    public static int add(Node l1, Node l2) {
        if(l1 == null && l2 == null) {
            return 0;
        }
        int carry = add(l1.next, l2.next);
        int sum = (l1.data + l2.data + carry) % 10;
        carry = (l1.data + l2.data + carry) / 10;

        //add sum to the left in result
        Node last = new Node();
        last.data = sum;
        last.next = result;
        result = last;
        return carry;
    }

    public static void print(Node n) {
        while (n != null) {
            System.out.format(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }

    public static Node createNode() {
        Random random = new Random();
        Node node = new Node();
        node.data = 8;
        Node currentNode = node;
        for(int i = 0; i < 5; i++) {
            int val = random.nextInt(10);
            Node nextNode = new Node();
            nextNode.data = val;
            currentNode.next = nextNode;
            currentNode = nextNode;
        }
        return node;
    }

    public static void main(String args[]) {
        Node node1 = createNode();
        print(node1);
        Node node2 = createNode();
        print(node2);
        int carry = add(node1, node2);
        if(carry > 0) {
            Node first = new Node();
            first.data = carry;
            first.next = result;
            result = first;
        }
        print(result);
    }

    // a b c d e e d c b a
    // a, a -> b, c -> c, e -> d, c -> e, a
    // a, a -> b, c -> c, e -> d, d -> e, b -> e, a
}
