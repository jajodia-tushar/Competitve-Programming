package com.interviewbit.dp;

import com.interviewbit.utils.ArrayUtils;

public class SmallestSequenceWithGivenPrimes {

    public static void main(String[] args) {
        SmallestSequenceWithGivenPrimes obj = new SmallestSequenceWithGivenPrimes();

        int[] result = obj.solve(3, 11, 7, 50);
        ArrayUtils.printArray(result);
    }

    public int[] solve(int A, int B, int C, int D) {

        int[] result = new int[D];

        int[] index = new int[3];
        int[] factor = {A,B,C};
        int[] originalList = {A,B,C};

        int resultIndex = 0;
        for(int i = 0; i < D; i++){

            int min = factor[0];
            for(int j = 1; j < 3; j++){
                min = Math.min(min,factor[j]);
            }
            result[resultIndex++] = min;

            for(int k = 0; k < 3; k++){
                if(min == factor[k]){
                    factor[k] = originalList[k] * result[index[k]];
                    index[k]++;
                }
            }
        }

        return result;
    }
}
