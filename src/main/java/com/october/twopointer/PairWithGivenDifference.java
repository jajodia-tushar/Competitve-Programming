package com.october.twopointer;

import com.october.utils.ArrayUtils;

import java.util.Arrays;

public class PairWithGivenDifference {

    public static void main(String[] args) {
        int[] ints = ArrayUtils.asArrays(-509, -5);
        PairWithGivenDifference obj = new PairWithGivenDifference();
        System.out.println(obj.solve(ints,-95173));
    }

    public int solve(int[] A, int B) {

        Arrays.sort(A);
        int i = 0;
        int j = 1;

        while(j < A.length){

            int diff = A[j] - A[i];

            if(diff > B){
                i++;
            }
            else if( diff < B){
                j++;
            }
            else{
                return 1;
            }
        }

        return 0;
    }
}
