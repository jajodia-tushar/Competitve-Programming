package com.interviewbit.dp.unboundedknapsackvariation;

public class TusharBirthdayParty {

    public static void main(String[] args) {

        TusharBirthdayParty obj = new TusharBirthdayParty();
        int[] A = {2, 3, 1, 5, 4 };
        int[] B = {3, 2, 4, 1 };
        int[] C = {1, 2, 5, 10 };

        int result = obj.solve(A, B, C);
        System.out.println(result);
    }


    public int solve(final int[] A, final int[] B, final int[] C) {

        int total = 0;
        int n = A.length;
        for(int i = 0; i < n ; i++){

            int knapSackSize = A[i];
            int nK = B.length;
            int[][] dp = new int[nK + 1][knapSackSize + 1];

            for(int j = 0; j <= nK; j++){
                for(int k = 0; k <= knapSackSize; k++){

                    if( k == 0){
                        dp[j][k] = 0;
                        continue;
                    }

                    if( j == 0){
                        dp[j][k] = Integer.MAX_VALUE - 1000;
                        continue;
                    }

                    if( B[j - 1] <= k ){
                        dp[j][k] = Math.min(C[j - 1] + dp[j][k - B[j - 1]],dp[j - 1][k]);
                    }
                    else{
                        dp[j][k] = dp[j - 1][k];
                    }
                }
            }

            total += dp[nK][knapSackSize];
        }

        return total;

    }
}
