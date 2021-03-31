package com.interviewbit.week9;

public class Thrusday {


    /*
    Balance Array
    Given an integer array A of size N. You need to count the number of special elements in the given array.
    A element is special if removal of that element make the array balanced.
    Array will be balanced if sum of even index element equal to sum of odd index element.


    The Idea behind this particular question is that if you remove the particular element from it's position all
    the remaining elements after this number will also change it's position.

    If you maintain the sum of oddIndex till now and Sum of EvenIndex elements till now for every 0 <= i < N
    and you know the sum of oddIndexRemaining and sum EvenIndexRemaining Sum at every i then
    you can compare if the

    (oddIndex sum till now + even Index Sum remaining) == (evenIndex sum till now + odd Index Sum Remaining)
       at any index i then that particular number is a special number.

    element at ith position should not be included in any sum.



     */

    public int solve(int[] A) {

        int oddSum = 0;
        int evenSum = 0;

        for (int i = 0; i < A.length; i++) {
            if ((i % 2) == 0)
                evenSum += A[i];
            else
                oddSum += A[i];
        }

        int oddSumTillNow = 0;
        int evenSumTillNow = 0;
        int oddRemaining = oddSum;
        int evenRemaining = evenSum;
        int specialCount = 0;

        for (int i = 0; i < A.length; i++) {

            if (i % 2 == 0)
                evenRemaining -= A[i];
            else
                oddRemaining -= A[i];

            if ((oddSumTillNow + evenRemaining) == (evenSumTillNow + oddRemaining)) {
                specialCount++;
            }

            if (i % 2 == 0)
                evenSumTillNow += A[i];
            else
                oddSumTillNow += A[i];

        }
        return specialCount;
    }
}
