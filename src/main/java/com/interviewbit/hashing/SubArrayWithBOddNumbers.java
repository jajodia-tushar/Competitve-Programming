package com.interviewbit.hashing;

import com.interviewbit.utils.ArrayUtils;

/*
Problem Description

Given an array of integers A and an integer B.

Find the total number of subarrays having exactly B odd numbers.



Problem Constraints
1 <= length of the array <= 105

1 <= A[i] <= 109

0 <= B <= A



Input Format
The first argument given is the integer array A.
The second argument given is integer B.



Output Format
Return the total number of subarrays having exactly B odd numbers.



Example Input
Input 1:

 A = [4, 3, 2, 3, 4]
 B = 2
Input 2:

 A = [5, 6, 7, 8, 9]
 B = 3


Example Output
Output 1:

 4
Output 2:

 1


Example Explanation
Explanation 1:

 The subarrays having exactly B odd numbers are:
 [4, 3, 2, 3], [4, 3, 2, 3, 4], [3, 2, 3], [3, 2, 3, 4]
Explanation 2:

 The subarrays having exactly B odd numbers is [5, 6, 7, 8, 9]
 */

// SEEAGAIN IMP
public class SubArrayWithBOddNumbers {

    public static void main(String[] args) {
        SubArrayWithBOddNumbers obj = new SubArrayWithBOddNumbers();
        int[] ints = ArrayUtils.asArrays(4, 3, 2, 3, 4);
        int result = obj.countSubArrays(ints, 2);
        System.out.println(result);
    }

    public int countSubArrays(int a[], int m) {
        int n = a.length;
        int count = 0;
        int prefix[] = new int[n + 1];
        int odd = 0;

        // Traverse in the array
        for (int i = 0; i < n; i++) {
            prefix[odd]++;

            // If array element is odd
            if ((a[i] & 1) == 1)
                odd++;

            // When number of odd
            // elements >= M
            if (odd >= m)
                count += prefix[odd - m];
        }

        return count;
    }
}

/*
    This question looks simply on the eye but there is no optimized intuition to solve this anyway.
    It doesn't even seem like from Hashing as well.

    One way is to consider all the pairs as brute force but this is certainly not going to help.

    So The idea is to have a prefix array.
    prefix[]
    now don't get confused with the prefix word,
    The work of the prefix array is to store some number.

    At position i in the prefix array prefix[i] will store the number of prefixes that has i number of odd number.
    Now What I mean by prefixes is the sub-array ending at current index.

    Eg. [4,3,2,3,4,2,1,3,4]

    Prefix Array of This looks like [2,2,3,1,0,0,0,0,0,0]

    Now look at prefix[0] it says how many sub array are there that are ending at my index and are having 1 odd number,
      (0 based that's why we are saying 1)

       Clearly there are only two such sub array. [4,3] [3]

     Similarly prefix[1] is also 2 because [2,3] [3].


     Now what is the benefit of doing this. is
     if you want sub array with 1 odd number only it will be given by prefix[0].


     Until you look the code you are not really going to understand this answer.


     ============================================== GREAT EXPLANATION FROM STACKOVERFLOW ======================================

    This is task for two-pointer approach.

    Make two indexes - L and R.

    Set L to 0 and move R from 0 to the right, counting odd numbers in Od counter. When Od becomes m, remember R position as R0. Move R further until new odd number is met.

    Remember L position as L0 and increment L until odd number is met (stay if A[L0] is odd).

    Now all sub-arrays starting in L0..L range and ending in R0..R-1 range, contain exactly m odd numbers. There are Cnt = (L-L0+1) * (R-R0) such sub-arrays:

    m=3
           L0 L        R0           R
    i      0  1  2  3  4  5  6  7  8
    A[i]   4  1  3  2  5  6  2  2  3
    all sub-arrays starting in 0..1 and ending in 4..7, contain 3 odd numbers, here are 2 indexes for start and 4 indexes for end, so Cnt = 8

    Increment L, remember R0 again an repeat this procedure until array end, adding Cnt for every range set to the result

    Pointers traverse array only once, complexity is linear.


 */