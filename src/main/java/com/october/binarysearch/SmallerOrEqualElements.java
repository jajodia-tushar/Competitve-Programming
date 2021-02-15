package com.october.binarysearch;

public class SmallerOrEqualElements {

    public static void main(String[] args) {

        SmallerOrEqualElements obj = new SmallerOrEqualElements();
        int arr[] = { 4, 4, 12, 12, 15, 19, 23, 24, 34, 42 };
        System.out.println(obj.solve(arr, 48));
    }

    public int solve(int[] A, int B) {

        int low = 0;
        int high = A.length - 1;
        int ans = -1;

        while(high >= low){

            int mid = (low + high) / 2;


            if(A[mid] < B){
                low = mid + 1;
            }
            else if(A[mid] > B){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }

        return high + 1;
    }
}
