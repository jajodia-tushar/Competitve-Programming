package com.interviewbit.binarysearch;

public class SquareRootOfInteger {

    /*
    Given an integer A.
    Compute and return the square root of A.
    If A is not a perfect square, return floor(sqrt(A)).
    DO NOT USE SQRT FUNCTION FROM STANDARD LIBRARY
     */

    public int sqrt(int A) {

        if( A == 0 || A == 1)
            return A;

        int min = 1;
        int max = A;
        int ans = 0;

        while(min <= max){
            int mid = min + (max - min)/2;

            if( mid <= A/mid){
                ans = mid;
                min = mid + 1;
            }
            else{
                max = min - 1;
            }
        }
        return ans;
    }

}
