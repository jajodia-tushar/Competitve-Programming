package com.interviewbit.heapsandmaps;

import com.interviewbit.utils.ArrayUtils;

import java.util.*;

public class DistinctNumbersInWindow {

    public static void main(String[] args) {

        DistinctNumbersInWindow obj = new DistinctNumbersInWindow();
        int[] ints = ArrayUtils.asArrays(1, 2, 1, 3, 4, 3);
        int[] result = obj.dNums(ints, 3);
        ArrayUtils.printArray(result);
    }

    public int[] dNums(int[] A, int B) {

        int n = A.length;
        int[] result = new int[n - B + 1];

        Map<Integer,Integer> maps = new HashMap<>();


        for(int i = 0; i < B; i++){
            maps.put(A[i],i);
        }

        int i = 0;
        for(; i < result.length - 1; i++){
            result[i] = maps.size();
            maps.put(A[i + B],i+B);
            if(maps.get(A[i]) == i){
                maps.remove(A[i]);
            }
        }

        result[i] = maps.size();

        return result;
    }
}
