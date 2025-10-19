package com.DSA.TUF.LinkedList.module_4;

import com.DSA.TUF.LinkedList.DataNode.SinglyLinkedListNode;
import com.DSA.TUF.LinkedList.module_3.ReverseLL;

public class AddOneToNumberRepresentedByLL {


    public SinglyLinkedListNode addOneToLinkedList(SinglyLinkedListNode head) {

        ReverseLL object = new ReverseLL();
        SinglyLinkedListNode reverseHead = object.reverse(head);

        addCarry(reverseHead, 1);

        return object.reverse(reverseHead);
    }

    private void addCarry(SinglyLinkedListNode head, int carry) {

        if(carry == 0) return;

        head.data = head.data + carry;

        carry = head.data / 10;
        head.data = head.data % 10;

        if(head.next == null && carry != 0) {

            head.next = new SinglyLinkedListNode(carry);
            return;
        } else {

            addCarry(head.next, carry);
        }
    }
}
