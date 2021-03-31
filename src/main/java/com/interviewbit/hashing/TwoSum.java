package com.interviewbit.hashing;

import com.interviewbit.utils.ArrayUtils;

import java.util.HashMap;

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

        for(int i = 0; i < A.length; i++){
            if(!maps.containsKey(A[i]))
                maps.put(A[i],i);
        }

        for(int i = 0; i < A.length; i++){
            int diff = B - A[i];
            if(maps.containsKey(diff)){
                int index2 = Math.max(i, maps.get(diff)) + 1;
                int index1 = Math.min(i, maps.get(diff)) + 1;

                if(result[1] == 0 || index2 < result[1]){
                    result[1] = index2;
                    result[0] = index1;
                }
                else if(result[1] == index2){
                    result[0] = Math.min(index1,result[0]);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TwoSum obj = new TwoSum();
        int[] arr = ArrayUtils.asArrays(4, 7, -4, 2, 2, 2, 3, -5, -3, 9, -4, 9, -7, 7, -1, 9, 9, 4, 1, -4, -2, 3, -3, -5, 4, -7, 7, 9, -4, 4, -8);
        int[] ints = obj.twoSum(arr, -3);
        ArrayUtils.printArray(ints);
    }
}
