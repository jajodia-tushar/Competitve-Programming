package com.interviewbit.linkedlist;

/*
Given a linked list, remove the nth node from the end of list and return its head.

For example,
Given linked list: 1->2->3->4->5, and n = 2.
After removing the second node from the end, the linked list becomes 1->2->3->5.

 Note:
If n is greater than the size of the list, remove the first node of the list.
Try doing it using constant additional space.
 */

public class RemoveNthNodeFromListEnd {

    public static void main(String[] args) {

        ListNode newNode = ListNode.createLinkedList(1, 2, 3, 4, 5);
        RemoveNthNodeFromListEnd obj = new RemoveNthNodeFromListEnd();
        ListNode returnedList = obj.removeNthFromEnd(newNode, 1);
        returnedList.printList();
    }

    public ListNode removeNthFromEnd(ListNode A, int B) {
        int n = 0;
        ListNode head = A;
        while (head != null) {
            head = head.next;
            n++;
        }

        if (B >= n) return A.next;
        int forwardCount = n - B;
        head = A;
        while (forwardCount > 1) {
            head = head.next;
            forwardCount--;
        }

        head.next = head.next.next;
        return A;
    }
}

/*
    Basic Idea is to reach one Node previous to the Node you want to delete.
    Now you have to just Do the deletion.
    pre.next = curr.next;


    You have to reach k nodes from end.
    So if your faster pointer is K nodes ahead of you
    then your slower pointer will be in k nodes when your faster pointer reaches end.

 */
