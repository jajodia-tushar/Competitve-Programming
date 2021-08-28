package com.interviewbit.arrays;
/*

Problem Description
Given an array A of integers, find the maximum of j - i subjected to the constraint of A[i] <= A[j].
Input Format
First and only argument is an integer array A.
Output Format
Return an integer denoting the maximum value of j - i;
Example Input
Input 1:
A = [3, 5, 4, 2]
Example Output
Output 1:
 2
Example Explanation
Explanation 1:
 Maximum value occurs for pair (3, 4).
 */

import java.util.Arrays;
import java.util.Comparator;

public class MaxDistance {

    public static void main(String[] args) {

        MaxDistance obj = new MaxDistance();
        int[] ints = {3, 5, 4, 2};
        int result = obj.maximumGap(ints);
        System.out.println(result);
    }

    public int maximumGap(final int[] A) {

        int n = A.length;
        Point[] points = new Point[n];

        for (int i = 0; i < n; i++) {
            points[i] = new Point(i, A[i]);
        }
        Arrays.sort(points, Comparator.comparing(a -> a.value));

        int[] maxJ = new int[n];
        maxJ[n - 1] = points[n - 1].index;

        for (int i = n - 2; i >= 0; i--) {
            maxJ[i] = Math.max(maxJ[i + 1], points[i].index);
        }

        int maxDiff = 0;

        for (int i = 0; i < n - 1; i++) {
            int diff = maxJ[i + 1] - points[i].index;
            maxDiff = Math.max(diff, maxDiff);
        }
        return maxDiff;
    }


    class Point {
        public int index;
        public int value;

        public Point(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}

/*

    The Question seems easy but it is not really easy.
    They are expecting a O(nLog(n)) solution.

    Trivial solution would be to consider every pair by looping for
    with two for loops.

   Now since we are looking for nLog(n) solution we must
   look for Sorting.
   So Will Directly sorting work ?
   No.
   Answer requires the Diff of indexes so if we sort without storing
   the indexes we won't be able to find the solution.

   Now since the Array is sorted the condition A[i] <= A[j] would really be
   solved. Every number on the right are eligible.

    But we need max value of j - i.
    Since j can be any number on right
    so we can have a suffix array to store the maximum index in the sorted
    array.

    Not finally we can just iterate in the sorted array and for i we have i + 1;
    and in the suffix array we have the maximum value of the index there
    so we can find the max for all just pair in O(n) time.

 */