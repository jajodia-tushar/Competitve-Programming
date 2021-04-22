package com.interviewbit.dp.mcmvariatino;


//Given a string A, partition A such that every substring of the partition is a palindrome.
//Return the minimum cuts needed for a palindrome partitioning of A.

import java.util.Arrays;

public class PalindromicPartitioning2 {

    public static void main(String[] args) {
        PalindromicPartitioning2 obj = new PalindromicPartitioning2();
        int result = obj.solveIterative("dVGAaVO25EmT6W3zSTEA0k12i64Kkmmli09Kb4fArlF4Gc2PknrlkevhROxUg");
        System.out.println(result);
    }


    public int minCut(String A) {
        int n = A.length();
        int[][] dp = new int[n][n];
        for (int[] a : dp) Arrays.fill(a, -1);
        return recursive(A, 0, n - 1, dp);
    }

    public int recursive(String A, int i, int j, int[][] dp) {

        if (i >= j) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        if (isPalindrome(A, i, j)) return 0;
        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int temp = recursive(A, i, k, dp) + recursive(A, k + 1, j, dp) + 1;
            min = Math.min(temp, min);
        }
        return dp[i][j] = min;
    }

    public boolean isPalindrome(String A, int i, int j) {

        if (i > j) return false;
        while (i < j) {
            if (A.charAt(i++) != A.charAt(j--)) return false;
        }
        return true;
    }


    // Iterative Solution.
    // Inspired by the Palindrome Substring
    // Everything is same as palindrome partitioning
    // Just we take a extra variable result[][] result[i][j] will denote the minimum number of partition required to make the string from i to j palindrome
    // So Clearly if the string represent by i to j is palindrome then result[i][j] = 0.
    // Else we iterate k from i to j to see the minimum value of
    // result[i][k] + result[k + 1][j] + 1 --> Think this is logical right.
    public int solveIterative(String A) {

        int n = A.length();
        int[][] result = new int[n][n];
        boolean[][] isPalindrome = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            isPalindrome[i][i] = true;
            result[i][i] = 0;
        }

        for (int i = 0; i < n - 1; i++) {
            if (A.charAt(i) == A.charAt(i + 1)) {
                isPalindrome[i][i + 1] = true;
                result[i][i + 1] = 0;
            } else {
                result[i][i + 1] = 1;
            }
        }

        for (int l = 3; l <= n; l++) {
            for (int i = 0; i <= n - l; i++) {
                int j = i + l - 1;
                if (isPalindrome[i + 1][j - 1] && A.charAt(i) == A.charAt(j)) {
                    isPalindrome[i][j] = true;
                    result[i][j] = 0;
                } else {
                    int min = Integer.MAX_VALUE;
                    for (int x = i; x < j; x++) {
                        int value = result[i][x] + result[x + 1][j] + 1;
                        min = Math.min(value,min);
                    }
                    result[i][j] = min;
                }
            }
        }
        return result[0][n - 1];
    }


}
