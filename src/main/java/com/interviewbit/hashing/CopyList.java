package com.interviewbit.hashing;


import com.interviewbit.linkedlist.RandomListNode;

import java.util.HashMap;
/*
    A linked list is given such that each node contains an additional random pointer which could point to any node in the list or NULL.
*/
public class CopyList {

    public static void main(String[] args) {
        int[] arr = { 10, 15, 20, 25};
        int[] index = {1,2,3,0};
        RandomListNode head = RandomListNode.createLinkedList(arr,index);
        head.printList();
        CopyList obj = new CopyList();
        RandomListNode result = obj.copyRandomList(head);
        result.printList();
    }

    public RandomListNode copyRandomList(RandomListNode head) {

        RandomListNode curr = null;
        RandomListNode rHead = null;

        HashMap<RandomListNode,RandomListNode> maps =
                new HashMap<>();

        while( head != null ){
            RandomListNode temp = null;
            RandomListNode random = null;

            if(maps.containsKey(head)){
                temp = maps.get(head);
            }
            else{
                temp = new RandomListNode(head.label);
                maps.put(head,temp);
            }

            if(head.random != null){
                if(maps.containsKey(head.random)){
                    random = maps.get(head.random);
                }
                else{
                    random = new RandomListNode(head.random.label);
                    maps.put(head.random,random);
                }
            }

            if(curr == null){
                curr = temp;
                rHead = temp;
                curr.random = random;
            }
            else{
                curr.next = temp;
                curr = curr.next;
                curr.random = random;
            }
            head = head.next;
        }
        return rHead;
    }

}




