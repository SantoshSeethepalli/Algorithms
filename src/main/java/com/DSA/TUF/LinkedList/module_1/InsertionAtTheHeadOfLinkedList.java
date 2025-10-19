package com.DSA.TUF.LinkedList.module_1;

import com.DSA.TUF.LinkedList.DataNode.SinglyLinkedListNode;

public class InsertionAtTheHeadOfLinkedList {

    public SinglyLinkedListNode insertAtHead(SinglyLinkedListNode head, int val) {

        SinglyLinkedListNode newHead = new SinglyLinkedListNode(val);
        newHead.next = head;

        return newHead;
    }
}
