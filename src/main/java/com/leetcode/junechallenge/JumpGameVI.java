package com.leetcode.junechallenge;

/*
You are given a 0-indexed integer array nums and an integer k.
You are initially standing at index 0. In one move, you can jump at most k steps forward without going outside the boundaries of the array. That is, you can jump from index i to any index in the range [i + 1, min(n - 1, i + k)] inclusive.
You want to reach the last index of the array (index n - 1). Your score is the sum of all nums[j] for each index j you visited in the array
Return the maximum score you can get.

Example 1:
Input: nums = [1,-1,-2,4,-7,3], k = 2
Output: 7
Explanation: You can choose your jumps forming the subsequence [1,-1,4,3] (underlined above). The sum is 7.

Example 2:
Input: nums = [10,-5,-2,4,0,3], k = 3
Output: 17
Explanation: You can choose your jumps forming the subsequence [10,4,3] (underlined above). The sum is 17.

Example 3:
Input: nums = [1,-5,-20,4,-1,3,-6,-3], k = 2
Output: 0

Constraints:
 1 <= nums.length, k <= 105
-104 <= nums[i] <= 104
 */

import java.util.LinkedList;
import java.util.PriorityQueue;

public class JumpGameVI {

    public static void main(String[] args) {
        JumpGameVI obj = new JumpGameVI();
        int[] ints = {1, -1, -2, 4, -7, 3};
        int result = obj.maxResult(ints, 2);
        System.out.println(result);

        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        System.out.println(queue.peek());
        queue.addLast(30);
        System.out.println(queue.peek());
        queue.addFirst(50);
        System.out.println(queue.peek());
        queue.poll();
        System.out.println(queue.peek());
        queue.removeLast();
        System.out.println(queue.peek());
        queue.removeFirst();
        System.out.println(queue.peek());

        // 10 10 50 10 10 20
    }

    public int maxResult(int[] nums, int k) {

        int n = nums.length;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        int[] dp = new int[n];
        dp[0] = nums[0];
        queue.add(new int[]{dp[0], 0});

        // [1,-1,-2,4,-7,3]
        for (int i = 1; i < n; i++) {
            dp[i] = nums[i] + queue.peek()[0];
            queue.add(new int[]{dp[i], i});
            while (!queue.isEmpty() && (i - queue.peek()[1]) + 1 > k) {
                queue.poll();
            }
        }
        return dp[n - 1];
    }

    public int[] maxSlidingWindowUsingDeQue(int[] nums, int k) {

        int n = nums.length;
        int[] result = new int[n - k + 1];

        LinkedList<Integer> queue = new LinkedList<>();
        int j = 0;

        for (int i = 0; i < n; i++) {
            int item = nums[i];
            while (!queue.isEmpty() && queue.getLast() < item) {
                queue.removeLast();
            }
            queue.addLast(item);
            result[j] = queue.peek();

            if (i + 1 >= k) {
                if (nums[j] == queue.peek())
                    queue.poll();
                j++;
            }

        }
        return result;
    }


}
