package com.interviewbit.binarysearch;

public class WoodCuttingMadeEasy {

    public static void main(String[] args) {
        WoodCuttingMadeEasy obj = new WoodCuttingMadeEasy();
        int arr0[] = {20, 15, 10, 17};
        int arr1[] = {4, 42, 40, 26, 46};
        int arr2[] = {114, 55, 95, 131, 77, 111, 141};
        int A = 7;
        int B = 20;
        int C = 95;
        System.out.println(obj.solve(arr0,A));
        System.out.println(obj.solve(arr1,B));
        System.out.println(obj.solve(arr2,C));

    }

    public int solve(int[] A, int B) {

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < A.length; i++){
            int item = A[i];
            min = Math.min(min,item);
            max = Math.max(max,item);
        }


        int high = min;
        int low = max;

        long lowWood = calculateWood(A, low);
        if(lowWood == B) return low;

        long highWood = calculateWood(A, high);
        if(highWood == B) return high;

        int mid = 0;

        while(high <= low){
            mid = (low + high)/ 2;
            long woodCut = calculateWood(A,mid);
            if(woodCut > B){
                high = mid + 1;
            }
            else if(woodCut < B){
                low = mid - 1;
            }
            else{
                return mid;
            }
        }

        return low;
    }

    private long calculateWood(int[] A, int mid) {

        long sum = 0;
        for(int i = 0; i < A.length; i++){
            long item = A[i];
            if( item > mid)
                sum = sum + (item - mid);
        }

        return sum;

    }
}
