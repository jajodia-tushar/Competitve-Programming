package com.interviewbit.nonlinear.graph;

import com.interviewbit.linkedlist.ListNode;
import com.interviewbit.nonlinear.util.TreeNode;

public class ConvertSortedListToBinarySearchTree {

    public static void main(String[] args) {

        ConvertSortedListToBinarySearchTree obj = new ConvertSortedListToBinarySearchTree();
        ListNode linkedList = ListNode.createLinkedList(1, 4, 8,10);

        TreeNode treeNode = obj.sortedListToBST(linkedList);
        TreeNode.inOrderPrint(treeNode);
    }

    public TreeNode sortedListToBST(ListNode a) {

        if( a == null) return null;

        ListNode mid = getMid(a);
        TreeNode root = new TreeNode(mid.val);

        if( mid != a){
            root.left = sortedListToBST(a);
        }
        root.right = sortedListToBST(mid.next);

        return root;
    }


    public ListNode getMid(ListNode node){

        if( node == null || node.next == null) return node;
        ListNode fast = node.next;
        ListNode slow = node;
        ListNode preSlow = null;

        while( fast != null && fast.next != null){
            fast = fast.next.next;
            preSlow = slow;
            slow = slow.next;
        }
        if( preSlow != null) preSlow.next = null;
        return slow;
    }
}
