package com.interviewbit.dp.matrixandgrid;

import com.interviewbit.utils.ArrayUtils;

public class QueenAttack {

    public static void main(String[] args) {
        QueenAttack obj = new QueenAttack();
        String[] strArr = {"010", "100", "001"};
        int[][] result = obj.queenAttack(strArr);
        ArrayUtils.printArray(result);
    }

    public int[][] queenAttack(String[] A) {

        int n = A.length;
        int m = A[0].length();

        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            String str = A[i];
            for (int j = 0; j < m; j++) {
                if (str.charAt(j) == '1') {
                    //row
                    for (int k = j + 1; k < m; k++) {
                        dp[i][k] += 1;
                        if (str.charAt(k) == '1') break;
                    }

                    for (int k = j - 1; k >= 0; k--) {
                        dp[i][k] += 1;
                        if (str.charAt(k) == '1') break;
                    }
                    //column
                    for (int k = i + 1; k < n; k++) {
                        dp[k][j] += 1;
                        if (A[k].charAt(j) == '1') break;
                    }
                    for (int k = i - 1; k >= 0; k--) {
                        dp[k][j] += 1;
                        if (A[k].charAt(j) == '1') break;
                    }
                    //diagonal
                    for (int k = i + 1, l = j + 1; k < n && l < m; k++, l++) {
                        dp[k][l] += 1;
                        if (A[k].charAt(l) == '1') break;
                    }
                    for (int k = i - 1, l = j - 1; k >= 0 && l >= 0; k--, l--) {
                        dp[k][l] += 1;
                        if (A[k].charAt(l) == '1') break;
                    }

                    for (int k = i + 1, l = j - 1; k < n && l >= 0; k++, l--) {
                        dp[k][l] += 1;
                        if (A[k].charAt(l) == '1') break;
                    }
                    for (int k = i - 1, l = j + 1; k >= 0 && l < m; k--, l++) {
                        dp[k][l] += 1;
                        if (A[k].charAt(l) == '1') break;
                    }
                }
            }
        }

        return dp;
    }
}
