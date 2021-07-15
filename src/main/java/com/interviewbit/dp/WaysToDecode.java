package com.interviewbit.dp;

import java.util.Arrays;

public class WaysToDecode {

    private int[] dp;
    private int MOD = 1000000007;

    public static void main(String[] args) {
        WaysToDecode obj = new WaysToDecode();
        String str = "110";
        int n = str.length();
//        int result = obj.count(str);
        int result = obj.count(str, n);
        System.out.println(result);
    }

    public int numDecodings(String A) {
        int n = A.length();
        dp = new int[n + 1];
        Arrays.fill(dp, -1);

        if (n == 1 && A.charAt(0) == '0') return 0;

        return count(A, n);
    }


    public int count(String A, int n) {

        if (dp == null) {
            dp = new int[n + 1];
            Arrays.fill(dp, -1);
        }


        long total = 0;
        if (n == 0 || n == 1) return 1;

        if (A.charAt(0) == '0') {
            return 0;
        }

        if (dp[n] != -1) return dp[n];

        if (A.charAt(n - 1) > '0') {
            total = (total + count(A, n - 1)) % MOD;
        }

        char ch = A.charAt(n - 2);
        if (ch == '1' || (ch == '2' && A.charAt(n - 1) < '7')) {
            total = (total + count(A, n - 2)) % MOD;
        }

        return dp[n] = (int) total;

    }
}
