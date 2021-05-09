package com.interviewbit.dp.dptricky;

import com.interviewbit.utils.ArrayUtils;

import java.util.HashMap;

public class LongestArithmeticProgression {

    public static void main(String[] args) {
        LongestArithmeticProgression obj = new LongestArithmeticProgression();
        int[] ints = ArrayUtils.asArrays(9, 4, 7, 2, 10);
        int result = obj.solve(ints);
        System.out.println(result);
    }

    public int solve(final int[] A) {

        int n = A.length;
        int[][] dp = new int[n][n];
        if (n < 3)
            return n;
        HashMap<Integer, Integer> maps = new HashMap<>();
        int ans = 2;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = 2;
                int need = 2 * A[i] - A[j];
                if (maps.get(need) == null) {
                    continue;
                }
                dp[i][j] = dp[maps.get(need)][i] + 1;
                ans = Math.max(ans,dp[i][j]);
            }
            maps.put(A[i], i);
        }

        return ans;
    }
}
