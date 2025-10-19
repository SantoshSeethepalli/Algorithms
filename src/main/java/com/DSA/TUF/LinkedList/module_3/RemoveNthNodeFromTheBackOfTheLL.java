package com.DSA.TUF.LinkedList.module_3;

import com.DSA.TUF.LinkedList.DataNode.SinglyLinkedListNode;

public class RemoveNthNodeFromTheBackOfTheLL {

    public SinglyLinkedListNode removeNthFromEnd(SinglyLinkedListNode head, int n) {

        SinglyLinkedListNode dummyHead = new SinglyLinkedListNode(-1);
        dummyHead.next = head;

        SinglyLinkedListNode slow = dummyHead;
        SinglyLinkedListNode fast = dummyHead;

        for(int i = 0; i <= n; i++) {

            fast = fast.next;
        }

        while(fast != null) {

            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return head;
    }
}