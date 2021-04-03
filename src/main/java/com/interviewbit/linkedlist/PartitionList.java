package com.interviewbit.linkedlist;

public class PartitionList {

    public static void main(String[] args) {

        ListNode head = ListNode.createLinkedList(1,4,3,2,5,2);
        PartitionList obj = new PartitionList();
        obj.partition(head,3).printList();

    }

    public ListNode partition(ListNode A, int B) {

        ListNode higherStart = null;
        ListNode lowerEnd = null;
        ListNode current = A;
        ListNode previous = null;
        ListNode lowerStart = null;

        while(current != null){
            if(current.val < B){
                if(lowerStart == null)
                    lowerStart = current;

                if(lowerEnd == null){
                    lowerEnd = current;
                }
                else{
                    lowerEnd.next = current;
                    lowerEnd = lowerEnd.next;
                }
                if(previous != null)
                    previous.next = current.next;
                current = current.next;
            }
            else{
                if(higherStart == null)
                    higherStart = current;
                previous = current;
                current = current.next;
            }
        }

        lowerEnd.next = higherStart;
        return lowerStart;
    }
}
