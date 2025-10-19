package com.DSA.TUF.LinkedList.module_1;

import com.DSA.TUF.LinkedList.DataNode.SinglyLinkedListNode;

public class DeletionOfTheTailOfLinkedList {

    public SinglyLinkedListNode deleteTailOfLinkedList(SinglyLinkedListNode head) {

        if(head.next == null) {

            return null;
        }

        SinglyLinkedListNode temp = head;

        while(temp.next != null && temp.next.next != null) {

            temp = temp.next;
        }
        temp.next = null;

        return head;
    }
}
