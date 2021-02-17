package com.october.binarysearch;

import com.october.week20.RotateMatrix;

public class RotatedSortedArraySearch {

    public static void main(String[] args) {
        RotatedSortedArraySearch obj = new RotatedSortedArraySearch();
        int[] arr = { 1, 7, 67, 133, 178 };
        System.out.println(obj.search(arr,178));
    }

    public int search(final int[] A, int B) {

        if (A.length == 0)
            return -1;

        int low = 0;
        int high = A.length - 1;

        while(low < high){

            int mid = low + (high - low)/2;

            if(A[mid] > A[high]){
                low = mid + 1;
            }
            else{
                high = mid;
            }
        }

        int start = low;

        if( B >= A[start] && B <= A[A.length - 1]){
            high = A.length - 1;
        }
        else{
            low = 0;
            high = start - 1;
        }


        while(low <= high){

            int mid = low + (high - low)/2;


            if( A[mid] > B)
                high = mid - 1;
            else if( A[mid] < B)
                low = mid + 1;
            else
                return mid;

        }

        return -1;
    }

}
