package com.DSA.TUF.LinkedList.module_3;

import com.DSA.TUF.LinkedList.DataNode.SinglyLinkedListNode;

public class AddTwoNumbersInLL {

    public SinglyLinkedListNode addTwoListCleanVersion(SinglyLinkedListNode l1, SinglyLinkedListNode l2) {

        SinglyLinkedListNode result = new SinglyLinkedListNode(-1);
        SinglyLinkedListNode temp = result;

        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {

            int val1 = (l1 != null) ? l1.data : 0;
            int val2 = (l2 != null) ? l2.data : 0;

            int sum = val1 + val2 + carry;
            carry = sum / 10;
            int digit = sum % 10;

            temp.next = new SinglyLinkedListNode(digit);
            temp = temp.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return result.next;
    }

    public SinglyLinkedListNode addTwoLists(SinglyLinkedListNode num1, SinglyLinkedListNode num2) {

        SinglyLinkedListNode result = new SinglyLinkedListNode(-1);
        SinglyLinkedListNode temp = result;

        int carry = 0;

        while(num1 != null && num2 != null) {

            int value = num1.data + num2.data + carry;

            carry = value / 10;
            int digit = value % 10;

            temp.next = new SinglyLinkedListNode(digit);
            temp = temp.next;

            num1 = num1.next;
            num2 = num2.next;
        }

        while(num1 != null) {

            int value = num1.data + carry;

            carry = value / 10;
            int digit = value % 10;

            temp.next = new SinglyLinkedListNode(digit);
            temp = temp.next;

            num1 = num1.next;
        }


        while(num2 != null) {

            int value = num2.data + carry;

            carry = value / 10;
            int digit = value % 10;

            temp.next = new SinglyLinkedListNode(digit);
            temp = temp.next;

            num2 = num2.next;
        }

        if(carry == 1) {

            temp.next = new SinglyLinkedListNode(carry);
        }

        return result.next;
    }
}
