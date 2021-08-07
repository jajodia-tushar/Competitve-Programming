package com.interviewbit.dp;

public class GoldMineProblem {
    public static void main(String[] args) {

        GoldMineProblem obj = new GoldMineProblem();
        int[][] M = {{1, 3, 1, 5},
                {2, 2, 4, 1},
                {5, 0, 2, 3},
                {0, 6, 1, 2}};

        int result = obj.maxGold(M.length, M[0].length, M);
        System.out.println(result);
    }

    int maxGold(int n, int m, int M[][]) {
        int[][] dp = new int[n][m];

        int result = Integer.MIN_VALUE;
        for (int j = m - 1; j >= 0; j--) {
            for (int i = n - 1; i >= 0; i--) {
                if (j == m - 1) {
                    dp[i][j] = M[i][j];
                } else if (i == n - 1 && i == 0) {
                    dp[i][j] = M[i][j] + dp[i][j + 1];
                } else if (i == n - 1) {
                    dp[i][j] = M[i][j] + Math.max(dp[i][j + 1], dp[i - 1][j + 1]);
                } else if (i == 0) {
                    dp[i][j] = M[i][j] + Math.max(dp[i][j + 1], dp[i + 1][j + 1]);
                } else {
                    dp[i][j] = M[i][j] + Math.max(dp[i][j + 1], Math.max(dp[i + 1][j + 1], dp[i - 1][j + 1]));
                }
                result = Math.max(result, dp[i][j]);
            }
        }

        return result;
    }
}
