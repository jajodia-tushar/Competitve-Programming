package com.interviewbit.linkedlist;

/*
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Try solving it using constant additional space.

Example :
Input :
                  ______
                 |     |
                 \/    |
        1 -> 2 -> 3 -> 4

Return the node corresponding to node 3.
 */
public class ListCycle {

    public static void main(String[] args) {

        ListCycle obj = new ListCycle();

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n3;

        ListNode result = obj.detectCycle(n1);
        System.out.println(result.val);

    }

    public ListNode detectCycle(ListNode head) {

        if (head == null || head.next == null) return null;

        ListNode faster = head;
        ListNode slower = head;

        while (faster != null && faster.next != null) {
            faster = faster.next.next;
            slower = slower.next;
            if (faster == slower) {
                break;
            }
        }
        if (faster == null || faster.next == null) return null;

        slower = head;
        while (slower != faster) {
            slower = slower.next;
            faster = faster.next;
        }

        return slower;
    }
}

/*
    There is very interesting Maths involved in this .
    Please Refer the Copy to Know more on this.





 */
