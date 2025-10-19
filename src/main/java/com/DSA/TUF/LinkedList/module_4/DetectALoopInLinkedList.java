package com.DSA.TUF.LinkedList.module_4;

import com.DSA.TUF.LinkedList.DataNode.SinglyLinkedListNode;

public class DetectALoopInLinkedList {

    public boolean hasCycle(SinglyLinkedListNode head) {

        SinglyLinkedListNode fast = head;
        SinglyLinkedListNode slow = head;

        while(fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) return true;
        }

        return false;
    }
}
