package com.interviewbit.linkedlist;

import com.interviewbit.strings.RemoveConsecutiveCharacters;

/*
Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
 */
public class RemoveDuplicatesFromSortedList {

    public static void main(String[] args) {

        RemoveDuplicatesFromSortedList obj = new RemoveDuplicatesFromSortedList();
        ListNode head = ListNode.createLinkedList(1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 5, 5, 6, 6, 6, 7, 7, 7);
        ListNode result = obj.deleteDuplicates(head);
        result.printList();

    }

    public ListNode deleteDuplicates(ListNode A) {

        if (A == null || A.next == null) return A;
        ListNode curr = A;
        ListNode result = null;
        ListNode pre = null;

        while (curr != null) {
            ListNode next = curr.next;
            while (next != null && next.val == curr.val) {
                curr = next;
                next = next.next;
            }

            if (pre == null) {
                pre = curr;
                result = curr;
            } else {
                pre.next = curr;
            }
            pre = curr;
            curr = next;
        }

        return result;

    }


}
