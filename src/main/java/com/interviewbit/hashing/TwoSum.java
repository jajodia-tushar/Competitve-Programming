package com.interviewbit.hashing;

import com.interviewbit.utils.ArrayUtils;

import java.util.HashMap;
import java.util.Map;

/*
    Given an array of integers, find two numbers such that they add up to a specific target number.
    The function twoSum should return indices of the two numbers such that they add up to the target, where index1 < index2. Please note that your returned answers (both index1 and index2 ) are not zero-based.
    Put both these numbers in order in an array and return the array from your function ( Looking at the function signature will make things clearer ). Note that, if no pair exists, return empty list.
    If multiple solutions exist, output the one where index2 is minimum. If there are multiple solutions with the minimum index2, choose the one with minimum index1 out of them.
 */

public class TwoSum {

    public int[] twoSum(final int[] A, int B) {

        HashMap<Integer, Integer> maps = new HashMap<>();
        int[] result = new int[2];

        for (int i = 0; i < A.length; i++) {
            if (!maps.containsKey(A[i]))
                maps.put(A[i], i);
        }

        for (int i = 0; i < A.length; i++) {
            int diff = B - A[i];
            if (maps.containsKey(diff)) {
                int index2 = Math.max(i, maps.get(diff)) + 1;
                int index1 = Math.min(i, maps.get(diff)) + 1;

                if (result[1] == 0 || index2 < result[1]) {
                    result[1] = index2;
                    result[0] = index1;
                } else if (result[1] == index2) {
                    result[0] = Math.min(index1, result[0]);
                }
            }
        }
        return result;
    }

    public int[] twoSumX(final int[] A, int B) {

        int n = A.length;
        int[] result = new int[2];
        Map<Integer, Integer> maps = new HashMap<>();

        for (int i = n - 1; i >= 0; i--) {
            if (maps.containsKey(B - A[i]) && (result[1] == 0 || result[1] > maps.get(B - A[i]))) {
                result[0] = i + 1;
                result[1] = maps.get(B - A[i]) + 1;
            }
            maps.put(A[i], i);
        }

        if (result[1] == 0) return new int[]{};
        return result;

    }

    public int[] twoSumY(final int[] A, int B) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            if (map.containsKey(A[i])) {
                int[] result = {map.get(A[i]), i + 1};

                return result;
            } else if (!map.containsKey(B - A[i])) {
                map.put(B - A[i], 1 + i);
            }
        }
        return new int[0];

    }

    public static void main(String[] args) {
        TwoSum obj = new TwoSum();
        int[] arr = ArrayUtils.asArrays(4, 7, -4, 2, 2, 2, 3, -5, -3, 9, -4, 9, -7, 7, -1, 9, 9, 4, 1, -4, -2, 3, -3, -5, 4, -7, 7, 9, -4, 4, -8);
        int[] ints = obj.twoSum(arr, -3);
        ArrayUtils.printArray(ints);
    }
}

/*
    With hashMap things are easy.
    See the Optimum answer as per the constraints without too much comparision.
 */