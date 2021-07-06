package com.leetcode.julychallenge;

import java.util.TreeSet;

/*
Given an m x n matrix matrix and an integer k, return the max sum of a rectangle in the matrix such that its sum is no larger than k.

It is guaranteed that there will be a rectangle with a sum no larger than k.



Example 1:


Input: matrix = [[1,0,1],[0,-2,3]], k = 2
Output: 2
Explanation: Because the sum of the blue rectangle [[0, 1], [-2, 3]] is 2, and 2 is the max number no larger than k (k = 2).
Example 2:

Input: matrix = [[2,2,-1]], k = 3
Output: 3


Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 100
-100 <= matrix[i][j] <= 100
-105 <= k <= 105


Follow up: What if the number of rows is much larger than the number of columns?
 */
public class MaxSumOfRectangleNoLargerThanK {

    public static void main(String[] args) {

        MaxSumOfRectangleNoLargerThanK obj = new MaxSumOfRectangleNoLargerThanK();
        int[][] ints = {{1, 0, 1}, {0, -2, 3}};
        int result = obj.maxSumSubmatrix(ints, 2);
        System.out.println(result);

    }

    public int maxSumSubmatrix(int[][] matrix, int k) {


        int row = matrix.length;
        int col = matrix[0].length;

        int[][] dp = new int[row + 1][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dp[i + 1][j] = dp[i][j] + matrix[i][j];
            }
        }

        int max = Integer.MIN_VALUE;
        for (int r1 = 0; r1 < row; r1++) {
            for (int r2 = r1 + 1; r2 < row + 1; r2++) {

                int sum = 0;
                TreeSet<Integer> sets = new TreeSet<>();
                sets.add(0);
                for (int c = 0; c < col; c++) {
                    sum += dp[r2][c] - dp[r1][c];
                    Integer x = sets.ceiling(sum - k);
                    if (x != null) {
                        max = Math.max(max, sum - x);
                    }
                    sets.add(sum);
                }
            }

        }
        return max;
    }

    public int maxSumSubMatrixOptimized(int[][] matrix, int k) {


        int row = matrix.length;
        int col = matrix[0].length;

        int[][] dp = new int[row + 1][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dp[i + 1][j] = dp[i][j] + matrix[i][j];
            }
        }

        int max = Integer.MIN_VALUE;
        for (int r1 = 0; r1 < row; r1++) {
            for (int r2 = r1 + 1; r2 < row + 1; r2++) {

                int kadaneSum = getKadaneSum(dp[r2], dp[r1]);
                if (kadaneSum <= k) {
                    max = Math.max(max, kadaneSum);
                    continue;
                }

                int sum = 0;
                TreeSet<Integer> sets = new TreeSet<>();
                sets.add(0);
                for (int c = 0; c < col; c++) {
                    sum += dp[r2][c] - dp[r1][c];
                    Integer x = sets.ceiling(sum - k);
                    if (x != null) {
                        max = Math.max(max, sum - x);
                    }
                    sets.add(sum);
                }
            }

        }
        return max;
    }

    public int getKadaneSum(int[] arr1, int[] arr2) {

        int n = arr1.length;
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;


        for (int i = 0; i < n; i++) {
            int num = arr1[i] - arr2[i];
            currSum = Math.max(currSum + num, num);
            maxSum = Math.max(maxSum, currSum);
        }

        return maxSum;
    }

}

/*
    This Question is Amazing.

    Let's break down this question, If you are not given a matrix but an array.
    Now here you need to find the value the maximum sum less than K.
    How would you do that.

    You can use the concept of prefix sum array.
    At a index i, Sum is S, and let's say S is greater than K.
    And if we find a sub array at index j which is equal to S - K than
    we have found maximum value required equal to K.
    Or If we are not able to find S - K then we can find the maximum (ceiling value of teh S - K)
    so that the we subtract (S - K) from S it will be less than S and the maximum possible.
    Notice (S - K) will be the sum of the sub Array till index j so out required sum from j to i
    will be (S - ceil(S - K)).

    If we are able to solve this the problem will be solved.
    Now the question comes How do we find the ceiling value of the Given Item.
    We can easily use Binary Search ( ceiling in TreeSet)
    to get the ceiling value.

    Now that the smaller problem is solved, Let's move out to solve the matrix question.

    How can we traverse 2-D matrix in a way so we traverse effectively all the sub array.
    We have done this previously as well and is very useful in Dynamic Programming.
    The idea is to use Prefix Array.


    int[][] dp = new int[row + 1][col];

    for (int i = 0; i < row; i++) {
        for (int j = 0; j < col; j++) {
            dp[i + 1][j] = dp[i][j] + matrix[i][j];
        }
    }

    Here we create Prefix Sum

    and while traversing we use three Loops.
    for (int r1 = 0; r1 < row; r1++) {
        for (int r2 = r1 + 1; r2 < row + 1; r2++) {
            for(column){
            }
        }
    }

    see if we consider the array
           of items dp[r2][c] - dp[r1][c] for all r2 --> (1 to row + 1) and r2 = r1 - 1;
           we are  considering all the sub array where there is row r2,
            i.e if r2 = 1;

                1 , 12, 123, 1234, 12345, 12345..n

            if r2 = 2
                2, 23, ,234, 2345, 23456, 23456...n

            and so on


            so all the sub array row wise are traverse.

          Now if we apply pre-learned thing in this array we are good and solve the issue.







       ---------
                One More things is, if we use kadene's algorithm here and max-sum for an array turns out to be less than K
                we can more forward without calculating the sum this way,
                So to improve the runtime, we can add an if of kadene's algorithm.






































 */

