package com.interviewbit.dp.greedyDB;

import com.interviewbit.utils.ArrayUtils;

public class TusharBirthdayBombs {
    public static void main(String[] args) {

        TusharBirthdayBombs obj = new TusharBirthdayBombs();
        int[] ints = ArrayUtils.asArrays(22692, 19309, 10377, 2225, 7455, 11158, 12946, 8630, 13168, 14312, 21396, 23230, 15051, 21052, 7784, 19786, 19719, 4471, 5395, 879, 4106, 17902, 18426, 17070, 16737, 18833, 19126, 8775, 8867, 20968, 8475, 22902, 15268, 10195, 118, 14066, 21344, 13055, 14039, 9504, 18711, 10426, 7725, 105, 22822, 15501, 19883, 17532);

        int[] result = obj.solve(1842, ints);
        ArrayUtils.printArray(result);

    }

    public int[] solve(int A, int[] B) {

        int n = B.length;
        int minValue = Integer.MAX_VALUE;
        int minIndex = -1;
        for(int i = 0; i < n; i++){
            if(minValue > B[i]){
                minValue = B[i];
                minIndex = i;
            }
        }

        int sizeOfArray = A/minValue;
        int[] array = new int[sizeOfArray];
        for(int i = 0; i < sizeOfArray; i++){
            array[i] = minIndex;
        }

        int currentStrength = sizeOfArray * minValue;
        solve(array,A,currentStrength,0,0,minValue,B);
        return array;
    }

    public void solve(int[] array, int A, int currentStrength,
                      int resultCurrIndex, int currIndex,int minValue, int[] B){

        if( B[currIndex] > minValue){
            int updatedStrength = currentStrength + B[currIndex] - minValue;
            if(updatedStrength <= A){
                if(resultCurrIndex < array.length){
                    array[resultCurrIndex] = currIndex;
                    solve(array,A,updatedStrength,resultCurrIndex + 1,currIndex,minValue,B);
                }
            }
            else{
                solve(array,A,currentStrength,resultCurrIndex,currIndex + 1,minValue,B);
            }
        }

        else{
            return;
        }

    }
}
