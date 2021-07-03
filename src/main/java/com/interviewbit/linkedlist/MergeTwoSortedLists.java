package com.interviewbit.linkedlist;

import java.util.List;

/*
Merge two sorted linked lists and return it as a new list.

The new list should be made by splicing together the nodes of the first two lists, and should also be sorted.

For example, given following linked lists :

  5 -> 8 -> 20
  4 -> 11 -> 15
The merged list should be :

4 -> 5 -> 8 -> 11 -> 15 -> 20
 */
public class MergeTwoSortedLists {

    public static void main(String[] args) {

        MergeTwoSortedLists obj = new MergeTwoSortedLists();

        ListNode A = ListNode.createLinkedList(1, 2, 4, 5, 6, 7, 9, 123);
        ListNode B = ListNode.createLinkedList(1, 3, 4, 4, 4, 4, 9, 10);

        ListNode result = obj.mergeTwoLists(A, B);
        result.printList();

    }

    public ListNode mergeTwoLists(ListNode A, ListNode B) {

        if (A == null)
            return B;
        else if (B == null)
            return A;

        ListNode result = null;
        if (A.val <= B.val) {
            result = A;
            result.next = mergeTwoLists(A.next, B);
        } else {
            result = B;
            result.next = mergeTwoLists(A, B.next);
        }
        return result;
    }


}
