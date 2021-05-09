package com.interviewbit.dp.dptricky;

public class NDigitNumbersWithDigitSumS {

    public int MOD = 1000000007;

    public static void main(String[] args) {

        NDigitNumbersWithDigitSumS obj = new NDigitNumbersWithDigitSumS();
        int result = obj.solve(2, 4);
        System.out.println(result);

    }

    public int solve(int A, int B) {

        int[][] dp = new int[A + 1][B + 1];

        for (int i = 0; i <= A; i++) {
            for (int j = 0; j <= B; j++) {

                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                    continue;
                }

                if (i == 1 && j <= 9) {
                    dp[i][j] = 1;
                } else {
                    long sum = 0;
                    for (int k = 0; k <= 9; k++) {
                        if (j - k >= 0) {
                            sum = (sum + dp[i - 1][j - k]) % MOD;
                        }
                    }
                    dp[i][j] = (int) sum;
                }
            }
        }
        return dp[A][B];
    }
}
