package com.leetcode.slidingwindow;

import com.interviewbit.utils.ArrayUtils;

import java.util.Collections;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {

    public static void main(String[] args) {

        SlidingWindowMaximum obj = new SlidingWindowMaximum();
        int[] ints = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] result = obj.maxSlidingWindow(ints, 3);
        ArrayUtils.printArray(result);

    }

    // This one is simple but gives TLE
    public int[] maxSlidingWindowX(int[] nums, int k) {

        int n = nums.length;
        int[] result = new int[n - k + 1];

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < k; i++) {
            queue.add(nums[i]);
        }

        for (int i = k; i < n; i++) {
            result[i - k] = queue.peek();
            queue.remove(nums[i - k]);
            queue.add(nums[i]);
        }
        result[n - k] = queue.peek();
        return result;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        int[] result = new int[n - k + 1];

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for (int i = 0; i < n; i++) {
            queue.add(new int[]{nums[i], i});
            if ((i - k + 1) >= 0) {
                result[i - k + 1] = queue.peek()[0];
            }
            while (!queue.isEmpty() && (i - queue.peek()[1] + 1) >= k) {
                queue.poll();
            }
        }
        return result;
    }
}
/*
    The Idea in this question is to use Max Heap of int[] and actually there is just two items in
    the int[] it has item and index of that item, so we keep adding the item,
    if we remove the last item every-time we add new item it will give TLE.
    So what we can do is we keep checking the index of the peek element if
    this one is out of window size only then we will remove the item
    from queue in repeated manner as shown in code.
 */
