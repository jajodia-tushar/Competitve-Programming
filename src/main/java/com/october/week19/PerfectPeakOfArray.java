package com.october.week19;

public class PerfectPeakOfArray {


    public static void main(String[] args) {
        PerfectPeakOfArray obj = new PerfectPeakOfArray();
        int[] arr = {5, 1, 4, 3, 6, 8, 10, 7, 9};
        System.out.println(obj.perfectPeak(arr));
    }
    public int perfectPeak(int[] A) {

        int n = A.length;
        int[] suffix = new int[n];
        int[] prefix = new int[n];

        suffix[n - 1] = A[n-1];
        for(int i = n - 2; i >= 0; i--){
            suffix[i] = Math.min(suffix[i+1],A[i]);
        }

        prefix[0] = A[0];
        for( int i = 1; i < n; i++){
            prefix[i] = Math.max(prefix[i -1],A[i]);
        }

        for(int i = 1; i < n - 1; i++){
            int item = A[i];
            if(item > prefix[i -1] && item < suffix[i + 1])
                return 1;
        }

        return 0;
    }
}
