package com.interviewbit.linkedlist;

/*
Sort a linked list in O(n log n) time using constant space complexity.

Example :

Input : 1 -> 5 -> 4 -> 3

Returned list : 1 -> 3 -> 4 -> 5
 */
public class SortList {

    public static void main(String[] args) {
        ListNode head = ListNode.createLinkedList(5, 66, 68, 42, 73, 25, 84, 63, 72, 20, 77, 38, 8, 99, 92, 49, 74, 45, 30, 51, 50, 95, 56, 19, 31, 26, 98, 67, 100, 2, 24, 6, 37, 69, 11, 16, 61, 23, 78, 27, 64, 87, 3, 85, 55, 22, 33, 62);
        SortList obj = new SortList();
        obj.sortList(head).printList();
    }

    public ListNode sortList(ListNode A) {

        if (A == null || A.next == null) {
            return A;
        }

        ListNode middle = getMiddle(A);
        ListNode middleNext = middle.next;
        middle.next = null;

        ListNode left = sortList(A);
        ListNode right = sortList(middleNext);

        return merge(left, right);


    }

    public ListNode merge(ListNode left, ListNode right) {

        if (left == null)
            return right;
        if (right == null)
            return left;
        ListNode result = null;
        if (left.val < right.val) {
            result = left;
            result.next = merge(left.next, right);
        } else {
            result = right;
            right.next = merge(left, right.next);
        }

        return result;
    }

    public ListNode getMiddle(ListNode head){

        if(head == null) return null;

        ListNode slow = head;
        ListNode fast = head.next;

        while( fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
/*
    There is nothing hard and fast in this question.
    Things are simple and Easy to grasp.
    Do Merge Sort and it works like magic
 */