package com.leetcode.junechallenge;

import java.util.Arrays;


/*
Alice and Bob take turns playing a game, with Alice starting first.

There are n stones arranged in a row. On each player's turn, they can remove either the leftmost stone or the rightmost stone from the row and receive points equal to the sum of the remaining stones' values in the row. The winner is the one with the higher score when there are no stones left to remove.

Bob found that he will always lose this game (poor Bob, he always loses), so he decided to minimize the score's difference. Alice's goal is to maximize the difference in the score.

Given an array of integers stones where stones[i] represents the value of the ith stone from the left, return the difference in Alice and Bob's score if they both play optimally.



Example 1:

Input: stones = [5,3,1,4,2]
Output: 6
Explanation:
- Alice removes 2 and gets 5 + 3 + 1 + 4 = 13 points. Alice = 13, Bob = 0, stones = [5,3,1,4].
- Bob removes 5 and gets 3 + 1 + 4 = 8 points. Alice = 13, Bob = 8, stones = [3,1,4].
- Alice removes 3 and gets 1 + 4 = 5 points. Alice = 18, Bob = 8, stones = [1,4].
- Bob removes 1 and gets 4 points. Alice = 18, Bob = 12, stones = [4].
- Alice removes 4 and gets 0 points. Alice = 18, Bob = 12, stones = [].
The score difference is 18 - 12 = 6.
Example 2:

Input: stones = [7,90,5,1,100,10,10,2]
Output: 122


Constraints:

n == stones.length
2 <= n <= 1000
1 <= stones[i] <= 1000
 */

// TODO -- Solve Iteratively.
public class StoneGameVII {

    public static void main(String[] args) {
        StoneGameVII obj = new StoneGameVII();
        int[] ints = {2, 3, 4, 1, 3, 5};
        int result = obj.stoneGameVII(ints);
        System.out.println(result);
    }

    int[] prefixSum;
    int[][] dp;

    public int stoneGameVII(int[] nums) {

        int n = nums.length;
        prefixSum = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        dp = new int[n][n];
        for (int[] x : dp) {
            Arrays.fill(x, -1);
        }

        return solve(0, n - 1, nums);
    }

    public int getSum(int i, int j) {
        return prefixSum[j + 1] - prefixSum[i];
    }

    public int solve(int i, int j, int nums[]) {

        if (i > j) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        int a = getSum(i + 1, j) - solve(i + 1, j, nums);
        int b = getSum(i, j - 1) - solve(i, j - 1, nums);

        return dp[i][j] = Math.max(a, b);
    }
}

/*

    Was not able to solve this question.
    It is actually similar to the concept from Coin in a line.

    But there the result was the maximum score you can attend
    and here we have the diff as result.
    So there is just slight difference in how we calculate.

    Wasn't able to solve the question in iterative manner.
    Will have to look again on PepCoding Videos

 */