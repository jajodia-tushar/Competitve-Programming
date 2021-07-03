package com.interviewbit.linkedlist;

/*
You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8

    342 + 465 = 807
Make sure there are no trailing zeros in the output list
So, 7 -> 0 -> 8 -> 0 is not a valid response even though the value is still 807.
 */
public class AddTwoNumbersAsLists {

    public static void main(String[] args) {
        AddTwoNumbersAsLists obj = new AddTwoNumbersAsLists();
        ListNode l1 = ListNode.createLinkedList(1, 2, 3);
        ListNode l2 = ListNode.createLinkedList(1, 2, 3);

        ListNode result = obj.addTwoNumbers(l1, l2);
        result.printList();
    }

    public ListNode addTwoNumbers(ListNode A, ListNode B) {

        ListNode finalList = null;
        ListNode current = null;
        int carry = 0;

        while (A != null && B != null) {

            int a = A.val;
            int b = B.val;
            int sum = a + b + carry;
            int rem = sum % 10;
            carry = sum / 10;

            if (finalList == null) {
                finalList = new ListNode(rem);
                current = finalList;
            } else {
                current.next = new ListNode(rem);
                current = current.next;
            }
            A = A.next;
            B = B.next;
        }

        if (B != null) {
            while (B != null) {
                int sum = B.val + carry;
                int rem = sum % 10;
                carry = sum / 10;
                current.next = new ListNode(rem);
                current = current.next;
                B = B.next;
            }
        } else {
            while (A != null) {
                int sum = A.val + carry;
                int rem = sum % 10;
                carry = sum / 10;
                current.next = new ListNode(rem);
                current = current.next;
                A = A.next;
            }
        }

        if (carry == 0) {
            return finalList;
        } else {
            current.next = new ListNode(carry);
            return finalList;
        }
    }
}

/*
    Paper Pen stuffs,
    Just know how to clean it.
 */