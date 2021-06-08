package com.leetcode.junechallenge;

import com.interviewbit.dp.lcsvariation.LongestCommonSubSequence;

import java.util.*;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {

        LongestConsecutiveSequence obj = new LongestConsecutiveSequence();
        int[] ints = new int[]{1, 2, 3, 4, 5, 7};
        int result = obj.longestConsecutive(ints);
        System.out.println(result);
    }

    public int longestConsecutive(int[] nums) {

        Set<Integer> sets = new HashSet<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            sets.add(nums[i]);
        }
        int maxCount = 0;

        for (int i = 0; i < n; i++) {
            int item = nums[i];
            if (!sets.contains(item - 1)) {
                int count = 0;
                while (sets.contains(item)) {
                    count++;
                    item++;
                }
                maxCount = Math.max(maxCount, count);
            }
        }
        return maxCount;
    }
}

/*
    Such an elegant and amazing technique to solve this question.
    Keep a hashset and initially insert all the elements in it.

    Now iterate through all the element and if
    for each element check if it is present in the set
    if it is present then you can now loop to see
    what are the next number present and increment the count.

    for eg.

    10, 1, 2, 3, 5, 6,

    the list will have all the number initially.

    now we are at 10 and we will inquire if 10 is present so we make count = 1
    it will say yes and so we will inquire is 11 present it is not so we stop and move to next.

    we will inquire if 1 is present it says yes we will now loop and see if 2 is present
    it says yes and we inquire for 3 and we keep going till we find a number and we
    also keep incrementing the count.

    Now this solution seems perfect.
    but it has a flaw.
    It will do the same for 2 and 3 as well.
    So effectively it will become O(n^2)
    but the catch here is in the line -----> 29.
    So we will iterate if it is the first number in the list else we won't iterate at all.

    if item - 1 is not present in the list only then this current item can be the starting
    of a new consecutive sequence else it will or was included in the other sequence.

    Also while iterating we will know current number will be there in the list so no need to check that as well
    like i explained we can directly go and see if the next number is absent.

    Such an Amazing technique.


 */
