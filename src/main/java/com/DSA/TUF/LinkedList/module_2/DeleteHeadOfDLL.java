package com.DSA.TUF.LinkedList.module_2;

import com.DSA.TUF.LinkedList.DataNode.DoublyLinkedListNode;

public class DeleteHeadOfDLL {

    public DoublyLinkedListNode deleteHeadOfDoublyLinkedList(DoublyLinkedListNode head) {

        if(head.next == null) return null;

        head.next.previous = null;
        return head.next;
    }
}
