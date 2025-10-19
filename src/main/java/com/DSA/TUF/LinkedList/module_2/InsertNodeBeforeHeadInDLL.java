package com.DSA.TUF.LinkedList.module_2;

import com.DSA.TUF.LinkedList.DataNode.DoublyLinkedListNode;

public class InsertNodeBeforeHeadInDLL {

    public DoublyLinkedListNode insertNodeBeforeHead(DoublyLinkedListNode head, int data) {

        DoublyLinkedListNode newHead = new DoublyLinkedListNode(data);
        if(head == null) return newHead;

        newHead.next = head;
        head.previous = newHead;

        return newHead;
    }
}
