package com.visitamaresh.list;

import org.junit.jupiter.api.Test;

public class SinglyLinkedListTest {

    @Test
    public void printKTest() {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        for(int i = 1; i < 11; i++) {
            linkedList.insertNode(i);
        }
        linkedList.printList();
        int listSize = linkedList.printLastK(4);
    }
}
