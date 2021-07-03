package com.interviewbit.linkedlist;

/*
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.
 */
// YOU MIGHT NEED TO VISIT THIS CHECKAGAIN
public class RemoveDuplicatesFromSortedListII {

    public static void main(String[] args) {

        RemoveDuplicatesFromSortedListII obj = new RemoveDuplicatesFromSortedListII();
        ListNode head = ListNode.createLinkedList(1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 5, 5, 6, 6, 6, 7, 7, 7);
        ListNode result = obj.deleteDuplicates(head);
        result.printList();

    }

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode temp = new ListNode(0);
        temp.next = head;
        head = temp;
        ListNode pre = null;
        ListNode result = head;
        ListNode curr = head;

        while (curr != null) {

            ListNode next = curr.next;
            while (next != null && next.val == curr.val) {
                curr = next;
                next = next.next;
            }

            if (pre != null && pre.next != curr) {
                pre.next = curr.next;
                curr = pre.next;
            } else {
                pre = curr;
                curr = curr.next;
            }
        }

        return result.next;

    }
}

/*
    This one is quite interesting than version I.
    Because You have to remove the complete repeated number.
    So if it starts from first you have to take care of too many scenarios.
    But thinking and small trick will remove so many edge cases.
    Make a dummy node and insert at the first.

    Now You only have to take care of the nodes repeating in middle.

    For that part it is quite easy right ?
    if matching then you can assign the pre.next = next;
    else normal things.

 */
