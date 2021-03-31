package com.interviewbit.week20;

import java.util.Arrays;
import java.util.Comparator;

public class MaxDistance {

    public int maximumGap(final int[] A) {

        int n = A.length;
        if( n < 2)
            return 0;
        Point[] arr = new Point[n];

        for(int i = 0; i < n; i++){
            arr[i] = new Point(i,A[i]);
        }
        Arrays.sort(arr, Comparator.comparingInt(a -> a.value));

        int[] maxJ = new int[n];
        maxJ[n - 1] = arr[n -1].index;
        for(int i = n - 2; i >= 0; i--){
            maxJ[i] = Math.max(maxJ[i+1],arr[i].index);
        }

        int maxDiff = Integer.MIN_VALUE;
        for(int i = 0; i < n - 1; i++){
            int iIndex = arr[i].index;
            int diff = maxJ[i+1] - iIndex;
            maxDiff = Math.max(diff,maxDiff);
        }

        return maxDiff < 0 ? 0 : maxDiff;
    }
}

class Point{
    public int index;
    public int value;

    public Point(int index, int value){
        this.index = index;
        this.value = value;
    }
}

