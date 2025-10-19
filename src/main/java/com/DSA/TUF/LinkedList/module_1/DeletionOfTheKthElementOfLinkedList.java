package com.DSA.TUF.LinkedList.module_1;

import com.DSA.TUF.LinkedList.DataNode.SinglyLinkedListNode;

public class DeletionOfTheKthElementOfLinkedList {

    public SinglyLinkedListNode deleteKthElementInTheLinkedList(SinglyLinkedListNode head, int k) {

        if(k == 1) {

            return head.next;
        }

        int currentPosition = 1;
        SinglyLinkedListNode temp = head;

        while(currentPosition + 1 < k) {

            temp = temp.next;
            currentPosition++;
        }

        if(temp.next == null) return head;
        temp.next = temp.next.next;

        return head;
    }
}
