package com.interviewbit.week20;

import java.util.ArrayList;

public class LeadersOfArray {

    public int[] solve(int[] A) {

        int maxTillNow = -1;
        int n = A.length - 1;

        ArrayList<Integer> array = new ArrayList<>();

        for(int i = n; i >= 0; i++){
            int item = A[i];
            if(item > maxTillNow){
                array.add(0,item);
            }
            maxTillNow = Math.max(item,maxTillNow);
        }
        return array.stream().mapToInt(x -> x).toArray();
    }
}
