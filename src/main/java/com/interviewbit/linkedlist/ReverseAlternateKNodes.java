package com.interviewbit.linkedlist;

/*
Problem Description

Given a linked list A of length N and an integer B.

You need to reverse every alternate B nodes in the linked list A.

Problem Constraints
1 <= N <= 105
1<= Value in Each Link List Node <= 103
1 <= B <= N
N is divisible by B


Input Format
First argument is the head pointer of the linkedlist A.

Second argument is an integer B.



Output Format
Return the head pointer of the final linkedlist as described.



Example Input
Input 1:

 A = 3 -> 4 -> 7 -> 5 -> 6 -> 6 -> 15 -> 61 -> 16
 B = 3
Input 2:

 A = 1 -> 4 -> 6 -> 6 -> 4 -> 10
 B = 2


Example Output
Output 1:

 7 -> 4 -> 3 -> 5 -> 6 -> 6 -> 16 -> 61 -> 15
Output 2:

 4 -> 1 -> 6 -> 6 -> 10 -> 4


Example Explanation
Explanation 1:

 The linked list contains 9 nodes and we need to reverse alternate 3 nodes.
 First sublist of length 3  is 3 -> 4 -> 7 so on reversing it we get 7 -> 4 -> 3.
 Second sublist of length 3 is 5 -> 6 -> 6 we don't need to reverse it.
 Third sublist of length 3 is 15 -> 61 -> 16 so on reversing it we get 16 -> 61 -> 15.
Explanation 2:

 The linked list contains 6 nodes and we need to reverse alternate 2 nodes.
 First sublist of length 2 is 1 -> 4 so on reversing it we get 4 -> 1.
 Second sublist of length 2 is 6 -> 6 we don't need to reverse it.
 Third sublist of length 2 is 4 -> 10 so on reversing it we get 10 -> 4.
 */

public class ReverseAlternateKNodes {

    public static void main(String[] args) {

    }

    public ListNode solve(ListNode head, int k) {
        if (head == null)
            return null;

        ListNode originalHead = head;
        ListNode curr = head;
        ListNode prev = null;

        int b = k;
        while (curr != null && b-- != 0) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        originalHead.next = curr;
        b = k - 1;
        while (curr != null && b-- != 0) {
            curr = curr.next;
        }
        if (curr != null) {
            curr.next = solve(curr.next, k);
        }
        return head;
    }

}

/*
    This is just the extension of the KthReverseLinkedList Question.
    Instead of calling the recursive call right away.
    What we must try to do is traverse the k elements forward and only call the next reverse.

 */