package com.interviewbit.dp.dptricky;

public class CoinsInALine {

    public static void main(String[] args) {

        CoinsInALine obj = new CoinsInALine();
        int[] ints = {1, 2, 3, 4};
        int result = obj.solve(0, 3, ints);
        System.out.println(result);

    }

    public int maxcoin(int[] A) {

        int n = A.length;
        int[][] dp = new int[n][n];


        for (int gap = 0; gap < n; gap++) {
            for (int i = 0, j = gap; j < n; i++, j++) {

                int x = (i + 2) <= j ? dp[i + 2][j] : 0;
                int y = (i + 1) <= (j - 1) ? dp[i + 1][j - 1] : 0;
                int z = i <= (j - 2) ? dp[i][j - 2] : 0;


                dp[i][j] = Math.max(A[i] + Math.min(x, y),
                        A[j] + Math.min(y, z));
            }
        }


        return dp[0][n - 1];

    }

    public int solve(int i, int j, int[] arr) {
        if (i < 0 || j >= arr.length || i > j) return 0;
        if (i == j) return arr[i];

        int x = solve(i + 2, j, arr);
        int y = solve(i + 1, j - 1, arr);
        int z = solve(i, j + 2, arr);
        return Math.max(arr[i] + Math.min(x, y), arr[j] + Math.min(y, z));
    }


}
