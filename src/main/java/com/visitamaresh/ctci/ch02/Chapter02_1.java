package com.visitamaresh.ctci.ch02;

import java.util.HashSet;
import java.util.Set;

public class Chapter02_1 {
    public static class MyLinkedListNode<T> {
        T value;
        public MyLinkedListNode<T> next = null;

        public MyLinkedListNode(T value) {
            this.value = value;
        }

        public void addElement(T eleVal) {
            MyLinkedListNode current = this;
            while (current.next != null) {
                current = current.next;
            }
            MyLinkedListNode<T> last = new MyLinkedListNode<>(eleVal);
            current.next = last;
        }

        public MyLinkedListNode<T> deleteNode(T nodeVal) {
            if(this.value.equals(nodeVal)) {
                return this.next;
            }
            MyLinkedListNode<T> current = this;
            while (current.next != null) {
                if(current.next.value.equals(nodeVal)) {
                    current.next = current.next.next;
                    return this;
                }
                current = current.next;
            }
            return this;
        }

        public void traverseSlowFast() {
            if(this.next == null) {
                return;
            }
            MyLinkedListNode<T> slowNode = this;
            MyLinkedListNode<T> fastNode = this.next;
            int slowCount = 1;
            int fastCount = 2;
            while (fastNode.next != null) {
                fastNode = fastNode.next;
                System.out.printf("fast node is at: %s%n", fastNode.value);
                fastCount++;
                if(fastNode.next != null) {
                    fastNode = fastNode.next;
                    System.out.printf("fast node is at: %s%n", fastNode.value);
                    fastCount++;
                    slowNode = slowNode.next;
                    System.out.printf("slow node is at: %s%n", slowNode.value);
                    slowCount++;
                }
            }
            System.out.printf("After traversal slow node at: %s, fast node at: %s%n", slowNode.value, fastNode.value);
        }

        public MyLinkedListNode<T> oddEven() {
            if(this.next == null) {
                return this;
            }
            MyLinkedListNode<T> slowNode = this;
            MyLinkedListNode<T> fastNode = this.next;
            while (fastNode.next != null) {
                fastNode = fastNode.next;
                if(fastNode.next != null) {
                    fastNode = fastNode.next;
                    slowNode = slowNode.next;
                }
            }
            //slowNode is in the middle now. Now string them together
            MyLinkedListNode<T> result = new MyLinkedListNode<>(this.value);
            MyLinkedListNode<T> node1 = this.next;
            slowNode = slowNode.next;
            result.addElement(slowNode.value);
            slowNode = slowNode.next;
            while (slowNode != null) {
                result.addElement(node1.value);
                node1 = node1.next;
                result.addElement(slowNode.value);
                slowNode = slowNode.next;
            }
            return result;
        }

        public void removeDups() {
            Set<T> eleSet = new HashSet<>();
            MyLinkedListNode<T> current = this;
            eleSet.add(current.value);
            while (current != null && current.next != null) {
                if(eleSet.contains(current.next.value)) {
                    current.next = current.next.next;
                } else {
                    eleSet.add(current.next.value);
                    current = current.next;
                }
            }
        }


        public String toString() {
            StringBuilder builder = new StringBuilder();
            MyLinkedListNode current = this;
            builder.append(current.value.toString() + ", ");
            while (current.next != null) {
                current = current.next;
                builder.append(current.value.toString() + ", ");
            }
            return builder.toString();
        }
    }
}
