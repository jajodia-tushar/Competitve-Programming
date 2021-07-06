package com.interviewbit.stackandqueue;

import java.util.Stack;

/*
Problem Description

You are given an array A containing N integers. The special product of each ith integer in this array is defined as the product of the following:

LeftSpecialValue: For an index i, it is defined as the index j such that A[j]>A[i] and (i>j). If multiple A[j]'s are present in multiple positions, the LeftSpecialValue is the maximum value of j.
RightSpecialValue: For an index i, it is defined as the index j such that A[j]>A[i] and (j>i). If multiple A[j]'s are present in multiple positions, the RightSpecialValue is the minimum value of j.
Write a program to find the maximum special product of any integer in the array.

NOTE:  As the answer can be large, output your answer modulo 109 + 7.



Problem Constraints
1 <= N <= 105

1 <= A[i] <= 109



Input Format
First and only argument is an integer array A.



Output Format
Return an integer denoting the maximum special product of any integer.



Example Input
Input 1:

 A = [1, 4, 3, 4]
Input 2:

 A = [10, 7, 100]


Example Output
Output 1:

 3
Output 2:

 0


Example Explanation
Explanation 1:

 For A[2] = 3, LeftSpecialValue is 1 and RightSpecialValue is 3.
 So, the ans is 1*3 = 3.

Explanation 2:

 There is not any integer having maximum special product > 0. So, the ans is 0.
 */
public class MAXSPPROD {

    public static void main(String[] args) {
        MAXSPPROD obj = new MAXSPPROD();
        int[] ints = {1, 4, 3, 4};
        int result = obj.maxSpecialProduct(ints);
        System.out.println(result);
    }

    public int maxSpecialProduct(int[] A) {

        int[] left = getLeft(A);
        int[] right = getRight(A);
        long maxValue = 0;
        for (int i = 0; i < A.length; i++) {
            if (left[i] != -1 || right[i] != -1)
                maxValue = Math.max(maxValue, (long) left[i] * (long) right[i]);
        }
        return (int) (maxValue % 1000000007);
    }


    public int[] getLeft(int[] A) {

        int n = A.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        result[0] = -1;
        int i = 1;
        stack.push(0);

        while (i < n) {
            while (!stack.isEmpty() && A[stack.peek()] <= A[i]) {
                stack.pop();
            }

            if (stack.isEmpty())
                result[i] = -1;
            else
                result[i] = stack.peek();

            stack.push(i);
            i++;
        }
        return result;
    }

    public int[] getRight(int[] A) {

        int n = A.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        result[n - 1] = -1;
        int i = n - 2;
        stack.push(n - 1);

        while (i >= 0) {
            while (!stack.isEmpty() && A[stack.peek()] <= A[i]) {
                stack.pop();
            }

            if (stack.isEmpty())
                result[i] = 0;
            else
                result[i] = stack.peek();

            stack.push(i);
            i--;
        }
        return result;
    }

}

/*
    Whenever there is a requirement to find out the closest minimum or maximum,
    remember stack would come to rescue.

    So now you know that you just have to store this information for left and right side
    and find the max multiple value.

    Remember to mod properly.

 */