package com.DSA.TUF.LinkedList.module_2;

import com.DSA.TUF.LinkedList.DataNode.DoublyLinkedListNode;

public class InsertNodeBeforeTailInDLL {

    public DoublyLinkedListNode insertNodeBeforeTail(DoublyLinkedListNode head, int data) {

        DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);

        if(head == null) return newNode;
        if(head.next == null) {

            newNode.next = head;
            head.previous = newNode;

            return newNode;
        }

        DoublyLinkedListNode lastButOneNode = head;

        while(lastButOneNode.next != null && lastButOneNode.next.next != null) {

            lastButOneNode = lastButOneNode.next;
        }

        lastButOneNode.next.previous = newNode;
        newNode.previous = lastButOneNode;

        newNode.next = lastButOneNode.next;
        lastButOneNode.next = newNode;

        return head;
    }
}
