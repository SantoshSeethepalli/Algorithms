package com.DSA.TUF.LinkedList.module_1;

import com.DSA.TUF.LinkedList.DataNode.SinglyLinkedListNode;

public class InsertionAtTheTailOfLinkedList {

    public SinglyLinkedListNode insertAtTheTailOfLinkedList(SinglyLinkedListNode head, int data) {

        if(head == null) return new SinglyLinkedListNode(data);

        SinglyLinkedListNode temp = head;

        while(temp.next != null) {

            temp = temp.next;
        }

        temp.next = new SinglyLinkedListNode(data);

        return head;
    }

}
