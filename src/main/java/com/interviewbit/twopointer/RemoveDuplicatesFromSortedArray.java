package com.interviewbit.twopointer;

import java.util.ArrayList;

/*
Remove duplicates from Sorted Array
Given a sorted array, remove the duplicates in place such that each element appears only once and return the new length.
Note that even though we want you to return the new length, make sure to change the original array as well in place
Do not allocate extra space for another array, you must do this in place with constant memory.
 Example:
Given input array A = [1,1,2],
Your function should return length = 2, and A is now [1,2].
 */

public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray obj = new RemoveDuplicatesFromSortedArray();
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(5000);
        arr.add(5000);
        arr.add(5000);
        System.out.println(obj.removeDuplicates(arr));
    }

    public int removeDuplicates(ArrayList<Integer> a) {

        int first = 0;
        int next = 1;
        int index = 1;
        while (next < a.size()) {

            if (a.get(first).equals(a.get(next))) {
                a.set(next, Integer.MAX_VALUE);
                next++;
            } else {
                a.set(index, a.get(next));
                first = next;
                next++;
                index++;
            }
        }
        return index;

    }
}
/*
    Read the Question Properly
    You also have to delete the elements in place.
    Or You can say that you have to take the repeated elements behind.

    If you see repeated Numbers can you just take one from the series of these repeated number and
    put it somewhere. Can you do this for all the numbers.
    Can you avoid using extra space and use the same array as extra space.

 */