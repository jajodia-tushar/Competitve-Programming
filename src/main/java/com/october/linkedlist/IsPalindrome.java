package com.october.linkedlist;

public class IsPalindrome {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(1);

        listNode1.next = listNode2;
        listNode2.next = listNode3;

        IsPalindrome obj = new IsPalindrome();
        System.out.println(obj.lPalin(listNode1));

    }

    public int lPalin(ListNode A) {

        if(A == null)
            return 1;

        ListNode temp = new ListNode(A.val);
        int n = 1;
        ListNode org = A.next;
        while(org != null){
            ListNode x = new ListNode(org.val);
            x.next = temp;
            temp = x;
            n++;
            org = org.next;
        }

        while(n > 0){
            if(A.val != temp.val)
                return 0;
            A = A.next;
            temp = temp.next;
            n--;
        }

        return 0;



    }
}

 class ListNode {
     public int val;
     public ListNode next;
     ListNode(int x) { val = x; next = null; }
 }
