package com.visitamaresh.list;

public class SinglyLinkedList {
    Node headNode;

    public void insertNode(int nodeVal) {
        Node node = new Node(nodeVal);
        if(headNode == null) {
            headNode = node;
        } else {
            headNode.insertNode(node);
        }
    }


    public void printList() {
        Node currentNode = headNode;
        while (currentNode != null) {
            System.out.println(currentNode.data);
            currentNode = currentNode.nextNode;
        }
    }

    public int printLastK(int k) {
        if(headNode == null) return -1;

        int listSize = headNode.printLastK(k) + 1;
        System.out.println("Size of the LinkedList is: " + listSize);
        return listSize;
    }


    private static class Node {
        int data;
        Node nextNode = null;

        public Node(int val) {
            this.data = val;
        }

        public void insertNode(Node node) {
            Node currentNode = this;
            while (currentNode.nextNode != null) {
                currentNode = currentNode.nextNode;
            }
            currentNode.nextNode = node;
        }

        public int printLastK(int k) {
            if(this.nextNode == null) {
                return 0;
            }
            int index = this.nextNode.printLastK(k) + 1;
            if(index == k) {
                System.out.println("node value of " + k + " element from the end is: " + this.data);
            }
            return index;
        }
    }
}
