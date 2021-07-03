package com.interviewbit.stackandqueue;

import java.util.Stack;

public class LargestRectangleInHistogram {

    public static void main(String[] args) {
        int arr[] = {90, 58, 69, 70, 82, 100, 13, 57, 47, 18  };
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
                nextSmallestOnLeft[i] = -1;
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
            // System.out.println(A[i]+" --> "+nextSmallestOnRight[i]+" -- " + " -- "+ nextSmallestOnLeft[i]);
            int area = nextSmallestOnRight[i] - nextSmallestOnLeft[i] - 1;
            max = Math.max(max,area*A[i]);
        }

        return max;


    }
}
