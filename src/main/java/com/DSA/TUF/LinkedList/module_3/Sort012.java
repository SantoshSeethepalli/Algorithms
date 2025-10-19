package com.DSA.TUF.LinkedList.module_3;

import com.DSA.TUF.LinkedList.DataNode.SinglyLinkedListNode;

public class Sort012 {

    public SinglyLinkedListNode sort012(SinglyLinkedListNode head) {

        if(head == null || head.next == null) return head;

        SinglyLinkedListNode zero = new SinglyLinkedListNode(-1);
        SinglyLinkedListNode one = new SinglyLinkedListNode(-1);
        SinglyLinkedListNode two = new SinglyLinkedListNode(-1);

        SinglyLinkedListNode zeroHead = zero;
        SinglyLinkedListNode oneHead = one;
        SinglyLinkedListNode twoHead = two;

        while(head != null) {

            if(head.data == 0) {

                zero.next = head;
                zero = zero.next;
            } else if(head.data == 1) {

                one.next = head;
                one = one.next;
            } else {

                two.next = head;
                two = two.next;
            }

            head = head.next;
        }

        zero.next = (oneHead.next != null) ? oneHead.next : twoHead.next;
        one.next = (twoHead.next != null) ? twoHead.next : null;
        two.next = null;

        return zeroHead.next;
    }
}
