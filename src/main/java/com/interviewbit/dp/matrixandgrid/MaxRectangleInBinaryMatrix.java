package com.interviewbit.dp.matrixandgrid;


import java.util.Stack;

/*
Maximum Size Rectangle of All 1's Dynamic Programming
Given a 2D binary matrix filled with 0’s and 1’s, find the largest rectangle containing all ones and return its area.
Bonus if you can solve it in O(n^2) or less.

Example :
A : [  1 1 1
       0 1 1
       1 0 0
    ]
Output : 4
As the max area rectangle is created by the 2x2 rectangle created by (0,1), (0,2), (1,1) and (1,2)

 */
public class MaxRectangleInBinaryMatrix {

    public static void main(String[] args) {

        MaxRectangleInBinaryMatrix obj = new MaxRectangleInBinaryMatrix();
        int[][] ints = {{1, 1}, {1, 1}};
        int result = obj.maximalRectangle(ints);
        System.out.println(result);

    }

    public int maximalRectangle(int[][] A) {

        int row = A.length;
        int col = A[0].length;

        int result = largestRectangleArea(A[0]);

        for (int i = 1; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (A[i][j] == 1)
                    A[i][j] += A[i - 1][j];
            }
            result = Math.max(result, largestRectangleArea(A[i]));
        }

        return result;

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
            int area = nextSmallestOnRight[i] - nextSmallestOnLeft[i] - 1;
            max = Math.max(max, area * A[i]);
        }
        return max;
    }


}
