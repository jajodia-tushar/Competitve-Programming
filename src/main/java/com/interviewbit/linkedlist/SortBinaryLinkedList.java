package com.interviewbit.linkedlist;

import java.util.List;

/*
Problem Description

Given a Linked List A consisting of N nodes.

The Linked List is binary i.e data values in the linked list nodes consist of only 0's and 1's.

You need to sort the linked list and return the new linked list.

NOTE:

Try to do it in constant space.


Problem Constraints
1 <= N <= 105

A.val = 0 or A.val = 1



Input Format
First and only argument is the head pointer of the linkedlist A.



Output Format
Return the head pointer of the new sorted linked list.



Example Input
Input 1:

 1 -> 0 -> 0 -> 1
Input 2:

 0 -> 0 -> 1 -> 1 -> 0


Example Output
Output 1:

 0 -> 0 -> 1 -> 1
Output 2:

 0 -> 0 -> 0 -> 1 -> 1


Example Explanation
Explanation 1:

 The sorted linked list looks like:
  0 -> 0 -> 1 -> 1
Explanation 2:

 The sorted linked list looks like:
  0 -> 0 -> 0 -> 1 -> 1
 */
public class SortBinaryLinkedList {


    public static void main(String[] args) {

        SortBinaryLinkedList obj = new SortBinaryLinkedList();
        ListNode head = ListNode.createLinkedList(0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1);
        ListNode result = obj.solve(head);
        result.printList();
    }

    public ListNode solve(ListNode head) {

        int countOfZero = 0;
        int countOfOne = 0;

        ListNode curr = head;

        while (curr != null) {
            if (curr.val == 0) countOfZero++;
            else countOfOne++;
            curr = curr.next;
        }
        curr = head;
        while (countOfZero-- > 0) {
            curr.val = 0;
            curr = curr.next;
        }

        while (countOfOne-- > 0) {
            curr.val = 1;
            curr = curr.next;
        }

        return head;
    }
}

/*
    Thinking Out of the Box.
    Count the Numbers of 1 and 0 and now you don't have to create new nodes of 1 and 0s.
    You can actually update the values.
 */
