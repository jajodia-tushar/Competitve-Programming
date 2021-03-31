package com.interviewbit.week19;

public class FindDuplicateInArray {

    /*

    Given a read only array of n + 1 integers between 1 and n,
    find one number that repeats in linear time using less than O(n) space and traversing the stream sequentially O(1) times.

     */

    public static void main(String[] args) {


    }

    // This Process is Amazing as well.
    public int repeatedNumber2(final int[] A) {
        for(int i = 0; i < A.length; i++){
            int num = Math.abs(A[i]);
            if(A[num] < 0 ) {
                return num;
            }
            else{
                A[num] = -A[num];
            }
        }
        return -1;
    }

    public int repeatedNumber(final int[] A) {
        boolean[] arr = new boolean[A.length];

        for(int i = 0; i < A.length; i++){
            int num = A[i];
            if(arr[num - 1]){
                return num;
            }
            else{
                arr[num - 1] = true;
            }
        }

        return -1;
    }
}
