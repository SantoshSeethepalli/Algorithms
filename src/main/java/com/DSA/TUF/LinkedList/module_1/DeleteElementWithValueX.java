package com.DSA.TUF.LinkedList.module_1;

import com.DSA.TUF.LinkedList.DataNode.SinglyLinkedListNode;

public class DeleteElementWithValueX {

    public SinglyLinkedListNode deleteLElementWithValueX(SinglyLinkedListNode head, int x) {

        if(head == null) return head;
        if(head.data == x) return head.next;

        SinglyLinkedListNode temp = head;

        while(temp.next != null && temp.next.data != x) {

            temp = temp.next;
        }

        if(temp.next == null) return head;
        temp.next = temp.next.next;

        return head;
    }
}
