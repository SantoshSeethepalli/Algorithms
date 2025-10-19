package com.DSA.TUF.LinkedList.module_6;

import com.DSA.TUF.LinkedList.DataNode.DoublyLinkedListNode;
import com.DSA.TUF.LinkedList.DataNode.SinglyLinkedListNode;

public class DeleteAllOccurrencesOfAKeyInDoublyLinkedList {

    public DoublyLinkedListNode deleteAllOccurrences(DoublyLinkedListNode head, int target) {

        DoublyLinkedListNode temp = head;

        while(temp != null) {

            DoublyLinkedListNode nextInIteration = temp.next;

            if(temp.data == target) {

                if(temp == head) head = temp.next;

                DoublyLinkedListNode previous = temp.previous;
                DoublyLinkedListNode next = temp.next;

                if(previous != null) previous.next = next;
                if(next != null) next.previous = previous;
            }

            temp = nextInIteration;
        }

        return head;
    }
}
