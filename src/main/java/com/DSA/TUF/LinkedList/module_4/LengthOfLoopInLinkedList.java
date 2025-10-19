package com.DSA.TUF.LinkedList.module_4;

import com.DSA.TUF.LinkedList.DataNode.SinglyLinkedListNode;

public class LengthOfLoopInLinkedList {

    public int findLengthOfLoop(SinglyLinkedListNode head) {

        SinglyLinkedListNode slow = head;
        SinglyLinkedListNode fast = head;

        while(fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) break;
        }

        // no loop
        if(slow == null || slow.next == null) return 0;

        slow = slow.next;
        int length = 1;

        while(slow != fast) {

            slow = slow.next;
            length++;
        }

        return length;
    }
}
