package com.interviewbit.dp.greedyDB;

import com.interviewbit.utils.ArrayUtils;

public class MinJumpsArray {

    public static void main(String[] args) {
        MinJumpsArray obj = new MinJumpsArray();
        int[] ints = ArrayUtils.asArrays(2, 3, 1, 1, 4);
        int result = obj.jump(ints);
        System.out.println(result);
    }

    public int jump(int[] arr) {

        int maxDistance = 0;
        int currentPossible = 0;
        int actualJumps = 0;
        int n = arr.length;

        for(int i = 0; i < n - 1; i++){
            maxDistance = Math.max(maxDistance,arr[i]+i);
            if( currentPossible == i){
                currentPossible = maxDistance;
                actualJumps++;
            }
        }

        return currentPossible >= n - 1 ? actualJumps : -1;
    }

}
