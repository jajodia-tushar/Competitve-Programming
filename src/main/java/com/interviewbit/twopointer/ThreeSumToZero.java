package com.interviewbit.twopointer;

import com.interviewbit.utils.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;

/*
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
Find all unique triplets in the array which gives the sum of zero.

Note:

 Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
The solution set must not contain duplicate triplets. For example, given array S = {-1 0 1 2 -1 -4}, A solution set is:
(-1, 0, 1)
(-1, -1, 2)
 */
public class ThreeSumToZero {

    public static void main(String[] args) {
        ThreeSumToZero obj = new ThreeSumToZero();
        int[] ints = ArrayUtils.asArrays(-1, 0, 1, 2, -1, -4);
        int[][] ints1 = obj.threeSum(ints);
        ArrayUtils.printArray(ints1);
    }

    public int[][] threeSum(int[] arr) {
        Arrays.sort(arr);
        ArrayList<int[]> finalList = new ArrayList<>();
        for (int i = 0; i < arr.length - 2; i++) {

            if (i == 0 || (i > 0 && arr[i] != arr[i - 1])) {
                int j = i + 1;
                int k = arr.length - 1;

                while (j < k) {
                    int sum = arr[i] + arr[j] + arr[k];

                    if (sum > 0)
                        k--;
                    else if (sum < 0)
                        j++;
                    else {
                        if (!finalList.isEmpty()) {
                            int[] ints = finalList.get(finalList.size() - 1);
                            if (ints[0] != arr[i] || ints[1] != arr[j] || ints[2] != arr[k])
                                finalList.add(new int[]{arr[i], arr[j], arr[k]});
                        } else {
                            finalList.add(new int[]{arr[i], arr[j], arr[k]});
                        }
                        j++;
                        k--;
                    }
                }
            }


        }
        int[][] A = new int[finalList.size()][3];
        int i = 0;
        for (int[] x : finalList) {
            A[i++] = x;
        }

        return A;
    }
}

/*
    Same as the Two Sum Just need to think about how to avoid duplicate.
    For that we can have a hasSet. or thing like that.

    Or we can smartly Skip the repeated numbers as the array is sorted now.
    So while traversing the array if the next element is same as the previous
    element we can skip this. in the number that is fixed. The left as well as the right array.
    Or we can have actually remove them from the array altogether in the initial phase only.
 */