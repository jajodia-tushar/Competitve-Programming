package com.interviewbit.dp.lcsvariation;


import java.util.Arrays;

public class PrintLCS {

    public static void main(String[] args) {
        PrintLCS obj = new PrintLCS();
        String A = "abcdaf";
        String B = "acbcf";
        String result = obj.getLCSString(A, B);
        System.out.println(result);
    }

    public String getLCSString(String A, String B) {
        LongestCommonSubSequence obj = new LongestCommonSubSequence();
        int n = A.length();
        int m = B.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int[] a : dp) Arrays.fill(a, -1);
        obj.recursive(A, B, n, m, dp);

        StringBuilder str = new StringBuilder();

        while (n > 0 && m > 0) {
            if (A.charAt(n - 1) == B.charAt(m - 1)) {
                str.append(A.charAt(n - 1));
                n--;
                m--;
            } else if (dp[n - 1][m] > dp[n][m - 1]) {
                n--;
            } else {
                m--;
            }
        }
        return str.reverse().toString();
    }


}
