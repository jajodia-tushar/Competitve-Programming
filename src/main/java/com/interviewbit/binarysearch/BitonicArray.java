package com.interviewbit.binarysearch;

/*
Problem Description

Given a bitonic sequence A of N distinct elements, write a program to find a given element B in the bitonic sequence in O(logN) time.

NOTE:

A Bitonic Sequence is a sequence of numbers which is first strictly increasing then after a point strictly decreasing.


Problem Constraints
3 <= N <= 105

1 <= A[i], B <= 108

Given array always contain a bitonic point.

Array A always contain distinct elements.



Input Format
First argument is an integer array A denoting the bitonic sequence.

Second argument is an integer B.



Output Format
Return a single integer denoting the position (0 index based) of the element B in the array A if B doesn't exist in A return -1.



Example Input
Input 1:

 A = [3, 9, 10, 20, 17, 5, 1]
 B = 20
Input 2:

 A = [5, 6, 7, 8, 9, 10, 3, 2, 1]
 B = 30


Example Output
Output 1:

 3
Output 2:

 -1


Example Explanation
Explanation 1:

 B = 20 present in A at index 3
Explanation 2:

 B = 30 is not present in A
 */
public class BitonicArray {

    public static void main(String[] args) {
        BitonicArray obj =new BitonicArray();


        int[] ints = {1,2};
        System.out.println(obj.findPeakElement(ints));
    }


    public int solve(int[] A, int B) {
        int bitonicPoint = findBitonicPoint(A);

        int index = binarySearchNormal(0,bitonicPoint,B,A);
        return index != -1 ? index : binarySearchReverse(bitonicPoint,A.length -1 ,B,A);
    }


    public int binarySearchNormal(int low, int high, int num, int[] A){

        while(high >= low){

            int mid = (high + low) / 2;

            if( A[mid] > num){
                high = mid - 1;
            }
            else if( A[mid] < num){
                low = mid + 1;
            }
            else{
                return mid;
            }
        }

        return -1;
    }

    public int binarySearchReverse(int low, int high, int num, int[] A){

        while(high >= low){

            int mid = (high + low) / 2;

            if( A[mid] < num){
                high = mid - 1;
            }
            else if( A[mid] > num){
                low = mid + 1;
            }
            else{
                return mid;
            }
        }

        return -1;
    }



    public int findBitonicPoint(int[] A) {

        int low = 0;
        int high = A.length;

        while (high > low) {
            int mid = (low + high) / 2;
            int midElement = A[mid];

            int midLeft = mid - 1;
            int midRight = mid + 1;

            if ((midLeft >= 0 && A[midLeft] >= midElement)) {
                high = mid;
            } else if ((midRight < A.length && A[midRight] >= midElement)) {
                low = mid;
            } else {
                return mid;
            }
        }

        if(A[0] > A[A.length - 1]){
            return 0;
        }
        else{
            return A.length - 1;
        }
    }

    public int findPeakElement(int[] nums) {

        int n = nums.length;
        int low = 0;
        int high = n;


        while( low < high){

            int mid = low + (high - low) / 2;
            int midValue = nums[mid];

            if( mid > 0 && nums[mid - 1] >= midValue){
                high = mid;
            }
            else if( mid < n - 1 && midValue <= nums[mid + 1]){
                low = mid;
            }
            else return mid;
        }
        return low;
    }

}

/*
    The process of doing this question is very similar to rotatedSortedArraySearch.
    But there the given array is rotatedSorted
    and here it is Bitonic


    4 5 6 7 0 1 2 3   -> Rotated Sorted Array.
    4 5 6 7 3 2 1 0   -> Bitonic Array.

    Just you have to find the main diversion point in this type of question.


 */