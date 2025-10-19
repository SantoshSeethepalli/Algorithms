package com.DSA.TUF.LinkedList.module_2;

import com.DSA.TUF.LinkedList.DataNode.DoublyLinkedListNode;

public class InsertBeforeGivenNodeInDLL {

    public void insertBeforeGivenNode(DoublyLinkedListNode node, int data) {

        DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);

        if(node.previous != null) node.previous.next = newNode;
        newNode.next = node;

        newNode.previous = node.previous;
        node.previous = newNode;
    }
}
