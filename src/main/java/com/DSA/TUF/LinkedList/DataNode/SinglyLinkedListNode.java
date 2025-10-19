package com.DSA.TUF.LinkedList.DataNode;

public class SinglyLinkedListNode {

    public int data;
    public SinglyLinkedListNode next;
    public SinglyLinkedListNode child;

    public SinglyLinkedListNode() {
        data = 0;
        next = null;
    }

    public SinglyLinkedListNode(int data) {

        this.data = data;
        next = null;
    }

    public SinglyLinkedListNode(int data, SinglyLinkedListNode next) {

        this.data = data;
        this.next = next;
    }

    public SinglyLinkedListNode(int data, SinglyLinkedListNode next, SinglyLinkedListNode child) {

        this.data = data;
        this.next = next;
        this.child = child;
    }

    public static SinglyLinkedListNode getLinkedList(int[] arr) {

        SinglyLinkedListNode head = new SinglyLinkedListNode(-1);
        SinglyLinkedListNode temp = head;

        for(int i = 0; i < arr.length; i++) {

            temp.next = new SinglyLinkedListNode(arr[i]);

            temp = temp.next;
        }

        return head.next;
    }

    public void print() {

        SinglyLinkedListNode temp = this;

        while(temp != null) {

            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}
