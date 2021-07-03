package com.interviewbit.linkedlist;

public class PartitionList {

    public static void main(String[] args) {

        ListNode head = ListNode.createLinkedList(1, 4, 3, 2, 5, 2);
        PartitionList obj = new PartitionList();
        obj.partition(head, 3).printList();

    }

    public ListNode partition(ListNode A, int B) {

        ListNode higherStart = null;
        ListNode higherEnd = null;
        ListNode lowerStart = null;
        ListNode lowerEnd = null;

        ListNode current = A;

        while (current != null) {
            if (current.val >= B) {
                if (higherStart == null) {
                    higherStart = current;
                    higherEnd = current;
                    current = current.next;
                } else {
                    higherEnd.next = current;
                    higherEnd = higherEnd.next;
                    current = current.next;
                    higherEnd.next = null;
                }
            } else {
                if (lowerStart == null)
                    lowerStart = current;

                if (lowerEnd == null) {
                    lowerEnd = current;
                } else {
                    lowerEnd.next = current;
                    lowerEnd = lowerEnd.next;
                }
                current = current.next;

            }
        }

        if (lowerStart == null)
            return A;

        lowerEnd.next = higherStart;
        return lowerStart;
    }

    public ListNode partitionOptimized(ListNode A, int B) {

        ListNode start = new ListNode(0);
        ListNode end = new ListNode(0);

        ListNode l = start;
        ListNode h = end;


        while (A != null) {
            if (A.val < B) {
                l.next = A;
                A = A.next;
                l = l.next;
                l.next = null;
            } else {
                h.next = A;
                A = A.next;
                h = h.next;
                h.next = null;
            }

        }

        l.next = end.next;
        return start.next;
    }
}

/*
    Both the Code is same but the next code seems little clear.
    Try the later one always.
    
    See if you try to do by swapping technique. There are a lot of test cases that are going to
    freak you out.

    So idea is to maintain two list one for the smaller numbers and one for the larger.
    While moving just keep adding values to this list as per the required condition.

    Now at last join this two list and return.
 */
