package com.DSA.TUF.LinkedList.DataNode;

public class DoublyLinkedListNode {

    public int data;
    public DoublyLinkedListNode next;
    public DoublyLinkedListNode previous;

    public DoublyLinkedListNode() {

        this.data = 0;
        this.next = null;
        this.previous = null;
    }

    public DoublyLinkedListNode(int data) {

        this.data = data;
        this.next = null;
        this.previous = null;
    }

    public DoublyLinkedListNode(int data, DoublyLinkedListNode next, DoublyLinkedListNode previous) {

        this.data = data;
        this.next = next;
        this.previous = previous;
    }
}
