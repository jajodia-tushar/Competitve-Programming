package com.interviewbit.linkedlist;


/*
Given a list, rotate the list to the right by k places, where k is non-negative.

For example:

Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
 */
public class RotateList {

    public static void main(String[] args) {
        RotateList obj = new RotateList();
        ListNode head = ListNode.createLinkedList(1, 2, 3, 4, 5, 6, 7, 8);
        obj.rotateRight(head, 2).printList();
    }

    public ListNode rotateRight(ListNode A, int B) {

        int n = 0;
        ListNode faster = A;
        ListNode slower = A;
        int i = B;
        while (i > 0) {
            faster = faster.next;
            i--;
        }
        ListNode preFaster = faster;
        ListNode preSlower = slower;
        while (faster != null) {
            preFaster = faster;
            preSlower = slower;
            faster = faster.next;
            slower = slower.next;
        }

        ListNode head = slower;
        preFaster.next = A;
        preSlower.next = null;
        return head;
    }
}

/*
    There are some of the Edge Cases that need to be taken care properly.

    Rather if you reach kth node from end then it is done.
    just join this node to the head
    and then pre to null
    Return
 */