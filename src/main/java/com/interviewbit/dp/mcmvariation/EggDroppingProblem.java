package com.interviewbit.dp.mcmvariation;


import java.util.Arrays;

/*
    You are given A eggs, and you have access to a building with B floors from 1 to B.
    Each egg is identical in function, and if an egg breaks, you cannot drop it again.
    You know that there exists a floor C with 0 <= C <= B such that any egg dropped at a floor higher than C will break, and any egg dropped at or below floor C will not break.
    Each move, you may take an egg (if you have an unbroken one) and drop it from any floor X (with 1 <= X <= B).
    Your goal is to know with certainty what the value of C is.
    What is the minimum number of moves that you need to know with certainty what C is, regardless of the initial value of C
 */

// SEE AGAIN OPTIMIZED SOLUTION USING BINARY SEARCH
public class EggDroppingProblem {


    public static void main(String[] args) {
        EggDroppingProblem obj = new EggDroppingProblem();
        int result = obj.iterativeSolution(2, 36);
        System.out.println(result);
    }

    public int solve(int n, int k) {

        int[][] dp = new int[n + 1][k + 1];
        for (int[] a : dp) Arrays.fill(a, -1);
        return recursive(n, k, dp);
    }

    public int recursive(int n, int k, int[][] dp) {

        if (k == 0 || k == 1) return dp[n][k] = k;
        if (n == 1) return dp[n][k] = k;

        if (dp[n][k] != -1) return dp[n][k];

        int min = Integer.MAX_VALUE;
        for (int x = 1; x <= k; x++) {
            int survives = recursive(n, k - x, dp);
            int breaks = recursive(n - 1, x - 1, dp);
            int value = Math.max(survives, breaks);
            min = Math.min(value, min);
        }
        return dp[n][k] = min + 1;
    }

    public int iterativeSolution(int n, int k) {

        int[][] dp = new int[n + 1][k + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if (i == 1) {
                    dp[i][j] = j;
                } else if (j == 1) {
                    dp[i][j] = 1;
                } else {
                    int min = Integer.MAX_VALUE;
                    for (int x = 0; x < j; x++) {
                        int breaks = dp[i - 1][x];
                        int survives = dp[i][j - x - 1];
                        int value = Math.max(breaks, survives);
                        min = Math.min(min, value);
                    }
                    dp[i][j] = min + 1;
                }
            }
        }

        return dp[n][k];

    }


    // K Eggs and N Floor.
    public int superEggDrop(int k, int n) {

        int[][] dp = new int[n + 1][k + 1];

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= k; j++){
                if( j == 1){
                    dp[i][j] = i;
                }
                else if( i == 1){
                    dp[i][j] = 1;
                }
                else{

                    int start = 1;
                    int end = i - 1;
                    int ans = Integer.MAX_VALUE;
                    while(start <= end){
                        int mid = start + (end - start)/2;
                        int breaks   = dp[mid - 1][j - 1];
                        int survives = dp[i - mid][j];
                        ans = Math.min(ans, Math.max(breaks,survives));

                        if( breaks == survives)
                            break;

                        if( breaks < survives){
                            start = mid + 1;
                        }
                        else{
                            end = mid - 1;
                        }
                    }
                    dp[i][j] = ans + 1;
                }
            }
        }
        return dp[n][k];
    }
    /*
        Here the idea is interesting.
        See you don't need to check for all the values from 0 to N
        to get the minimum value.

        See Breaks case dp(k - 1, x - 1) is an Increasing Function.
        And the Survives case dp(k,n - x) is an Decreasing Function.

        so We can do Binary Search on this.

        if breaks value is low it means we are in in left part so we move right.
        is survives is less we are in right part and we move left as we used to
        do in the binary search.

        The Minimum value is somewhere in the middle.


     */


}
