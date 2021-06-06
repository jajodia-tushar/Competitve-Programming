package com.interviewbit.arrays;

public class MaximumSumSquareSubMatrix {

    public static void main(String[] args) {

        MaximumSumSquareSubMatrix obj = new MaximumSumSquareSubMatrix();
        int[][] ints = {{1, 1, 1, 1, 1}, {2, 2, 2, 2, 2}, {3, 8, 6, 7, 3}, {4, 4, 4, 4, 4}, {5, 5, 5, 5, 5}};
        int result = obj.solve(ints, 3);
        System.out.println(result);


    }

    public int solve(int[][] A, int B) {

        int r = A.length;
        int c = A[0].length;

        int[][] dp = new int[r + 1][c + 1];

        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                dp[i][j] = A[i - 1][j - 1] + dp[i - 1][j] + dp[i][j - 1]
                        - dp[i - 1][j - 1];
            }
        }

        int result = Integer.MIN_VALUE;
        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                if (i >= B && j >= B) {
                    int currentSum = dp[i][j] - dp[i - B][j] -
                            dp[i][j - B] + dp[i - B][j - B];
                    result = Math.max(result, currentSum);
                }
            }
        }
        return result;
    }
}

/*
    This is one of the classical DP matrix problem.
    If we calculate the Sum every time for all the eligible matrices than
    it will return in TLE.

    So, The Idea will be pre calculate the sum of the rows and columns
    In the code look at the dp initialization value

    At a particular cell we are storing the value of sum of matrix from (0,0) to (i,j)
    now while iterating or calculating the value if the current iteration meets the criteria then we are calculating
    the sum of the sub matrix only.


 */