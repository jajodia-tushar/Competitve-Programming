package com.leetcode.junechallenge;

/*
You are given an integer array matchsticks where matchsticks[i] is the length of the ith matchstick. You want to use all the matchsticks to make one square. You should not break any stick, but you can link them up, and each matchstick must be used exactly one time.

Return true if you can make this square and false otherwise.

Example 1:


Input: matchsticks = [1,1,2,2,2]
Output: true
Explanation: You can form a square with length 2, one side of the square came two sticks with length 1.
Example 2:

Input: matchsticks = [3,3,3,3,4]
Output: false
Explanation: You cannot find a way to form a square with all the matchsticks.


Constraints:

1 <= matchsticks.length <= 15
0 <= matchsticks[i] <= 109
   Hide Hint #1
Treat the matchsticks as an array. Can we split the array into 4 equal halves?
   Hide Hint #2
Every matchstick can belong to either of the 4 sides. We don't know which one. Maybe try out all options!
   Hide Hint #3
For every matchstick, we have to try out each of the 4 options i.e. which side it can belong to. We can make use of recursion for this.
   Hide Hint #4
We don't really need to keep track of which matchsticks belong to a particular side during recursion. We just need to keep track of the length of each of the 4 sides.
   Hide Hint #5
When all matchsticks have been used we simply need to see the length of all 4 sides. If they're equal, we have a square on our hands!
 */
public class MatchsticksToSquare {

    public static void main(String[] args) {

        MatchsticksToSquare obj = new MatchsticksToSquare();
        int[] ints = {5, 5, 5, 5, 4, 4, 4, 4, 3, 3, 3, 3};
        boolean result = obj.makesquare(ints);
        System.out.println(result);
    }

    public boolean makesquare(int[] matchsticks) {

        int n = matchsticks.length;
        if (n < 4) return false;

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += matchsticks[i];
        }

        if (sum % 4 != 0) return false;

        sum /= 4;

        return dfs(0, 0, 0, 0, 0, matchsticks, sum);
    }

    public boolean dfs(int l1, int l2, int l3, int l4, int currIndex, int[] arr, int sum) {


        if (l1 > sum || l2 > sum || l3 > sum || l4 > sum) return false;

        if (currIndex == arr.length)
            return l1 == sum && l2 == sum && l3 == sum && l4 == sum;


        return dfs(l1 + arr[currIndex], l2, l3, l4, currIndex + 1, arr, sum) ||
                dfs(l1, l2 + arr[currIndex], l3, l4, currIndex + 1, arr, sum) ||
                dfs(l1, l2, l3 + arr[currIndex], l4, currIndex + 1, arr, sum) ||
                dfs(l1, l2, l3, l4 + +arr[currIndex], currIndex + 1, arr, sum);
    }
}
