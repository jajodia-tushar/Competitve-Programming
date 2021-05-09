package com.interviewbit.dp;

public class UniqueBinarySearchTreesII {

    public static void main(String[] args) {

        UniqueBinarySearchTreesII obj = new UniqueBinarySearchTreesII();
        int result = obj.numTrees(5);
        System.out.println(result);

    }

    public int numTrees(int A) {

        int[] dp = new int[A + 1];
        dp[0] = 1;

        for (int i = 1; i <= A; i++) {
            int result = 0;
            for (int j = 0; j < i; j++) {

                result += dp[i - j - 1] * dp[j];
            }
            dp[i] = result;
        }
        return dp[A];
    }
}
