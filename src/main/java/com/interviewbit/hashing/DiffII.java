package com.interviewbit.hashing;

import com.interviewbit.utils.ArrayUtils;

import java.util.HashMap;
import java.util.HashSet;

public class DiffII {

    public static void main(String[] args) {

        DiffII obj = new DiffII();
        int[] ints = ArrayUtils.asArrays(1, 5, 3);
        System.out.println(obj.diffPossible(ints,2));


    }

    public int diffPossible(final int[] A, int B) {

        int n = A.length;

        if( n < 2) return 0;
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            map.put(A[i],i);
        }

        for(int i = 0; i < n; i++){
            int diff = B + A[i];
            if(map.containsKey(diff) && (map.get(diff) != i)){
                return 1;
            }
        }

        return 0;
    }

    public int diffPossibleEfficient(final int[] A, int B) {

        int n = A.length;

        if( n < 2) return 0;
        HashSet<Integer> visitedSet = new HashSet<>();
        for(int i = 0; i < n; i++){

            if(visitedSet.contains(B - A[i]) || visitedSet.contains(B + A[i])){
                return 1;
            }
            visitedSet.add(A[i]);
        }



        return 0;
    }
}
