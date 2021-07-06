package com.interviewbit.stackandqueue;

import java.util.Stack;

/*
Given an array of integers A of size N. A represents a histogram i.e A[i] denotes height of

the ith histogram’s bar. Width of each bar is 1.

Largest Rectangle in Histogram: Example 1

Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].

Largest Rectangle in Histogram: Example 2

The largest rectangle is shown in the shaded area, which has area = 10 unit.

Find the area of largest rectangle in the histogram.




Input Format

The only argument given is the integer array A.
Output Format

Return the area of largest rectangle in the histogram.
For Example

Input 1:
    A = [2, 1, 5, 6, 2, 3]
Output 1:
    10
    Explanation 1:
        The largest rectangle is shown in the shaded area, which has area = 10 unit.
 */
public class LargestRectangleInHistogram {

    public static void main(String[] args) {
        int arr[] = {90, 58, 69, 70, 82, 100, 13, 57, 47, 18};
        LargestRectangleInHistogram obj = new LargestRectangleInHistogram();
        System.out.println(obj.largestRectangleArea(arr));
    }

    public int largestRectangleArea(int[] A) {

        if (A.length == 1)
            return A[0];


        int[] nextSmallestOnRight = new int[A.length];
        int[] nextSmallestOnLeft = new int[A.length];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < A.length; i++) {
            int item = A[i];
            while (!stack.isEmpty() && item <= A[stack.peek()]) {
                stack.pop();
            }

            if (stack.isEmpty())
                nextSmallestOnLeft[i] = -1;
            else
                nextSmallestOnLeft[i] = stack.peek();

            stack.push(i);
        }

        stack = new Stack<>();

        for (int i = A.length - 1; i >= 0; i--) {
            int item = A[i];
            while (!stack.isEmpty() && item <= A[stack.peek()]) {
                stack.pop();
            }

            if (stack.isEmpty())
                nextSmallestOnRight[i] = A.length;
            else
                nextSmallestOnRight[i] = stack.peek();

            stack.push(i);
        }

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < A.length; i++) {
            // System.out.println(A[i]+" --> "+nextSmallestOnRight[i]+" -- " + " -- "+ nextSmallestOnLeft[i]);
            int area = nextSmallestOnRight[i] - nextSmallestOnLeft[i] - 1;
            max = Math.max(max, area * A[i]);
        }

        return max;


    }
}

/*
    This one is very famous Question and is similar to the one already done MAXSPROD.
    Just here we have to find closestSmallerOnleft and right
    Now for every element we know that this particular height can be used on
    right[i] - left[i] - 1 width ---> Logical right ?

    You can do this one.

 */
