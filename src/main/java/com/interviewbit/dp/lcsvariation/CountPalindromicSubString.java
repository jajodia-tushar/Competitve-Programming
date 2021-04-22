package com.interviewbit.dp.lcsvariation;

public class CountPalindromicSubString {

    public static void main(String[] args) {
        CountPalindromicSubString obj = new CountPalindromicSubString();
        String A = "abaab";
        int result = obj.CountPS(A);
        System.out.println(result);
    }

    public int CountPS(String A) {

        int n = A.length();
        boolean[][] dp = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            if (A.charAt(i) == A.charAt(i + 1)) {
                dp[i][i + 1] = true;
                count++;
            }
        }

        for (int k = 3; k <= n; k++) {
            for (int i = 0; i <= n - k; i++) {
                int j = i + k - 1;
                if (dp[i + 1][j - 1] && A.charAt(i) == A.charAt(j)) {
                    dp[i][j] = true;
                    count++;
                }
            }
        }
        return count;
    }
}
