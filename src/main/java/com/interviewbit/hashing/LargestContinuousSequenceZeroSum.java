package com.interviewbit.hashing;

import com.interviewbit.utils.ArrayUtils;

import java.util.HashMap;
import java.util.Map;

/*
Find the largest continuous sequence in a array which sums to zero.

Example:


Input:  {1 ,2 ,-2 ,4 ,-4}
Output: {2 ,-2 ,4 ,-4}

NOTE : If there are multiple correct answers, return the sequence which occurs first in the array.
 */
public class LargestContinuousSequenceZeroSum {

    public static void main(String[] args) {

        LargestContinuousSequenceZeroSum obj = new LargestContinuousSequenceZeroSum();
        int[] ints = {1, 2, -2, 4, -4};
        int[] result = obj.lszero(ints);
        ArrayUtils.printArray(result);
    }

    public int[] lszero(int[] A) {

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int n = A.length;
        int start = -1;
        int end = -1;
        int max = 0;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += A[i];
            if (map.containsKey(sum)) {
                int diff = i - map.get(sum);
                if (diff > max) {
                    start = map.get(sum) + 1;
                    end = i + 1;
                    max = diff;
                }
            } else
                map.put(sum, i);
        }

        int[] result = new int[end - start];

        for (int i = start; i < end; i++) {
            result[i - start] = A[i];
        }
        return result;
    }
}


/*
    This Technique is used a lot in upcoming types of problems as well.
    The idea is to take a variable sum and keep adding in the curr
    as you traverse the array.
    and also store the sum with the (index if not already present)

    If you are at index k with sum S
    and if you find already have sum S in the map at some point i
    then the sum between the i and K is zero right ?

    This is the basic idea.
    This technique is also used in counting the Number of SubSets with particular sum.
    Largest Sum with particular Sum.

    For Particular sum other than zero we will store in sum with index
    and while searching we can search if (sum - required) is present


       arr  -> 1 2 3 4 5 6 7 1 2 5
       find -> 12

       0    0
       11   1
       9    3
       6    6
       2    10
      -3    15




 */
