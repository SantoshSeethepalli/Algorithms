package com.DSA.TUF.LinkedList.module_2;

import com.DSA.TUF.LinkedList.DataNode.DoublyLinkedListNode;

import java.util.List;

public class ConvertArrayToDLL {

    public DoublyLinkedListNode getDoublyLinkedList(int[] arr) {


        if(arr.length == 0) return null;
        if(arr.length == 1) return new DoublyLinkedListNode(arr[0]);

        DoublyLinkedListNode head = new DoublyLinkedListNode(arr[0]);
        DoublyLinkedListNode temp = head;

        for(int i = 1; i < arr.length; i++) {

            temp.next = new DoublyLinkedListNode(arr[i]);

            temp.next.previous = temp;
            temp = temp.next;
        }

        return head;
    }
}
