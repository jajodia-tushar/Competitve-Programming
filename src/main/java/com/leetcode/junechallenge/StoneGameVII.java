package com.leetcode.junechallenge;

import java.util.Arrays;


/*
Alice and Bob take turns playing a game, with Alice starting first.
There are n stones arranged in a row. On each player's turn, they
can remove either the leftmost stone or the rightmost stone from
the row and receive points equal to the sum of the remaining stones'
values in the row. The winner is the one with the higher score when
there are no stones left to remove.

Bob found that he will always lose this game (poor Bob, he always loses),
so he decided to minimize the score's difference.
Alice's goal is to maximize the difference in the score.
Given an array of integers stones where stones[i] represents the value
of the ith stone from the left, return the difference in Alice and Bob's score if they both play optimally.

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

public class StoneGameVII {

    public static void main(String[] args) {
        StoneGameVII obj = new StoneGameVII();
        int[] ints = {5, 3, 1, 4, 2};
        int result = obj.solveIterative(ints);
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

    public int solveIterative(int[] nums) {

        int size = nums.length;
        prefixSum = new int[size + 1];
        int[][] dp = new int[size][size];

        for (int i = 0; i < size; i++)
            prefixSum[i + 1] = prefixSum[i] + nums[i];

        for (int gap = 0; gap < size; gap++) {
            for (int i = 0, j = gap; j < size; i++, j++) {
                if (i == j) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Math.max(getSum(i + 1, j) - dp[i + 1][j], getSum(i, j - 1) - dp[i][j - 1]);
                }
            }
        }
        return dp[0][size - 1];
    }

    public int solveIterativeSpaceOptimized(int[] nums) {

        int size = nums.length;
        prefixSum = new int[size + 1];
        int[] dp = new int[size + 1];

        for (int i = 0; i < size; i++)
            prefixSum[i + 1] = prefixSum[i] + nums[i];

        for (int end = 1; end <= size; end++) {
            for (int i = 0; i < size - end; i++) {
                dp[i] = Math.max(
                        getSum(i + 1, i + end) - dp[i + 1], // As if we pick i, we need to find solution of (i+1, end).
                        getSum(i, i + end - 1) - dp[i] // As if we pick end, we need to find solution of (i, end - 1)
                );
            }
        }
        return dp[0];
    }
}

/*
    Let's try to understand the problem first.
    I think that one statement of Bob always losing and trying to get minimum score difference might lead to confusion.
    But it is simple what it meant is that Bob wants to minimum his loss score i.e.
    minimize(Alice's Winnings - Bob's Winnings) while Alice wants this to maximize maximize(Alice's Winnings - Bob's Winnings).
    After defining these 2 statements it is implicit that the way both play is same i.e.
    if Bob tries to score more he would be able to minimize the score difference.
    Similarly, if Alice tries score more he would be able to lead and increase the gap between his and Bob's winnings.

    Let's start our discussion from the most obvious thought looking at this problem.
    We need to try out all possible combinations and at each step we want to take out
    that element out of leftmost and rightmost elements that would lead to maximum score
    for him in future after the game is over. Let's start from the initial thought and
    on the way pick up all the optimizations as we can and reach the final accepted solution. ✅

    Before starting Let's recall what the score at a given turn is.
    It is defined as the (sum of all remaining elements in the array - score obtained by the opponent)

    Solving Iteratively also similar to the one in Coin In a Line Problem.
    See to solve for dp[i][j] you will need to first have already solved the version
    of dp[i + 1][j - 1] That's why you progress in the length wise manner.
    For length 0 to n - 1.

    And then apply the main logic you have in the program.


 */