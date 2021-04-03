package com.interviewbit.stackandqueue;

import java.util.Stack;

public class LargestRectangleInHistogram {

    public static void main(String[] args) {
        int arr[] = {47, 69, 67, 97, 86, 34, 98, 16, 65, 95, 66, 69, 18, 1, 99, 56, 35, 9, 48, 72, 49, 47, 1, 72, 87, 52, 13, 23, 95, 55, 21, 92, 36, 88, 48, 39, 84, 16, 15, 65, 7, 58, 2, 21, 54, 2, 71, 92, 96, 100, 28, 31, 24, 10, 94, 5, 81, 80, 43, 35, 67, 33, 39, 81, 69, 12, 66, 87, 86, 11, 49, 94, 38, 44, 72, 44, 18, 97, 23, 11, 30, 72, 51, 61, 56, 41, 30, 71, 12, 44, 81, 43, 43, 27  };
        LargestRectangleInHistogram obj = new LargestRectangleInHistogram();
        System.out.println(obj.largestRectangleArea(arr));
    }

    public int largestRectangleArea(int[] A) {

        if(A.length == 1)
            return A[0];

        int[] nextSmallestOnRight = new int[A.length];
        int[] nextSmallestOnLeft = new int[A.length];

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < A.length; i++){
            int item = A[i];
            while(!stack.isEmpty() && item <= A[stack.peek()]){
                stack.pop();
            }

            if(stack.isEmpty())
                nextSmallestOnLeft[i] = 0;
            else
                nextSmallestOnLeft[i] = stack.peek();

            stack.push(i);
        }

        stack = new Stack<>();

        for(int i = A.length - 1; i >= 0; i--){
            int item = A[i];
            while(!stack.isEmpty() && item <= A[stack.peek()]){
                stack.pop();
            }

            if(stack.isEmpty())
                nextSmallestOnRight[i] = A.length;
            else
                nextSmallestOnRight[i] = stack.peek();

            stack.push(i);
        }

        int max = Integer.MIN_VALUE;

        for(int i = 0; i < A.length; i++){
            int area = nextSmallestOnRight[i] - nextSmallestOnLeft[i] - 1;
            max = Math.max(max,area*A[i]);
        }

        return max;


    }
}
