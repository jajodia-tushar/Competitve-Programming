package com.interviewbit.linkedlist;

public class SortList {

    public static void main(String[] args) {
        ListNode head = ListNode.createLinkedList(5,66,68,42,73,25,84,63,72,20,77,38,8,99,92,49,74,45,30,51,50,95,56,19,31,26,98,67,100,2,24,6,37,69,11,16,61,23,78,27,64,87,3,85,55,22,33,62);
        SortList obj = new SortList();
        obj.sortList(head).printList();
    }

    public ListNode sortList(ListNode A) {

        if(A == null || A.next == null){
            return A;
        }

        ListNode middle = getMiddle(A);
        ListNode middleNext = middle.next;
        middle.next = null;

        ListNode left = sortList(A);
        ListNode right = sortList(middleNext);

        ListNode finalList = merge(left,right);
        return finalList;

    }

    public ListNode merge(ListNode left,ListNode right){

        if(left == null)
            return right;
        if(right == null)
            return left;
        ListNode result = null;
        if(left.val < right.val){
            result = left;
            result.next = merge(left.next,right);
        }
        else{
            result = right;
            right.next = merge(left,right.next);
        }

        return result;
    }

    public ListNode getMiddle(ListNode A){

        ListNode faster = A;
        ListNode slower = A;

        while(faster.next != null && faster.next.next != null){
            faster = faster.next.next;
            slower = slower.next;
        }

        return slower;

    }
}
