package com.leetcode.julychallenge;


import java.util.*;
import java.util.Random;

/*
Given an integer array nums, design an algorithm to randomly shuffle the array. All permutations of the array should be equally likely as a result of the shuffling.

Implement the Solution class:

Solution(int[] nums) Initializes the object with the integer array nums.
int[] reset() Resets the array to its original configuration and returns it.
int[] shuffle() Returns a random shuffling of the array.


Example 1:

Input
["Solution", "shuffle", "reset", "shuffle"]
[[[1, 2, 3]], [], [], []]
Output
[null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]

Explanation
Solution solution = new Solution([1, 2, 3]);
solution.shuffle();    // Shuffle the array [1,2,3] and return its result.
                       // Any permutation of [1,2,3] must be equally likely to be returned.
                       // Example: return [3, 1, 2]
solution.reset();      // Resets the array back to its original configuration [1,2,3]. Return [1, 2, 3]
solution.shuffle();    // Returns the random shuffling of array [1,2,3]. Example: return [1, 3, 2]



Constraints:

1 <= nums.length <= 200
-106 <= nums[i] <= 106
All the elements of nums are unique.
At most 5 * 104 calls in total will be made to reset and shuffle.
 */


public class ShuffleAnArray {

    public static void main(String[] args) {

    }

//    //======================================== Accepted Solution =================================================
//    int[][] arr;
//
//    public ShuffleAnArray(int[] nums) {
//        int n = nums.length;
//        arr = new int[n][2];
//        for (int i = 0; i < n; i++) {
//            arr[i][0] = nums[i];
//            arr[i][1] = i;
//        }
//    }
//
//    /**
//     * Resets the array to its original configuration and return it.
//     */
//    public int[] reset() {
//        Arrays.sort(arr, (a, b) -> a[1] - b[1]);
//        return getArray();
//    }
//
//    /**
//     * Returns a random shuffling of the array.
//     */
//    public int[] shuffle() {
//        swap(arr);
//        return getArray();
//    }
//
//    public void swap(int[][] arr) {
//        int n = arr.length;
//        Random random = new Random();
//        for (int i = n - 1; i > 0; i--) {
//            int j = random.nextInt(i + 1);
//            int[] temp = arr[i];
//            arr[i] = arr[j];
//            arr[j] = temp;
//        }
//    }
//
//    public int[] getArray() {
//        int n = arr.length;
//        int[] result = new int[n];
//
//        for (int i = 0; i < n; i++) {
//            result[i] = arr[i][0];
//        }
//
//        return result;
//    }
    //============================================= Optimized Solution  =====================================================

    private int[] array;
    private int[] original;

    Random rand = new Random();

    private int randRange(int min, int max) {
        return rand.nextInt(max - min) + min;
    }

    private void swapAt(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public ShuffleAnArray(int[] nums) {
        array = nums;
        original = nums.clone();
    }

    public int[] reset() {
        array = original;
        original = original.clone();
        return original;
    }

    public int[] shuffle() {
        for (int i = 0; i < array.length; i++) {
            swapAt(i, randRange(i, array.length));
        }
        return array;
    }

    // This is Optimized. The Basic Idea is similar
    // But no need to keep the 2D array;
}
