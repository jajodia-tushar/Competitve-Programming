package com.interviewbit.linkedlist;

// SEEAGAIN
/*
Given a singly linked list

    L: L0 → L1 → … → Ln-1 → Ln,
reorder it to:

    L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …
You must do this in-place without altering the nodes’ values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.
 */
public class ReorderList {

    public static void main(String[] args) {

        ReorderList obj = new ReorderList();
        ListNode head = ListNode.createLinkedList(90, 94, 25, 51, 45, 29, 55, 63, 48, 27, 72, 10, 36, 68, 16, 20, 31, 7, 95, 70, 89, 23, 22, 9, 74, 71, 35, 5, 80, 11, 49, 92, 69, 6, 37, 84, 78, 28, 43, 64, 96, 57, 83, 13, 73, 97, 75, 59, 53, 52, 19, 18, 98, 12, 81, 24, 15, 60, 79, 34, 1, 54, 93, 65, 44, 4, 87, 14, 67, 26, 30, 77, 58, 85, 33, 21, 46, 82, 76, 88, 66, 101, 61, 47, 8);
        obj.reorderList(head).printList();

    }

    public ListNode reorderList(ListNode A) {

        if (A == null || A.next == null)
            return A;

        int i = 0;
        int total = 0;
        ListNode slower = A;
        ListNode faster = A;
        ListNode previous = null;

        while (faster != null && faster.next != null) {
            previous = slower;
            faster = faster.next.next;
            slower = slower.next;
            i++;
            total += 2;
        }
        if (faster != null)
            total++;

        previous.next = null;
        ListNode[] arr = new ListNode[total - i];
        i = 0;

        while (slower != null) {
            arr[i++] = slower;
            slower = slower.next;
        }


        ListNode head = A;
        i = 0;
        int n = arr.length;
        while (A != null) {
            ListNode next = A.next;
            A.next = arr[n - i - 1];
            arr[n - i - 1].next = next;
            previous = A;
            A = next;
            i++;
        }
        if ((i * 2) != total) {
            arr[n - i].next = arr[n - i - 1];
            arr[n - i - 1].next = null;
        }
        return head;
    }

    public ListNode reorderListOptimized(ListNode n) {
        if (n == null || n.next == null || n.next.next == null) {
            return n;
        }
        ListNode middle = getMiddleNode(n);
        ListNode temp2 = reverseList(middle.next);
        middle.next = null;
        ListNode temp1 = n;
        while (temp1 != null && temp2 != null) {
            ListNode temp3 = temp2;
            temp2 = temp2.next;
            temp3.next = temp1.next;
            temp1.next = temp3;
            temp1 = temp3.next;
        }
        return n;
    }

    private ListNode reverseList(ListNode n) {
        if (n == null) return null;
        ListNode pre = null;
        ListNode cur = n;
        ListNode nextn = null;
        while (cur != null) {
            nextn = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nextn;
        }
        return pre;
    }

    private ListNode getMiddleNode(ListNode n) {
        if (n == null) return null;
        ListNode slow = n;
        ListNode fast = n.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast != null)
                fast = fast.next;
        }
        return slow;
    }
}

/*
    There is nothing fancy also in this question.
    Just get middle. and then reverse the 2nd Part.
    then merge the two list.
 */
