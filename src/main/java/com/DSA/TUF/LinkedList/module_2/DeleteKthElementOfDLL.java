package com.DSA.TUF.LinkedList.module_2;

import com.DSA.TUF.LinkedList.DataNode.DoublyLinkedListNode;

public class DeleteKthElementOfDLL {

    public DoublyLinkedListNode deleteKthElementFromTheDoublyLinkedList(DoublyLinkedListNode head, int k) {

        if(head == null) return null;

        if(k == 1) {

            if(head.next != null) head.next.previous = null;
            return head.next;
        }

        DoublyLinkedListNode temp = head;
        for(int idx = 1; (idx < k) && (temp != null); idx++) {

            temp = temp.next; // loop till the kth node
        }

        if(temp == null) return head;

        DoublyLinkedListNode previousNode = temp.previous;
        DoublyLinkedListNode nextNode = temp.next;

        temp.next = temp.previous = null;


        if(previousNode != null) previousNode.next = nextNode;
        if(nextNode != null) nextNode.previous = previousNode;


        return head;
    }
}
