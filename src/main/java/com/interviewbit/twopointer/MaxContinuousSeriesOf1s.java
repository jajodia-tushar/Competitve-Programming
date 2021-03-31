package com.interviewbit.twopointer;

public class MaxContinuousSeriesOf1s {

    public static void main(String[] args) {

    }

    public int[] maxone(int[] A, int B) {

        int i = 0;
        int j = 0;
        int max = 0;
        int start = 0;
        int zeroCount = 0;
        while( j < A.length){

            if(zeroCount <= B){
                if(A[j] == 0)
                    zeroCount++;
                j++;
            }

            if(zeroCount > B){
                if(A[i] == 0)
                    zeroCount--;
                i++;
            }

            if(((j - i) > max) && (zeroCount <= B) ){
                max = j - i;
                start = i;
            }
        }

        int[] arr = new int[max];
        for(i = 0; i < arr.length; i++){
            arr[i] = start;
            start++;
        }

        return arr;

    }
}
