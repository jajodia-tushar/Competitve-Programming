package com.interviewbit.linkedlist;

/*
Sort a linked list using insertion sort.
We have explained Insertion Sort at Slide 7 of Arrays
Insertion Sort Wiki has some details on Insertion Sort as well.
Example :
Input : 1 -> 3 -> 2
Return 1 -> 2 -> 3
 */

public class InsertionSortList {

    public static void main(String[] args) {
        InsertionSortList obj = new InsertionSortList();
        ListNode list = ListNode.createLinkedList(5, 66, 68, 42, 73, 25, 84, 63, 72, 20, 77, 38, 8, 99, 92, 49, 74, 45, 30, 51, 50, 95, 56, 19, 31, 26, 98, 67, 100, 2, 24, 6, 37, 69, 11, 16, 61, 23, 78, 27, 64, 87, 3, 85, 55, 22, 33, 62);
        ListNode result = obj.insertionSortList(list);
        result.printList();
    }


    public ListNode insertionSortList(ListNode A) {

        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = A;
        A = dummy;

        while (A.next != null) {

            ListNode curr = A;
            ListNode next = A.next;

            if (curr.val > next.val) {
                ListNode nextNext = next.next;
                ListNode traveller = dummy.next;
                ListNode pre = dummy;

                while (traveller != curr && traveller.val < next.val) {
                    pre = traveller;
                    traveller = traveller.next;
                }
                pre.next = next;
                next.next = traveller;
                curr.next = nextNext;
            }
            A = next;
        }

        return dummy.next;
    }
}

/*
    This is kind of a Simulation Problem.
    Just Think and You shall be able to do it clearly
 */