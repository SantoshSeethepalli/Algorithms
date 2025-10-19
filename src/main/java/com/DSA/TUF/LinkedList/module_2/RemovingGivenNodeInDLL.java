package com.DSA.TUF.LinkedList.module_2;

import com.DSA.TUF.LinkedList.DataNode.DoublyLinkedListNode;

public class RemovingGivenNodeInDLL {

    /*
        Given a node's reference within a doubly linked list, remove that node from the linked list while preserving the list's integrity.
        You will only be given the node's reference, not the head of the list. It is guaranteed that the given node will not be the head of the list.
     */
    public void deleteGivenNode(DoublyLinkedListNode node) {

        if(node.next != null) {

            node.next.previous = node.previous;
        }
        node.previous.next = node.next;

        node.next = null;
        node.previous = null;
    }
}
