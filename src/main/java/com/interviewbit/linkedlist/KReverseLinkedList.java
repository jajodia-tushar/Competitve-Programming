package com.interviewbit.linkedlist;


/*

    Given a singly linked list and an integer K, reverses the nodes of the
    list K at a time and returns modified linked list.
    NOTE : The length of the list is divisible by K
    Example :
    Given linked list 1 -> 2 -> 3 -> 4 -> 5 -> 6 and K=2,
    You should return 2 -> 1 -> 4 -> 3 -> 6 -> 5
    Try to solve the problem using constant extra space.

 */
public class KReverseLinkedList {

    public static void main(String[] args) {

        ListNode head = ListNode.createLinkedList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
        KReverseLinkedList obj = new KReverseLinkedList();
        ListNode finalList = obj.reverseLinkedList(head, 4);
        finalList.printList();

    }

    public ListNode reverseList(ListNode A, int B) {
        ListNode current = A;
        ListNode finalHead = null;
        ListNode previous = null;

        while (current != null && current.next != null) {
            ListNode firstNode = null;
            for (int i = 0; i < B; i++) {
                if (firstNode == null) {
                    firstNode = current;
                }

                ListNode temp = current.next;
                current.next = previous;
                previous = current;
                current = temp;
            }

            if (finalHead == null) {
                finalHead = previous;
            }
            ListNode temp = current;
            int j = B;
            while (j > 1 && temp != null && temp.next != null) {
                temp = temp.next;
                j--;
            }
            firstNode.next = temp;
            previous = null;
        }
        return finalHead;
    }

    public ListNode reverseLinkedList(ListNode A, int B) {

        int c = 0;
        ListNode prev = null;
        ListNode next = null;
        ListNode current = A;
        while (current != null && c < B) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            c++;
        }
        if (current != null) {
            A.next = reverseLinkedList(current, B);
        }

        return prev;
    }
}

/*
    Without Recursion this question is very hard to do.
    For thinking in terms of Recursion.

    Make a function that will reverse K elements in the list and return
    the last item of the list.

    Additionally, it would call recursively to the next bucket as well.

    Now there is just one missing link.
    The end ( after reversing) or Head( before reversing) should point to
    whatever the next recursive call will return.
    So to do that add some code.
 */