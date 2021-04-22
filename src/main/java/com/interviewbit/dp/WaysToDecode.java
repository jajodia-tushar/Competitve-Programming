package com.interviewbit.dp;

import java.util.Arrays;

public class WaysToDecode {

    private int[] dp;
    private int MOD = 1000000007;

    public static void main(String[] args) {
        WaysToDecode obj = new WaysToDecode();
        int result = obj.numDecodings("10");
//        int result = obj.numDecodings("12");
        System.out.println(result);
    }

    public int numDecodings(String A) {
        int n = A.length();
        dp = new int[n + 1];
        Arrays.fill(dp,-1);

        if( n == 1 && A.charAt(0) == '0') return 0;

        return  count(A,n);
    }


    public int count(String A, int n){

        long total = 0;
        if( n == 0 || n == 1) return 1;

        if(A.charAt(0) == '0'){
            return 0;
        }

        if( dp[n] != -1) return dp[n];

        if( A.charAt( n - 1) > '0'){
            total = (total + count(A,n - 1)) % MOD;
        }

        char ch = A.charAt(n - 2);
        if( ch == '1' || (ch == '2' && A.charAt(n -1) < '7')){
            total = (total +  count(A, n - 2)) % MOD;
        }

        return dp[n] = (int)total;

    }
}
