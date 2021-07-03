package com.interviewbit.twopointer;

import com.interviewbit.utils.ArrayUtils;

/*
Problem Description

Given an array A of N non-negative numbers and you are also given non-negative number B.

You need to find the number of subarrays in A having sum less than B. We may assume that there is no overflow.



Problem Constraints
1 <= N <= 104

1 <= A[i] <= 100

1 <= B <= 108



Input Format
First argument is an integer array A.

Second argument is an integer B.



Output Format
Return an integer denoting the number of subarrays in A having sum less than B.



Example Input
Input 1:

 A = [2, 5, 6]
 B = 10
Input 2:

 A = [1, 11, 2, 3, 15]
 B = 10


Example Output
Output 1:

 4
Output 2:

 4


Example Explanation
Explanation 1:

 The subarrays with sum less than B are {2}, {5}, {6} and {2, 5},
Explanation 2:

 The subarrays with sum less than B are {1}, {2}, {3} and {2, 3}
 */
// YOU MIGHT NEED TO VISIT THIS CHECKAGAIN
public class CountingSubArrays {

    public static void main(String[] args) {
        CountingSubArrays obj = new CountingSubArrays();
        System.out.println(obj.solveX(ArrayUtils.asArrays(99, 59, 62, 64, 57, 8, 79, 90, 36, 66, 76, 87, 87, 34, 61, 31, 49, 29, 93, 34, 41, 67, 36, 11, 100, 38, 93, 83, 29, 53, 70, 45, 95, 9, 53, 48, 33, 36, 9, 65, 98, 44, 50, 16, 42, 90, 1, 13, 49, 24, 52, 75, 34, 92, 1, 55, 91, 98, 20, 81, 79, 32, 45, 41, 88, 100, 26, 84, 39, 93, 94, 53, 12, 61, 35, 41, 98, 86, 30, 41, 6, 92, 93, 11, 50, 79, 80, 72, 78, 74, 94, 21, 98, 27, 77, 91, 83, 79, 60, 19, 90, 60, 50, 25, 73, 81, 9, 68, 9, 78, 4, 71, 8, 97, 75, 23, 12, 20, 62, 57, 91, 64, 84, 17, 33, 53, 42, 55, 14, 63, 97, 61, 16, 5, 100, 37, 81, 99, 33, 88, 85, 41, 18, 7, 71, 42, 83, 50, 24, 59, 6, 22, 96, 97, 17, 79, 79, 80, 59, 78, 51, 8, 30, 82, 96, 79, 77, 54, 100, 85, 66, 94, 9, 73, 44, 30, 15, 69, 56, 92, 74, 23, 49, 52, 87, 45, 47, 78, 18, 30, 17, 75, 92, 70, 13, 47, 94, 92, 16, 50, 58, 41, 53, 37, 52, 88, 27, 63, 56, 84, 95, 81, 98, 66), 66));
    }

    public int solve(int[] A, int B) {

        int n = A.length;
        int i = 0;
        int j = 0;
        int sum = 0;
        int count = 0;
        while (j < n) {
            if (sum < B) {
                sum += A[j];
                count = count + (j - i);
                j++;
            } else {
                while (sum >= B) {
                    sum = sum - A[i];
                    i++;
                }
            }
        }

        while (sum >= B) {
            sum = sum - A[i];
            i++;
        }
        int diff = j - i;

        return count + diff;
    }

    public int solveX(int[] A, int B) {

        int n = A.length;
        int start = 0;
        int end = 0;
        int count = 0;
        int sum = 0;

        while (end < n) {
            sum += A[end++];
            if (sum < B) {
                count += (end - start);
            } else {
                while (start < end && sum >= B) {
                    sum -= A[start];
                    start++;
                }
                count += (end - start);
            }
        }
        return count;
    }
}

/*
    This is quite Interesting Problem. The Question is from Sliding Window.
    Here we are adding A[end] to the Sum.
    and till sum < B.
    and for all these Cases we can add the count of sub-arrays to (end - start)
    Do this above in Copy and Pen for few positive scenarios and you will understand.

    Now if Sum exceeds B then we will need to increase start such that Sum becomes Less than B.
    Now we can again add the (end - start) in the count.

    Watch out the value of end.
    We are increasing the value of End even if sum is greater than B.
    The reason being count = end - start.
    At max the start can become till end - 1;
    Else where would be no values.
    Watch the SolveX function in the end.
 */