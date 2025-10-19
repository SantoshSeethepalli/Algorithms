package com.DSA.TUF.LinkedList.module_6;

import com.DSA.TUF.LinkedList.DataNode.DoublyLinkedListNode;
import com.DSA.TUF.LinkedList.DataNode.SinglyLinkedListNode;

public class RemoveDuplicatedFromSortedDoublyLinkedList {

    public DoublyLinkedListNode removeDuplicates(DoublyLinkedListNode head) {

        DoublyLinkedListNode temp = head;

        while(temp != null) {

            while(temp.next != null && temp.data == temp.next.data) {

                if(temp.next.next == null) {

                    temp.next = null;
                    return head;
                }

                DoublyLinkedListNode nextNode = temp.next;

                nextNode.next.previous = temp;
                temp.next = nextNode.next;
            }

            if(temp == head) head.next = temp.next;

            temp = temp.next;
        }

        return head;
    }
}
