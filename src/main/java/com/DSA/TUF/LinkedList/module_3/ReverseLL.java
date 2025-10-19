package com.DSA.TUF.LinkedList.module_3;

import com.DSA.TUF.LinkedList.DataNode.SinglyLinkedListNode;

public class ReverseLL {

    public SinglyLinkedListNode
    reverse(SinglyLinkedListNode head) {

        if(head == null || head.next == null) return head;

        SinglyLinkedListNode previous = null;
        SinglyLinkedListNode current = head;

        while(current != null) {

            SinglyLinkedListNode next = current.next;

            current.next = previous;

            previous = current;
            current = next;
        }

        return previous;
    }
}
