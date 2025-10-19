package com.DSA.TUF.LinkedList.module_5;

import com.DSA.TUF.LinkedList.DataNode.SinglyLinkedListNode;

public class FlattenLinkedList {

    public SinglyLinkedListNode mergeTwoLists(SinglyLinkedListNode list1, SinglyLinkedListNode list2) {

        SinglyLinkedListNode sortedHead = new SinglyLinkedListNode(-1);
        SinglyLinkedListNode temp = sortedHead;

        while(list1 != null && list2 != null) {

            if(list1.data <= list2.data) {

                temp.child = list1;

                temp = temp.child;
                list1 = list1.child;
            } else {

                temp.child = list2;

                temp = temp.child;
                list2 = list2.child;
            }
        }

        temp.child = (list1 != null) ? list1 : list2;

        return sortedHead.child;
    }

    public SinglyLinkedListNode flattenLinkedList(SinglyLinkedListNode head) {

        if(head == null || head.next == null) return head;

        SinglyLinkedListNode l1 = head;
        SinglyLinkedListNode l2 = head.next;
        SinglyLinkedListNode next = head.next.next;

        while(l2 != null) {

            l1 = mergeTwoLists(l1, l2);
            l2 = next;

            if(next != null) next = next.next;
        }

        return l1;
    }
}
