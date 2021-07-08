package com.interviewbit.hashing;

import com.interviewbit.utils.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/*
Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:

Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
The solution set must not contain duplicate quadruplets.
Example :

Given array S = {1 0 -1 0 -2 2}, and target = 0

A solution set is:

    (-2, -1, 1, 2)
    (-2,  0, 0, 2)
    (-1,  0, 0, 1)
Also make sure that the solution set is lexicographically sorted.

Solution[i] < Solution[j] iff Solution[i][0] < Solution[j][0] OR (Solution[i][0] == Solution[j][0] AND ... Solution[i][k] < Solution[j][k])
 */


public class FourSum {

    public static void main(String[] args) {
        int[] ints = ArrayUtils.asArrays(-13, 11, 30, 12, 20, 21, -13, 6, -4, 7, 5, -2, 19, -10, 4, 8, 1);
        FourSum obj = new FourSum();
        int[][] result = obj.fourSum(ints, 79);
        ArrayUtils.printArray(result);
    }

    public int[][] fourSum(int[] A, int B) {

        Arrays.sort(A);
        int n = A.length;
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();
        HashSet<String> sets = new HashSet<>();

        for (int i = 0; i < n - 3; i++) {
            int start = A[i];
            for (int j = i + 1; j < n - 2; j++) {
                int second = A[j];
                int low = j + 1;
                int high = n - 1;

                while (low < high) {

                    int sum = start + second + A[low] + A[high];

                    if (sum > B) {
                        high--;
                    } else if (sum < B) {
                        low++;
                    } else {
                        ArrayList<Integer> result = new ArrayList<>();
                        result.add(start);
                        result.add(second);
                        result.add(A[low]);
                        result.add(A[high]);
                        String r = start + "$" + second + "$" + A[low] + "$" + A[high];
                        if (!sets.contains(r)) {
                            resultList.add(result);
                            sets.add(r);
                        }
                        low++;
                        high--;
                    }
                }
            }

        }
        int size = resultList.size();
        int[][] result = new int[size][];

        for (int i = 0; i < size; i++) {
            result[i] = resultList.get(i).stream().mapToInt(x -> x).toArray();
        }
        return result;
    }
}


/*

    There is nothing in this question.
    Fix two variables i and i + 1
    and find two remaining variables from i + 2 to n.
    Now you can do.

    Use HashSet and String to find the already added answer.
 */