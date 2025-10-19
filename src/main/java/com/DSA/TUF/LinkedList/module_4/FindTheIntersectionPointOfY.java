package com.DSA.TUF.LinkedList.module_4;

import com.DSA.TUF.LinkedList.DataNode.SinglyLinkedListNode;

public class FindTheIntersectionPointOfY {

    public SinglyLinkedListNode findTheYIntersectionNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {

        SinglyLinkedListNode temp1 = head1;
        SinglyLinkedListNode temp2 = head2;

        while(temp1 != temp2) {

            temp1 = temp1.next;
            temp2 = temp2.next;

            if(temp1 == temp2) return temp1;

            if(temp1 == null) temp1 = head2;
            if(temp2 == null) temp2 = head1;
        }

        return temp1;
    }
}
