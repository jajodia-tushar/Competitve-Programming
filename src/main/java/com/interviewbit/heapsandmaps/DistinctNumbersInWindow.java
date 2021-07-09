package com.interviewbit.heapsandmaps;

import com.interviewbit.utils.ArrayUtils;

import java.util.*;

/*
Problem Description

You are given an array of N integers, A1, A2 ,..., AN and an integer B. Return the of count of distinct numbers in all windows of size B.

Formally, return an array of size N-B+1 where i'th element in this array contains number of distinct elements in sequence Ai, Ai+1 ,..., Ai+B-1.

NOTE: if B > N, return an empty array.



Input Format
First argument is an integer array A
Second argument is an integer B.



Output Format
Return an integer array.



Example Input
Input 1:

 A = [1, 2, 1, 3, 4, 3]
 B = 3
Input 2:

 A = [1, 1, 2, 2]
 B = 1


Example Output
Output 1:

 [2, 3, 3, 2]
Output 2:

 [1, 1, 1, 1]


Example Explanation
Explanation 1:

 A=[1, 2, 1, 3, 4, 3] and B = 3
 All windows of size B are
 [1, 2, 1]
 [2, 1, 3]
 [1, 3, 4]
 [3, 4, 3]
 So, we return an array [2, 3, 3, 2].
Explanation 2:

 Window size is 1, so the output array is [1, 1, 1, 1].
 */
public class DistinctNumbersInWindow {

    public static void main(String[] args) {

        DistinctNumbersInWindow obj = new DistinctNumbersInWindow();
        int[] ints = ArrayUtils.asArrays(1, 2, 1, 3, 4, 3);
        int[] result = obj.dNums(ints, 3);
        ArrayUtils.printArray(result);
    }

    public int[] dNums(int[] A, int B) {

        int n = A.length;
        int[] result = new int[n - B + 1];

        Map<Integer, Integer> maps = new HashMap<>();

        for (int i = 0; i < B; i++) {
            maps.put(A[i], i);
        }
        int i = 0;
        for (; i < result.length - 1; i++) {
            result[i] = maps.size();
            maps.put(A[i + B], i + B);
            if (maps.get(A[i]) == i) {
                maps.remove(A[i]);
            }
        }
        result[i] = maps.size();
        return result;
    }

    public int[] dNumsDiffApproach(int[] A, int B) {

        int n = A.length;
        int[] result = new int[n - B + 1];

        int start = 0;
        int end = 0;
        Map<Integer, Integer> maps = new HashMap<>();

        while (end < n) {
            maps.put(A[end], maps.getOrDefault(A[end], 0) + 1);
            result[start] = maps.size();
            if (end >= B - 1) {

                if (maps.containsKey(A[start])) {
                    int value = maps.get(A[start]);
                    if (value == 1) {
                        maps.remove(A[start]);
                    } else {
                        value -= 1;
                        maps.put(A[start], value);
                    }
                }
                start++;
            }
            end++;
        }
        return result;
    }

    public int[] dNumsOptimized(int[] A, int B) {

        int n = A.length;
        int[] result = new int[n - B + 1];

        int start = 0;
        int end = 0;
        Map<Integer, Integer> maps = new HashMap<>();

        while (end < n) {
            maps.put(A[end], end);
            result[start] = maps.size();
            if (end >= B - 1) {
                if (maps.get(A[start]) == start) {
                    maps.remove(A[start]);
                }
                start++;
            }
            end++;
        }
        return result;
    }
}

/*
    Idea is simple, You add all the numbers in Map with frequency maintaining the window size
    equal to B.
    If you cross the size of the window size start removing items from Map.
    At all time the size of the Maps will give you the unique numbers in current window size.
    Take care of repeated numbers when you remove them.
    If there are multiple Number in the previous window when  you are moving out of the window
    don't complete remove the element, remove only if it's frequency is 1.
 */

