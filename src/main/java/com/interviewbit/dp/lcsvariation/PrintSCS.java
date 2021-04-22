package com.interviewbit.dp.lcsvariation;

import java.util.Arrays;

public class PrintSCS {

    public static void main(String[] args) {

        PrintSCS obj = new PrintSCS();
        String A = "AGGTAB";
        String B = "GXTXAYB";
        String result = obj.getSCS(A, B);
        System.out.println(result);

    }

    public String getSCS(String A, String B) {

        LongestCommonSubSequence obj = new LongestCommonSubSequence();

        int n = A.length();
        int m = B.length();

        int[][] dp = new int[n + 1][m + 1];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        obj.recursive(A, B, n, m, dp);
        int scsLength = A.length() + B.length() - dp[n][m];

        char[] result = new char[scsLength];

        while (n > 0 && m > 0) {
            if (A.charAt(n - 1) == B.charAt(m - 1)) {
                result[--scsLength] = A.charAt(n - 1);
                n--;
                m--;
            } else if (dp[n - 1][m] > dp[n][m - 1]) {
                result[--scsLength] = A.charAt(n - 1);
                n--;
            } else {
                result[--scsLength] = B.charAt(m - 1);
                m--;
            }
        }

        while ( n > 0){
            result[--scsLength] = A.charAt(n - 1);
            n--;
        }

        while ( m > 0){
            result[--scsLength] = B.charAt(m - 1);
            m--;
        }

        return new String(result);
    }


}
