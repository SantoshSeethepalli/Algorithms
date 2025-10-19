package com.DSA.TUF.LinkedList.module_2;

import com.DSA.TUF.LinkedList.DataNode.DoublyLinkedListNode;

public class InsertNodeBeforeKthNodeInDLL {

    public DoublyLinkedListNode insertBeforeKthPosition(DoublyLinkedListNode head, int data, int position) {

        if(head == null) return null;

        if(position == 1) {

            DoublyLinkedListNode newHead = new DoublyLinkedListNode(data);
            newHead.next = head;
            head.previous = newHead;

            return newHead;
        }

        DoublyLinkedListNode temp = head;

        // traverse till position - 1
        for(int i = 1; (i < position) && temp != null; i++) {

            temp = temp.next;
        }

        if(temp == null) return head;

        DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);

        temp.previous.next = newNode;
        newNode.next = temp;

        newNode.previous = temp.previous;
        temp.previous = newNode;

        return head;
    }
}
