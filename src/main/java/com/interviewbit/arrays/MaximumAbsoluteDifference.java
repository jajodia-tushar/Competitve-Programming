package com.interviewbit.arrays;


/*
You are given an array of N integers, A1, A2 ,…, AN. Return maximum value of f(i, j) for all 1 ≤ i, j ≤ N.
f(i, j) is defined as |A[i] - A[j]| + |i - j|, where |x| denotes absolute value of x.

For example,

A=[1, 3, -1]

f(1, 1) = f(2, 2) = f(3, 3) = 0
f(1, 2) = f(2, 1) = |1 - 3| + |1 - 2| = 3
f(1, 3) = f(3, 1) = |1 - (-1)| + |1 - 3| = 4
f(2, 3) = f(3, 2) = |3 - (-1)| + |2 - 3| = 5

So, we return 5.
 */
public class MaximumAbsoluteDifference {

    public static void main(String[] args) {

        MaximumAbsoluteDifference obj = new MaximumAbsoluteDifference();
        int[] ints = {1, 3, -1};
        int result = obj.maxArr(ints);
        System.out.println(result);
    }

    public int maxArr(int[] A) {

        int n = A.length;
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++){
            max1 = Math.max(max1,A[i] + i);
            max2 = Math.max(max2,A[i] - i);
            min1 = Math.min(min1,A[i] + i);
            min2 = Math.min(min2,A[i] - i);
        }

        return Math.max(max1-min1,max2-min2);
    }
}

/*
    There can only be four cases in the Question for
    |A[i] - A[j]| + |i - j|

    1. i > j and A[i] > A[j] then the Equation Can be written as (A[i] + i) - (A[j] + j);
    2. i > j and A[i] < A[j] then the Equation Can be written as -(A[i] - i) + (A[j] - j);
    3. i < j and A[i] > A[j] then the Equation Can be written as (A[i] - i) - (A[j] - j);
    4. i < j and A[i] < A[j] then the Equation Can be written as -(A[i] + i) + (A[j] + j);

    or To write in clear manner it is
    1. (A[i] + i) - (A[j] + j);
    2. (A[j] - j) - (A[i] - i);
    3. (A[i] - i) - (A[j] - j);
    4. (A[j] + j) - (A[i] + i);

    so Essentially I will just have to track two values.
    A[i] + i and A[i] - i for all values of i ----------> right.( J is nothing just some other value of i right ? )
    now applying these values in the above equation we will get the result.

    If you watch carefully.
    A[i] + i is in negative sign with A[j] + j

    and
    A[i] - i is in negative Sign with A[j] - j;

    so for these equation to give max Result
    Fir Positive wala should be max and negative wala should be small.
    So We just have to now track two variables.

    A[i] + i and A[i] - i for max and min value.

    See the answer now
    and Try to understand you will get.
    There is nothing in this question as well.
    You are just tracking two variable for max and min
    because after you decomposed the equation only those
    two variables are appearing.
    And as you have to find the max answer so you are
    storing max and min for both the variable
    so you can do max - min.
    Now there can be actually

    4 cases but the good part is we don't want
    (A[i] + i) - (A[i] - i) these types of cases where both types of variables are being used
    our question doesn't want this. ? ( How ? After decomposing we saw this right? )
    You can do this.

 */
