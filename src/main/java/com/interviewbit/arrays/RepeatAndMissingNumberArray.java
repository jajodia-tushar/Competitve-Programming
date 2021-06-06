package com.interviewbit.arrays;

import com.interviewbit.utils.ArrayUtils;

/*
You are given a read only array of n integers from 1 to n.

Each integer appears exactly once except A which appears twice and B which is missing.
Return A and B.
Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
Note that in your output A should precede B.
Example:
Input:[3 1 2 5 3]
Output:[3, 4]
A = 3, B = 4

 */
public class RepeatAndMissingNumberArray {

    public static void main(String[] args) {

        RepeatAndMissingNumberArray obj = new RepeatAndMissingNumberArray();
        int[] ints = {3, 1, 2, 5, 3};
        int[] result = obj.repeatedNumber(ints);
        ArrayUtils.printArray(result);

    }

    public int[] repeatedNumber(final int[] A) {

        int n = A.length;
        for (int i = 0; i < n; i++) {
            int index = Math.abs(A[i]);
            A[index - 1] = -A[index - 1];
        }

        int Ax = -1;
        int Bx = -1;

        for (int i = 0; i < n; i++) {
            if (A[i] > 0) {
                if (Ax == -1) {
                    Ax = i + 1;
                } else {
                    Bx = i + 1;
                    break;
                }
            }
        }

        boolean isApresent = false;
        for (int i = 0; i < n; i++) {
            if (Math.abs(A[i]) == Ax) {
                return new int[]{Ax, Bx};
            }
        }
        return new int[]{Bx, Ax};
    }
}

/*
     The idea to solve this problem is you are given numbers from range 1 to n;
     So if you use index of the array to store the information about whether a number
     is present or not.
     This is by simply multiplying the number with -1.
     and next time you traverse the array what you can do is look for the positive sign number.
     If a number has positive sign it means that either index at which it is currently is not present
     else it is present twice.
     You want both the numbers.
     So just save this two numbers

     Now the question is how do you distinguish between these two numbers.
     You can use the face that the repeated number must appear in the array so you can traverse the array again
     to find out the number which you are thinking as repeated number has appeared or not


     You can also know this in the second step as well.
     When you are multiplying the number with -1 see if the number at that index is already -1
     if so the number is repeating that's why someone before me has made it negative.



 */
