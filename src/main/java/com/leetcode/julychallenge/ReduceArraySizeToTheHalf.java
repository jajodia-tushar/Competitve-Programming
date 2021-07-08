package com.leetcode.julychallenge;

import java.util.*;

public class ReduceArraySizeToTheHalf {

    public static void main(String[] args) {
        ReduceArraySizeToTheHalf obj = new ReduceArraySizeToTheHalf();
        int[] ints = {3, 3, 3, 3, 5, 5, 5, 2, 2, 7};
        int result = obj.minSetSize(ints);
        System.out.println(result);
    }

    public int minSetSize(int[] arr) {

        Arrays.sort(arr);
        int n = arr.length;

        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        int i = 0;
        int count = 1;
        while (i < n - 1) {
            if (arr[i] == arr[i + 1]) {
                count++;
            } else {
                queue.add(count);
                count = 1;
            }
            i++;
        }
        queue.add(count);

        int result = 0;
        n = n / 2;
        count = 0;
        while (!queue.isEmpty() && count < n) {
            count += queue.poll();
            result++;
        }

        return result;
    }
}
