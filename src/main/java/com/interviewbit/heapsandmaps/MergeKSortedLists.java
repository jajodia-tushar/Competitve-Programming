package com.interviewbit.heapsandmaps;

import com.interviewbit.linkedlist.ListNode;

import java.util.*;

public class MergeKSortedLists {

    public static void main(String[] args) {

        MergeKSortedLists obj = new MergeKSortedLists();

        ArrayList<ListNode> list = new ArrayList<>();
        list.add(ListNode.createLinkedList(1,10,20));
        list.add(ListNode.createLinkedList(4,11,13));
        list.add(ListNode.createLinkedList(3,8,9));
        ListNode listNode = obj.mergeKLists(list);
        listNode.printList();


    }

    public ListNode mergeKLists(ArrayList<ListNode> a) {

        ListNode result = null;
        ListNode curr = null;

        PriorityQueue<ListNode> heap =
                new PriorityQueue<>(Comparator.comparing(x -> x.val));

        for(ListNode node : a){
            while(node != null){
                heap.add(node);
                node = node.next;
            }
        }

        while(!heap.isEmpty()){
            ListNode inHeap = heap.poll();

            if(curr == null){
                curr = new ListNode(inHeap.val);
                result = curr;
            }
            else{
                curr.next = new ListNode(inHeap.val);
                curr = curr.next;
            }
        }

        return result;
    }
}
