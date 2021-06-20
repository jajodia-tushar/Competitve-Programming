package com.interviewbit.binarysearch;


import com.interviewbit.math.SortedPermutationRank;
import com.interviewbit.utils.ArrayUtils;

import java.util.ArrayList;

/*
Problem Description

Given a sorted array A and a target value B, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.



**Problem Constraints**
1 <= |A| <= 100000

1 <= B <= 109



**Input Format**
First argument is array A.

Second argument is integer B.



**Output Format**
Return an integer, the answer to the problem.



**Example Input**
Input 1:

 A = [1, 3, 5, 6]
B = 5
Input 2:

 A = [1, 3, 5, 6]
B = 2


**Example Output**
Output 1:

 2
Output 2:

 1


**Example Explanation**
Explanation 1:

 5 is found at index 2.
Explanation 2:

 2 will be inserted ar index 1.
 */
public class SortedInsertPosition {
    public static void main(String[] args) {
        SortedInsertPosition obj = new SortedInsertPosition();
        ArrayList<Integer> arrayList = ArrayUtils.asArrayList(1, 3, 5, 6);
        int result = obj.searchInsert(arrayList, 5);
        System.out.println(result);
    }

    public int searchInsert(ArrayList<Integer> a, int b) {

        int n = a.size();
        int low = 0;
        int high = n - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;
            int midItem = a.get(mid);

            if (midItem < b) {
                low = mid + 1;
            } else if (midItem > b) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return high + 1;
    }
}

/*
    If found it is easy if not found remember that the location will be pointed by either low or high + 1
    in all the cases.

 */
