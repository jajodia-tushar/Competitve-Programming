package com.interviewbit.heapsandmaps;

import com.interviewbit.linkedlist.ListNode;

import java.util.*;

/*
    Merge k sorted linked lists and return it as one sorted list.
    Example :
    1 -> 10 -> 20
    4 -> 11 -> 13
    3 -> 8 -> 9
    will result in
    1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20

 */

public class MergeKSortedLists {

    public static void main(String[] args) {

        MergeKSortedLists obj = new MergeKSortedLists();

        ArrayList<ListNode> list = new ArrayList<>();
        list.add(ListNode.createLinkedList(1, 10, 20));
        list.add(ListNode.createLinkedList(4, 11, 13));
        list.add(ListNode.createLinkedList(3, 8, 9));
        ListNode listNode = obj.mergeKLists(list);
        listNode.printList();


    }

    public ListNode mergeKLists(ArrayList<ListNode> a) {
        ListNode result = null;
        ListNode curr = null;
        PriorityQueue<ListNode> heap =
                new PriorityQueue<>(Comparator.comparing(x -> x.val));
        for (ListNode node : a) {
            while (node != null) {
                heap.add(node);
                node = node.next;
            }
        }
        while (!heap.isEmpty()) {
            ListNode inHeap = heap.poll();
            if (curr == null) {
                curr = new ListNode(inHeap.val);
                result = curr;
            } else {
                curr.next = new ListNode(inHeap.val);
                curr = curr.next;
            }
        }
        return result;
    }

    public ListNode mergeKListsOptimized(ArrayList<ListNode> A) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode node : A) {
            queue.add(node);
        }
        ListNode curr = new ListNode(-1);
        ListNode result = curr;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            curr.next = node;
            curr = curr.next;
            if (node.next != null)
                queue.add(node.next);
        }
        return result.next;
    }
}

/*
    Simple and Easy technique to solve this problem is to add all the nodes in the heap and
    keep popping and create the link.

    The Smart way is, You are given LinkedList.
    So you can add the head (1) from all the list.
    And pop.
    Once you pop you add the next item in that list by list.next;

    Isn't this Amazing ?


 */
