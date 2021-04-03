package com.interviewbit.linkedlist;

public class RandomListNode {

    public int label;
    public RandomListNode next, random;
    public RandomListNode(int x) { this.label = x; }

    public static RandomListNode createLinkedList(int[] arr,int[] index){


        RandomListNode[] randomListNodesArray = new RandomListNode[arr.length];
        RandomListNode head = null;
        for(int i = 0; i < arr.length; i++){
            randomListNodesArray[i] = new RandomListNode(arr[i]);
            if( head == null){
                head = randomListNodesArray[i];
            }
            else{
                randomListNodesArray[i-1].next = randomListNodesArray[i];
            }
        }

        for(int i = 0; i < index.length; i++) {
            randomListNodesArray[i].random = randomListNodesArray[index[i]];
        }
        return head;
    }

    public void printList(){
        RandomListNode head = this;

        while(head.next != null){
            System.out.print(head.label+" -- "+ (head.random != null ? head.random.label : 0)+" --> ");
            head = head.next;
        }
        System.out.println(head.label+" -- "+(head.random != null ? head.random.label : 0)+" --> ");
    }
}
