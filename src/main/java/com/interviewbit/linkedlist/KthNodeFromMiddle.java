package com.interviewbit.linkedlist;

/*
Problem Description

Given a linked list A of length N and an integer B.

You need to find the value of the Bth node from the middle towards the beginning of the Linked List A.

If no such element exists, then return -1.

NOTE:

Position of middle node is: (N/2)+1, where N is the total number of nodes in the list.


Problem Constraints
1 <= N <= 105
1<= Value in Each Link List Node <= 103
1 <= B <= 105


Input Format
First argument is the head pointer of the linkedlist A.

Second argument is an integer B.



Output Format
Return an integer denoting the value of the Bth from the middle towards the head of the linked list A. If no such element exists, then return -1.



Example Input
Input 1:

 A = 3 -> 4 -> 7 -> 5 -> 6 -> 1 6 -> 15 -> 61 -> 16
 B = 3
Input 2:

 A = 1 -> 14 -> 6 -> 16 -> 4 -> 10
 B = 2
Input 3:

 A = 1 -> 14 -> 6 -> 16 -> 4 -> 10
 B = 10


Example Output
Output 1:

 4
Output 2:

 14
Output 3:

 -1


Example Explanation
Explanation 1:

 The Middle of the linked list is the node with value 6.
 The 1st node from the middle of the linked list is the node with value 5.
 The 2nd node from the middle of the linked list is the node with value 7.
 The 3rd node from the middle of the linked list is the node with value 4.
 So we will output 4.
Explanation 2:

 The Middle of the linked list is the node with value 16.
 The 1st node from the middle of the linked list is the node with value 6.
 The 2nd node from the middle of the linked list is the node with value 14.
 So we will output 14.
Explanation 3:

 The Middle of the linked list is the node with value 16.
 There are only 3 nodes to the left of the middle node and we need to find the 10th node which d
 */

// YOU MIGHT NEED TO VISIT THIS CHECKAGAIN
public class KthNodeFromMiddle {

    public static void main(String[] args) {

        KthNodeFromMiddle obj = new KthNodeFromMiddle();
        ListNode listNode = ListNode.createLinkedList(3, 4, 7, 5, 6, 16, 15, 61, 16);
        int result = obj.solve(listNode, 3);
        System.out.println(result);

    }

    public int solve(ListNode A, int B) {

        ListNode dummy = new ListNode(-1);
        dummy.next = A;
        ListNode faster = A;
        ListNode slower = A;
        ListNode possible = dummy;
        int i = 0;
        B--;
        while (faster != null && faster.next != null) {
            faster = faster.next.next;
            slower = slower.next;
            if (--B < 0) {
                possible = possible.next;
            }
        }

        return possible.val;
    }
}

/*
    Not a very Good Question, were trying to create confusion in the question itself.
    But Was able to crack it and do perfectly.

    Just Use two pointer so that if faster hits null you are in middle with slower.
    Now while traversing keep decreasing B as well.
    So now if B hits 0 start increasing your answer as well which will start from head.
    Return as required.

    Just there is some changes in the Middle -> N/2 + 1 so faster and slower both will
    start from head.
 */