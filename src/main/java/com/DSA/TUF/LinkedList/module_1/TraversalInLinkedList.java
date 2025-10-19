package com.DSA.TUF.LinkedList.module_1;

import com.DSA.TUF.LinkedList.DataNode.SinglyLinkedListNode;
import java.util.*;

public class TraversalInLinkedList {

    public List<Integer> getLinkedListInList(SinglyLinkedListNode head) {

        List<Integer> arrayListOfLinkedList = new ArrayList<>();
        SinglyLinkedListNode temp = head;

        while(temp != null) {

            arrayListOfLinkedList.add(temp.data);
            temp = temp.next;
        }

        return arrayListOfLinkedList;
    }
}
