package com.interviewbit.linkedlist;

/*
Given a singly linked list, determine if its a palindrome. Return 1 or 0 denoting if its a palindrome or not, respectively.
Notes:
Expected solution is linear in time and constant in space.
For example,

List 1-->2-->1 is a palindrome.
List 1-->2-->3 is not a palindrome.
 */
public class IsPalindrome {

    public static void main(String[] args) {

        IsPalindrome obj = new IsPalindrome();
        ListNode linkedList = ListNode.createLinkedList(1, 2, 3, 4, 5, 6, 5, 4, 3, 2, 1);
        ListNode result = obj.reverse(linkedList);
        result.printList();
    }

    public int lPalin(ListNode A) {

        if (A == null)
            return 1;

        ListNode temp = new ListNode(A.val);
        int n = 1;
        ListNode org = A.next;
        while (org != null) {
            ListNode x = new ListNode(org.val);
            x.next = temp;
            temp = x;
            n++;
            org = org.next;
        }

        while (n > 0) {
            if (A.val != temp.val)
                return 0;
            A = A.next;
            temp = temp.next;
            n--;
        }

        return 0;


    }

    public int lPalinOptimized(ListNode A) {

        if (A == null || A.next == null) return 1;
        ListNode mid = getMiddle(A);
        ListNode midNext = mid.next;
        mid.next = null;
        mid = midNext;
        mid = reverse(mid);
        while (mid != null) {
            if (A.val != mid.val) return 0;
            mid = mid.next;
            A = A.next;
        }
        return 1;

    }

    public ListNode reverse(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode pre = null;
        ListNode curr = head;
        ListNode next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    public ListNode getMiddle(ListNode A) {
        if (A == null) return A;
        ListNode slow = A;
        ListNode fast = A.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
/*
    If Extra Space is allowed then this question becomes very easy.
    You can create a reverse of the linked list easily while traversing by adding in the first place.


    If you don't have the advantage of space. You can traverse till Mid point and reverse the send half of the array.
    Now what you can do is you can simply iterate over the array and tell if it is palindrome or not.
    Look in the Optimized version.

 */

