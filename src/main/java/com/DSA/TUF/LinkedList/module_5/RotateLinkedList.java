package com.DSA.TUF.LinkedList.module_5;

import com.DSA.TUF.LinkedList.DataNode.SinglyLinkedListNode;

public class RotateLinkedList {
    
    public SinglyLinkedListNode rotateRight(SinglyLinkedListNode head, int k) {

        if (head == null || head.next == null || k == 0) return head;

        int length = 0;

        SinglyLinkedListNode temp = head;
        while(temp != null) {

            length++;
            temp = temp.next;
        }

        k = k % length;
        if(k == 0) return head;

        SinglyLinkedListNode backward = head;
        SinglyLinkedListNode forward = head;

        for(int i = 0; i < k; i++) {

            forward = forward.next;
        }

        while(forward.next != null) {

            backward = backward.next;
            forward = forward.next;
        }

        SinglyLinkedListNode newHead = backward.next;

        backward.next = null;
        forward.next = head;

        return newHead;
    }
}
