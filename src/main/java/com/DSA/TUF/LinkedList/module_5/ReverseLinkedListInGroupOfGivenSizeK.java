package com.DSA.TUF.LinkedList.module_5;

import com.DSA.TUF.LinkedList.DataNode.SinglyLinkedListNode;

public class ReverseLinkedListInGroupOfGivenSizeK {

    private SinglyLinkedListNode[] reverseNextKGroup(SinglyLinkedListNode head, int k) {

        SinglyLinkedListNode previous = null;
        SinglyLinkedListNode current = head;
        int count = 1;

        SinglyLinkedListNode temp = head;
        for (int i = 0; i < k; i++) {

            if (temp == null) return new SinglyLinkedListNode[]{head, null};
            temp = temp.next;
        }

        while(current != null && count <= k) {

            SinglyLinkedListNode next = current.next;

            current.next = previous;

            previous = current;
            current = next;

            count++;
        }

        return new SinglyLinkedListNode[]{previous, current};
    }

    public SinglyLinkedListNode reverseKGroup(SinglyLinkedListNode head, int k) {

        if(head == null || head.next == null) return head;

        SinglyLinkedListNode newHead = null;
        SinglyLinkedListNode lastEnd = null;

        SinglyLinkedListNode temp = head;

        while(temp != null) {

            SinglyLinkedListNode[] startAndNext = reverseNextKGroup(temp, k);

            SinglyLinkedListNode start = startAndNext[0];
            SinglyLinkedListNode nextGroupHead = startAndNext[1];

            if(newHead == null) newHead = start;
            if(lastEnd != null) lastEnd.next = start;

            lastEnd = temp;
            temp = nextGroupHead;
        }

        return newHead;
    }
}