package com.interviewbit.linkedlist;


/*

Problem Description
Given a linked list A , reverse the order of all nodes at even positions.

Problem Constraints
1 <= Size of linked list <= 100000

Input Format
First and only argument is the head of the Linked-List A.

Output Format
Return the head of the new linked list.

Example Input
Input 1:

A = 1 -> 2 -> 3 -> 4
Input 2:

A = 1 -> 2 -> 3

Example Output
Output 1:

 1 -> 4 -> 3 -> 2
Output 2:

 1 -> 2 -> 3
Example Explanation

Explanation 1:
Nodes are positions 2 and 4 have been swapped.
Explanation 2:
No swapping neccassary here.
 */

import java.util.Stack;

public class EvenReverse {

    public static void main(String[] args) {

        EvenReverse obj = new EvenReverse();
        ListNode list = ListNode.createLinkedList(1, 2, 3, 4, 5);
        ListNode result = obj.solve(list);
        result.printList();

    }

    public ListNode solve(ListNode A) {

        if (A == null || A.next == null || A.next.next == null) return A;

        ListNode head = A;
        Stack<ListNode> stack = new Stack<>();
        int i = 0;
        ListNode pre = A;
        A = A.next;
        while (A != null) {
            ListNode next = A.next;
            if (i % 2 == 0) {
                A.next = null;
                stack.push(A);
            } else {
                pre.next = A;
                pre = pre.next;
                pre.next = null;
            }
            A = next;
            i++;
        }

        A = head;
        while (!stack.isEmpty()) {

            ListNode curr = stack.pop();
            ListNode next = A.next;
            A.next = curr;
            curr.next = next;
            A = next;
        }

        return head;
    }
}

/*
    There can be many ways how you approach this particular Problem.
    The basic idea is untangle the odd and even nodes from the list.
    Reverse the even and
    then merge the list.
    Simple

 */
