package com.interviewbit.linkedlist;

public class KReverseLinkedList {

    public static void main(String[] args) {

        ListNode head = ListNode.createLinkedList(1,2,3,4,5,6,7,8,9,10,11,12);
        KReverseLinkedList obj = new KReverseLinkedList();
        ListNode finalList = obj.reverseLinkedList(head,4);
        finalList.printList();

    }

    public ListNode reverseList(ListNode A, int B) {
        ListNode current = A;
        ListNode finalHead = null;
        ListNode previous = null;

        while(current != null && current.next != null){
            ListNode firstNode = null;
            for(int i = 0; i < B; i++){
                if(firstNode == null) {
                    firstNode = current;
                }

                ListNode temp = current.next;
                current.next = previous;
                previous = current;
                current = temp;
            }

            if(finalHead == null) {
                finalHead = previous;
            }
            ListNode temp = current;
            int j = B;
            while(j > 1 && temp != null && temp.next != null){
                temp = temp.next;
                j--;
            }
            firstNode.next = temp;
            previous = null;
        }
       return finalHead;
    }

    public ListNode reverseLinkedList(ListNode A, int B){

        int c=0;
        ListNode prev=null;
        ListNode next=null;
        ListNode current=A;
        while(current!=null && c<B)
        {
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
            c++;
        }
        if(current!=null)
        {
            A.next=reverseLinkedList(current, B);
        }

        return prev;
    }
}
