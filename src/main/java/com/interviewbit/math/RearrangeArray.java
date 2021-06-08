package com.interviewbit.math;

import com.interviewbit.utils.ArrayUtils;

import java.util.ArrayList;

/*

Rearrange a given array so that Arr[i] becomes Arr[Arr[i]] with O(1) extra space.
Example:
Input : [1, 0]
Return : [0, 1]
 Lets say N = size of the array. Then, following holds true :
All elements in the array are in the range [0, N-1]
N * N does not overflow for a signed integer

*/
public class RearrangeArray {

    public static void main(String[] args) {
        RearrangeArray obj = new RearrangeArray();
        ArrayList<Integer> ints = ArrayUtils.asArrayList(0, 2, 4, 3, 1);
        obj.arrange(ints);
        System.out.println(ints);
    }

    public void arrange(ArrayList<Integer> A) {

        int n = A.size();

        for (int i = 0; i < n; i++) {

            int oldValue = A.get(i);
            int newValue = A.get(oldValue);
            int finalValue = oldValue + (newValue % n) * n;
            A.set(i, finalValue);
        }

        for (int i = 0; i < n; i++) {
            A.set(i, A.get(i) / n);
        }

    }

}


/*
    What an amazing logic to solve this question.
    See if we were allowed to use extra space then It would be very easy question.

    But we are not allowed to use extra spaces.
    Now we will have to use the same array to store the data as well.
    So we will need to figure out a way to store old value as well as new value in the same position.

    See the idea:
        Given numbers are in range meaning they are from 0 - ( n - 1)
        so if we add a multiple of n in this number.
        then we can perform get old value as well and new value that was added as well.

        for old value we have to do MOD(%) n, It works because new number was multiple of n so
        mod will give 0 on that and you will only be left with old value.

        For new value we have to do DIVIDE(/) n, It works because the original number was in range 0 - (n - 1)
        so divide for this will be 0 and we have multiplied new number with n so dividing will give us new number.

        Such an amazing technique.
 */
