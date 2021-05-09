package com.interviewbit.dp.matrixandgrid;

public class ArrangeII {

    public static void main(String[] args) {
        ArrangeII obj = new ArrangeII();
        int result = obj.arrange("B", 15);
        System.out.println(result);
    }

    public int arrange(String str, int stables) {

        int n = str.length();
        long[][] dp = new long[n + 1][stables + 1];

        if( stables > n) return -1;

        int W = 0;
        int B = 0;
        for (int i = 1; i <= n; i++) {
            if (str.charAt(i - 1) == 'W') W++;
            else B++;
            dp[i][1] = W * B;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= stables; j++) {
                if (j > i) {
                    dp[i][j] = Integer.MAX_VALUE;
                } else if (j == i) {
                    dp[i][j] = 0;
                } else {
                    int w = 0;
                    int b = 0;
                    long min = Integer.MAX_VALUE;
                    for (int k = i - 1; k > 0; k--) {
                        if (str.charAt(k) == 'W') w++;
                        else b++;
                        long temp = dp[k][j - 1] + w * b;
                        min = Math.min(min, temp);
                    }
                    dp[i][j] = min;
                }
            }
        }
        int result = (int) dp[n][stables];
        return result == Integer.MAX_VALUE ? -1 : result;
    }

}
