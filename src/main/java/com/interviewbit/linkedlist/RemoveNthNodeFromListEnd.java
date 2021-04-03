package com.interviewbit.linkedlist;

public class RemoveNthNodeFromListEnd {

    public static void main(String[] args) {

        ListNode newNode = ListNode.createLinkedList(1,2,3,4,5);
        RemoveNthNodeFromListEnd obj = new RemoveNthNodeFromListEnd();
        ListNode returnedList = obj.removeNthFromEnd(newNode, 1);
        returnedList.printList();
    }

    public ListNode removeNthFromEnd(ListNode A, int B) {
        int n = 0;
        ListNode head = A;
        while(head != null){
            head = head.next;
            n++;
        }

        if( B >= n) return A.next;
        int forwardCount = n - B;
        head = A;
        while(forwardCount > 1){
            head = head.next;
            forwardCount--;
        }

        head.next = head.next.next;
        return A;
    }
}
