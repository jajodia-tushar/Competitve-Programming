package com.interviewbit.linkedlist;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; next = null; }

    public static ListNode createLinkedList(int ...arr){

        ListNode head;
        ListNode pre;

        head = new ListNode(arr[0]);
        pre = head;

        for(int i = 1; i < arr.length; i++){
            pre.next = new ListNode(arr[i]);
            pre = pre.next;
        }
        return head;
    }

    public void printList(){
        ListNode head = this;

        while(head.next != null){
            System.out.print(head.val+" --> ");
            head = head.next;
        }
        System.out.println(head.val);
    }

}