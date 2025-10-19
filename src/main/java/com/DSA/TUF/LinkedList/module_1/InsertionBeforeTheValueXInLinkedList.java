package com.DSA.TUF.LinkedList.module_1;

import com.DSA.TUF.LinkedList.DataNode.SinglyLinkedListNode;

public class InsertionBeforeTheValueXInLinkedList {

    public SinglyLinkedListNode insertValueBeforeGivenValueInLinkedList(SinglyLinkedListNode head, int insertBefore, int data) {


        if (head == null) {

            return null;
        } else if(head.data == insertBefore) {

            SinglyLinkedListNode newHead = new SinglyLinkedListNode(data);
            newHead.next = head;

            return newHead;
        }

        SinglyLinkedListNode temp = head;

        while(temp.next != null && temp.next.data != insertBefore) {

            temp = temp.next;
        }

        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);

        newNode.next = temp.next;
        temp.next = newNode;

        return head;
    }
}
