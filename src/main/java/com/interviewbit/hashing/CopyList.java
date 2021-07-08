package com.interviewbit.hashing;


import com.interviewbit.linkedlist.RandomListNode;

import java.util.HashMap;

/*
    A linked list is given such that each node contains an additional random pointer which could point to any node in the list or NULL.
    Return a deep copy of the list.
    Example
    Given list
        1 -> 2 -> 3
    with random pointers going from
        1 -> 3
        2 -> 1
        3 -> 1
    You should return a deep copy of the list. The returned answer should not contain the same node as the original list, but a copy of them. The pointers in the returned list should not link to any node in the original input list.
*/
public class CopyList {

    public static void main(String[] args) {
        int[] arr = {10, 15, 20, 25};
        int[] index = {1, 2, 3, 0};
        RandomListNode head = RandomListNode.createLinkedList(arr, index);
        head.printList();
        CopyList obj = new CopyList();
        RandomListNode result = obj.copyRandomListOptimized(head);
        result.printList();
    }

    public RandomListNode copyRandomList(RandomListNode head) {

        RandomListNode curr = null;
        RandomListNode rHead = null;

        HashMap<RandomListNode, RandomListNode> maps =
                new HashMap<>();

        while (head != null) {
            RandomListNode temp = null;
            RandomListNode random = null;

            if (maps.containsKey(head)) {
                temp = maps.get(head);
            } else {
                temp = new RandomListNode(head.label);
                maps.put(head, temp);
            }

            if (head.random != null) {
                if (maps.containsKey(head.random)) {
                    random = maps.get(head.random);
                } else {
                    random = new RandomListNode(head.random.label);
                    maps.put(head.random, random);
                }
            }

            if (curr == null) {
                curr = temp;
                rHead = temp;
                curr.random = random;
            } else {
                curr.next = temp;
                curr = curr.next;
                curr.random = random;
            }
            head = head.next;
        }
        return rHead;
    }

    public RandomListNode copyRandomListX(RandomListNode head) {

        HashMap<RandomListNode, RandomListNode> oldNewMapping = new HashMap<>();

        RandomListNode result = null;
        RandomListNode resultSave = null;

        while (head != null) {

            RandomListNode newNode = getNewNode(oldNewMapping, head);
            RandomListNode randomNode = getNewNode(oldNewMapping, head.random);

            newNode.random = randomNode;

            if (resultSave == null) {
                result = newNode;
                resultSave = newNode;
            } else {
                result.next = newNode;
                result = result.next;
            }
            head = head.next;
        }
        return resultSave;
    }


    public RandomListNode getNewNode(HashMap<RandomListNode, RandomListNode> oldNewMapping,
                                     RandomListNode head) {

        if (head == null) return null;

        RandomListNode newNode = null;
        if (oldNewMapping.containsKey(head)) {
            newNode = oldNewMapping.get(head);
        } else {
            newNode = new RandomListNode(head.label);
            oldNewMapping.put(head, newNode);
        }
        return newNode;
    }

    public RandomListNode copyRandomListOptimized(RandomListNode head) {

        RandomListNode curr = head;

        while (curr != null) {
            RandomListNode newNode = new RandomListNode(curr.label);
            RandomListNode nextNode = curr.next;
            newNode.next = nextNode;
            curr.next = newNode;
            curr = nextNode;
        }

        RandomListNode A = head;
        RandomListNode ADash = A.next;

        while (ADash != null && ADash.next != null) {
            RandomListNode ANext = ADash.next;
            ADash.next = ANext.next;
            ADash.random = A.random == null ? null : A.random.next;
            A = ANext;
            ADash = A.next;
        }
        ADash.random = A.random.next;
        return head.next;
    }
}

/*
    Good Question for hashing.
    Use Map to store the mapping for old and new Nodes.

    Just make sure not to use node.label as Mapping key.
    Use the obj or hashcode itself.


    Go To Copy to read the optimized and Amazing Technique.
    Without Using HashMap as well.
 */


