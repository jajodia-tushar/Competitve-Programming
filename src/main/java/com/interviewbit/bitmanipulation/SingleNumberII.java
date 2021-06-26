package com.interviewbit.bitmanipulation;


/*
Given an array of integers, every element appears thrice except for one which occurs once.

Find that element which does not appear thrice.

Note: Your algorithm should have a linear runtime complexity.

Could you implement it without using extra memory?

Input Format:

    First and only argument of input contains an integer array A
Output Format:

    return a single integer.
Constraints:

2 <= N <= 5 000 000
0 <= A[i] <= INT_MAX
For Examples :

Example Input 1:
    A = [1, 2, 4, 3, 3, 2, 2, 3, 1, 1]
Example Output 1:
    4
Explanation:
    4 occur exactly once
Example Input 2:
    A = [0, 0, 0, 1]
Example Output 2:
    1
 */
// YOU MIGHT NEED TO VISIT THIS CHECKAGAIN
public class SingleNumberII {

    public static void main(String[] args) {

        SingleNumberII obj = new SingleNumberII();
        System.out.println(obj.singleNumber(new int[]{1, 2, 4, 3, 3, 2, 2, 3, 1, 1}));
    }

    public int singleNumber(final int[] A) {

        long[] count = new long[32];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < 32; j++) {
                if ((A[i] & (1L << j)) >= 1) {
                    count[j]++;
                }

                count[j] = count[j] % 3;
            }
        }
        long num = 0;
        for (int i = 31; i >= 0; i--) {
            if (count[i] == 1) {
                num = num + (1L << i);
            }
        }
        return (int) num;
    }
}

/*
    Try to Look from The perspective of a Bit.
    If you add bits.
    and do % 3 on every bit the number repeated 3 times will
    be cleared out.

 */