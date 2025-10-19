package com.DSA.TUF.LinkedList.module_2;

import com.DSA.TUF.LinkedList.DataNode.DoublyLinkedListNode;

public class DeleteTailOfDLL {

    public DoublyLinkedListNode deleteHeadOfDoublyLinkedList(DoublyLinkedListNode head) {

        // for handling no.of nodes == 1 case
        if(head.next == null) return null;

        DoublyLinkedListNode temp = head;
        while(temp.next != null) temp = temp.next;

        temp.previous.next = null;
        temp.previous = null;

        return head;
    }
}
