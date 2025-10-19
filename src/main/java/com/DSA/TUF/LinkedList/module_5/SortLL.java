package com.DSA.TUF.LinkedList.module_5;

import com.DSA.TUF.LinkedList.DataNode.SinglyLinkedListNode;

public class SortLL {

    private SinglyLinkedListNode mergeSortedList(SinglyLinkedListNode list1, SinglyLinkedListNode list2) {

        SinglyLinkedListNode sortedHead = new SinglyLinkedListNode(-1);
        SinglyLinkedListNode temp = sortedHead;

        while(list1 != null && list2 != null) {

            if(list1.data <= list2.data) {

                temp.next = list1;

                temp = temp.next;
                list1 = list1.next;
            } else {

                temp.next = list2;

                temp = temp.next;
                list2 = list2.next;
            }
        }

        temp.next = (list1 != null) ? list1 : list2;

        return sortedHead.next;
    }

    private SinglyLinkedListNode findMiddle(SinglyLinkedListNode list) {

        SinglyLinkedListNode slow = list;
        SinglyLinkedListNode fast = list.next;

        while(fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public SinglyLinkedListNode sortList(SinglyLinkedListNode head) {

        if(head == null || head.next == null) return head;

        SinglyLinkedListNode middle = findMiddle(head);

        SinglyLinkedListNode right = middle.next;
        middle.next = null;
        SinglyLinkedListNode left = head;

        left = sortList(left);
        right = sortList(right);

        return mergeSortedList(left, right);
    }
}
