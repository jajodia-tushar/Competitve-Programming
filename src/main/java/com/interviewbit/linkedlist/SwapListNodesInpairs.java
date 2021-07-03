package com.interviewbit.linkedlist;

/*
Given a linked list, swap every two adjacent nodes and return its head.

For example,

Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 */
public class SwapListNodesInpairs {

    public static void main(String[] args) {

        SwapListNodesInpairs obj = new SwapListNodesInpairs();
        ListNode list = ListNode.createLinkedList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        ListNode result = obj.swapPairs(list);
        result.printList();
    }


    public ListNode swapPairs(ListNode A) {
        if (A.next == null)
            return A;

        ListNode current = A;
        ListNode next = A.next;
        current.next = null;
        ListNode prev = current;
        current = next;
        next = current.next;
        current.next = prev;
        prev = current;
        current = next;

        if (current != null)
            A.next = swapPairs(current);
        return prev;
    }
}

/*
       Small Brother of KthReverse.
 */
