package com.DSA.TUF.LinkedList.module_4;

import com.DSA.TUF.LinkedList.DataNode.SinglyLinkedListNode;
import com.DSA.TUF.LinkedList.module_3.ReverseLL;

import java.util.*;

public class CheckIfLinkedListIsPalindromeOrNot {

    public boolean isPalindrome(SinglyLinkedListNode head) {

        // compute stack
        Stack<Integer> stack = new Stack<>();
        SinglyLinkedListNode temp = head;

        while(temp != null) {

            stack.push(temp.data);
            temp = temp.next;
        }

        temp = head;

        while(temp != null) {

            if(stack.isEmpty() || temp.data != stack.peek()) return false;

            stack.pop();
            temp = temp.next;
        }

        return true;
    }

    public boolean isPalindromeOptimal(SinglyLinkedListNode head) {

        SinglyLinkedListNode slow = head;
        SinglyLinkedListNode fast = head;

        while(fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
        }

        ReverseLL object = new ReverseLL();
        SinglyLinkedListNode reverseHead = object.reverse(slow);

        fast = head;

        while(slow != null && fast != null) {

            if(slow.data != fast.data) return false;

            slow = slow.next;
            fast = fast.next;
        }

        return true;
    }
}

