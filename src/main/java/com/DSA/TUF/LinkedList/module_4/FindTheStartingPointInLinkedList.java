package com.DSA.TUF.LinkedList.module_4;

import com.DSA.TUF.LinkedList.DataNode.SinglyLinkedListNode;

public class FindTheStartingPointInLinkedList {

    public SinglyLinkedListNode findStartingPoint(SinglyLinkedListNode head) {

        SinglyLinkedListNode slow = head;
        SinglyLinkedListNode fast = head;

        while(fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) break;
        }

        fast = head;

        while(slow != null && fast != null) {

            if(slow == fast) return slow;

            slow = slow.next;
            fast = fast.next;
        }

        return fast;
    }
}
