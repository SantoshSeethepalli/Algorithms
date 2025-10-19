package com.DSA.TUF.LinkedList.module_4;

import com.DSA.TUF.LinkedList.DataNode.SinglyLinkedListNode;

public class FindMiddleOfLinkedList {

    public SinglyLinkedListNode getMiddleOfLinkedList(SinglyLinkedListNode head) {

        if(head == null || head.next == null) return head;

        SinglyLinkedListNode slow = head;
        SinglyLinkedListNode fast = head;

        while(fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
