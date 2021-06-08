package com.interviewbit.math;

/*

A robot is located at the top-left corner of an A x B grid (marked ‘Start’ in the diagram below).
The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked ‘Finish’ in the diagram below).
How many possible unique paths are there?
Note: A and B will be such that the resulting answer fits in a 32 bit signed integer.

 */
public class GridUniquePaths {

    public static void main(String[] args) {
        GridUniquePaths obj = new GridUniquePaths();
        int result = obj.uniquePaths(5, 10);
        System.out.println(result);
    }

    public int uniquePaths(int A, int B) {
        A--;
        B--;
        if (A == 0 || B == 0) return 1;

        long denominator = fact(B);
        int sum = A + B;
        long numerator = 1;

        for (; sum > A; sum--) {
            numerator = (numerator * sum);
        }

        return (int) (numerator / denominator);


    }

    public long fact(int A) {
        long ans = 1;
        for (int i = 2; i <= A; i++) {
            ans = ans * i;
        }
        return ans;
    }
}

/*
    There is nothing really much in this question as well.
    You will need to take total of A + B - 2 Steps.
    A - 1 Steps rightward and B - 1 Steps downward.

    So essentially you have to choose A - 1 Steps or B - 1 steps from A + B - 2
    and the other remaining steps will fall in order ( If A - 1 then rem is B - 1 and vice versa )

    So It is equal to

    (A + B - 2)Combination(A - 1)

    Now you just have to solve this.
    If you take factorial of A - 1 and B - 1 and multiply it and then divide by factorial of (A + B - 2)
    then you will result in overflow as well.
    So just cancel the common as you do in pen paper.



 */
