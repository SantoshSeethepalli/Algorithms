package com.DSA.TUF.LinkedList.module_4;

import com.DSA.TUF.LinkedList.DataNode.SinglyLinkedListNode;

public class DeleteTheMiddleNodeInLL {

    public SinglyLinkedListNode deleteMiddle(SinglyLinkedListNode head) {

        if(head == null || head.next == null) return null;

        SinglyLinkedListNode dummyHead = new SinglyLinkedListNode(-1); // take a step back to start slow pointer to perform deletion.
        dummyHead.next = head;

        SinglyLinkedListNode slow = dummyHead;
        SinglyLinkedListNode fast = head;

        while(fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
        }

        slow.next = slow.next.next;

        return head;
    }
}
