package com.interviewbit.linkedlist;

/*
Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

 Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list. Note 2:
Usually the version often seen in the interviews is reversing the whole linked list which is obviously an easier version of this question.
 */

public class ReverseLinkListII {

    public static void main(String[] args) {
        ReverseLinkListII obj = new ReverseLinkListII();
        ListNode list = ListNode.createLinkedList(1, 2, 3, 4, 5);
        ListNode result = obj.reverseBetween(list, 2, 4);
        result.printList();
    }

    public ListNode reverseBetween(ListNode A, int B, int C) {

        if (A == null || A.next == null)
            return A;
        int i = 1;
        ListNode head = A;
        ListNode curr = A;

        if (B == 1)
            return reverse(curr, C - 1);

        while (i < (B - 1)) {
            curr = curr.next;
            i++;
        }

        curr.next = reverse(curr.next, (C - B));
        return A;
    }

    public ListNode reverse(ListNode A, int n) {


        ListNode prev = null;
        ListNode next = null;
        ListNode curr = A;
        ListNode first = null;
        int i = 0;

        while (i <= n) {
            if (first == null)
                first = curr;
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            i++;
        }
        first.next = curr;
        return prev;
    }
}

/*
    There is nothing really interesting in this question.
    If you think little bit you will be able to do it easily.
 */