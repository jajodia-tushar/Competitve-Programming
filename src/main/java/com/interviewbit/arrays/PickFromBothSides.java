package com.interviewbit.arrays;

import com.interviewbit.utils.ArrayUtils;

import java.util.ArrayList;

public class PickFromBothSides {

    /*
    Given an integer array A of size N.
    You can pick B elements from either left or right end of the array A to get maximum sum.
    Find and return this maximum possible sum.
    NOTE: Suppose B = 4 and array A contains 10 elements then:
    You can pick first four elements or can pick last four elements or can pick 1 from front and 3 from back etc . you need to return the maximum possible sum of elements you can pick.

     */

    public static void main(String[] args) {

        PickFromBothSides obj = new PickFromBothSides();
        int[] ints = ArrayUtils.asArrays(-533, -666, -500, 169, 724, 478, 358, -38, -536, 705, -855, 281, -173, 961, -509, -5, 942, -173, 436, -609, -396, 902, -847, -708, -618, 421, -284, 718, 895, 447, 726, -229, 538, 869, 912, 667, -701, 35, 894, -297, 811, 322, -667, 673, -336, 141, 711, -747, -132, 547, 644, -338, -243, -963, -141, -277, 741, 529, -222, -684, 35);
        System.out.println(obj.solve(ints,48));


    }

    public int solve(int[] A, int B) {

        ArrayList<Integer> arrayList = new ArrayList<>();

        int sum = 0;
        int max = Integer.MIN_VALUE;
        int sumSize = 0;
        for(int i = 0; i < B; i++){
            arrayList.add(A[i]);
            sum += A[i];
        }

        max = sum;
        int n = A.length;

        for(int i = 0; i < B; i++){
            sum = sum + A[ n - 1 - i ] - A[B - 1 - i];
            if(sum > max){
                arrayList.remove(B - 1 - i);
                max = sum;
            }
        }
        System.out.println(arrayList);
        return max;
    }
}