package com.DSA.TUF.LinkedList.module_5;

import com.DSA.TUF.LinkedList.DataNode.SinglyLinkedListNode;

public class CloneALinkedListWithRandomAndNextPointer {

    private SinglyLinkedListNode insertCopyNodesBetweenNodes(SinglyLinkedListNode head) {

        SinglyLinkedListNode temp = head;

        while(temp != null) {

            SinglyLinkedListNode next = temp.next;

            SinglyLinkedListNode copyInBetween = new SinglyLinkedListNode(temp.data);

            temp.next = copyInBetween;
            copyInBetween.next = next;

            temp = next;
        }

        return head;
    }

    private SinglyLinkedListNode makeCopyNodesToPointToRandomNodes(SinglyLinkedListNode head) {

        SinglyLinkedListNode temp = head;

        while(temp != null && temp.next != null) {

            if(temp.child == null) temp.next.child = null;
            else temp.next.child = temp.child.next;

            temp = temp.next.next;
        }

        return head;
    }

    private SinglyLinkedListNode getCopyList(SinglyLinkedListNode head) {

        SinglyLinkedListNode dummyCopyListHead = new SinglyLinkedListNode(-1);
        SinglyLinkedListNode copyListHead = dummyCopyListHead;
        SinglyLinkedListNode temp = head;

        while(temp != null && temp.next != null) {

            copyListHead.next = temp.next;
            temp.next = temp.next.next;

            copyListHead = copyListHead.next;
            temp = temp.next;
        }

        return dummyCopyListHead.next;
    }

    public SinglyLinkedListNode copyRandomList(SinglyLinkedListNode head) {

        if (head == null) return null;


        head = insertCopyNodesBetweenNodes(head);
        head = makeCopyNodesToPointToRandomNodes(head);
        return getCopyList(head);
    }
}
