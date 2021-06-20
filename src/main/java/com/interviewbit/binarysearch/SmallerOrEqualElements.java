package com.interviewbit.binarysearch;

/*
Problem Description

Given an sorted array A of size N. Find number of elements which are less than or equal to B.

NOTE: Expected Time Complexity O(log N)



Problem Constraints
1 <= N <= 106

1 <= A[i], B <= 109



Input Format
First agument is an integer array A of size N.

Second argument is an integer B.



Output Format
Return an integer denoting the number of elements which are less than or equal to B.



Example Input
Input 1:

 A = [1, 3, 4, 4, 6]
 B = 4
Input 2:

 A = [1, 2, 5, 5]
 B = 3


Example Output
Output 1:

 4
Output 2:

 2


Example Explanation
Explanation 1:

 Elements (1, 3, 4, 4) are less than or equal to 4.
Explanation 2:

 Elements (1, 2) are less than or equal to 3.
 */
public class SmallerOrEqualElements {

    public static void main(String[] args) {

        SmallerOrEqualElements obj = new SmallerOrEqualElements();
        int arr[] = {1, 3, 4, 4, 6};
        System.out.println(obj.solve(arr, 4));
    }

    public int solve(int[] A, int B) {

        int low = 0;
        int high = A.length - 1;

        while (high >= low) {

            int mid = (low + high) / 2;


            if (A[mid] < B) {
                low = mid + 1;
            } else if (A[mid] > B) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return high + 1;
    }
}

/*
    This one is fairly simple Question.
    Just use Binary Search.
    If the number that you are looking for is equal even then you will need to move towards right.
    the reason being you want all the number that are greater than equal to

    At last when the loop breaks you can return low or high + 1
    (high + 1 because before breaking high must have done mid - 1)
    or mid;


 */