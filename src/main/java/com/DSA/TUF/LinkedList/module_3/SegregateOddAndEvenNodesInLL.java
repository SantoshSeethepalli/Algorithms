package com.DSA.TUF.LinkedList.module_3;

import com.DSA.TUF.LinkedList.DataNode.SinglyLinkedListNode;

public class SegregateOddAndEvenNodesInLL {

    public SinglyLinkedListNode getOddThenEvenList(SinglyLinkedListNode head) {

        if(head == null || head.next == null) return head;


        SinglyLinkedListNode oddNumbers = head;

        SinglyLinkedListNode evenNumbers = head.next;
        SinglyLinkedListNode firstIndexOfEvenNumbers = head.next;


        SinglyLinkedListNode assignmentPointer = head.next.next;

        while(assignmentPointer != null) {

            // assign odd
            oddNumbers.next = assignmentPointer;
            oddNumbers = oddNumbers.next;

            // move one step
            assignmentPointer = assignmentPointer.next;

            // assign even
            evenNumbers.next = assignmentPointer;
            evenNumbers = evenNumbers.next;

            // move one step
            if(assignmentPointer != null) assignmentPointer = assignmentPointer.next;
        }

        oddNumbers.next = firstIndexOfEvenNumbers;

        return head;
    }
}
