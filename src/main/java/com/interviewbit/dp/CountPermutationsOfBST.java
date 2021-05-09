package com.interviewbit.dp;

import com.interviewbit.utils.ArrayUtils;

public class CountPermutationsOfBST {

    public static void main(String[] args) {

        CountPermutationsOfBST obj = new CountPermutationsOfBST();
        int result = obj.countPermutations(3, 2);
        System.out.println(result);

    }

    // Doesn't work.
    public int countPermutations(int A, int B) {


        int[][] dp = new int[A + 1][B + 1];
        dp[0][0] = 1;
        dp[1][0] = 1;

        for (int i = 2; i <= A; i++) {
            for(int h = 1; h <= B; h++){
                int result = 0;
                for (int j = 0; j < i; j++) {
                    result += dp[i - j - 1][h - 1];
                    result += dp[j][h - 1];
                }
                dp[i][h] = result;
            }
        }

        ArrayUtils.printArray(dp);
        return dp[A][B];
    }

    // Works.
    public int cntPermBST(int A, int B) {
        if (B >= A || B <= 0) {
            return 0;
        }

        int MOD = 1000000007;

        long[][] c = new long[1 + A][1 + A];
        for (int n = 0; n < c.length; n++) {
            c[n][0] = 1;
            for (int k = 1; k < c[n].length && k <= n; k++) {
                if (n == k) {
                    c[n][k] = 1;
                } else {
                    c[n][k] = (c[n - 1][k - 1] + c[n - 1][k]) % MOD ;
                }
            }
        }


        long[][] dp = new long[1 + A][1 + B]; // [len][height]
        dp[0][0] = 1;
        dp[1][0] = 1;

        for (int len = 2; len <= A; len++) {
            for (int height = 1; height <= B && height < len; height++) {
                for (int root = 0; root < len; root++) {
                    int left = root;
                    int right = len - left - 1;

                    //System.out.println("len=" + len + " height=" + height + " left=" + left + " right=" + right);
                    //System.out.println("dp[left][height - 1]=" + dp[left][height - 1] +
                    //    " dp[right][height - 1]=" + dp[right][height - 1]);

                    long cur = 0;
                    for (int i = 0; i <= height - 2; i++) {
                        cur = (cur + dp[left][i] * dp[right][height - 1]) % MOD;
                        cur = (cur + dp[right][i] * dp[left][height - 1]) % MOD;
                        //    System.out.println("dp[left][i]=" + dp[left][i] + " dp[right][i]=" + dp[right][i] + " cur=" + cur);
                    }
                    cur = (cur + dp[left][height - 1] * dp[right][height - 1]) % MOD;

                    dp[len][height] = (dp[len][height] + c[left + right][right] * cur) % MOD;
                    //System.out.println("cur=" + cur + " C=" + c[left + right][right]
                    //    + " dp[len][height]=" + dp[len][height]);
                }
            }
        }

        return (int)dp[A][B];
    }
}
