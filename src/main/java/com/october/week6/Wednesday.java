package com.october.week6;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.List;

public class Wednesday {


    public static void main(String[] args) {

        Wednesday obj = new Wednesday();
        System.out.println(obj.maxSubArray(Arrays.asList(-2, -3, 4, -1, -2, 1, 5, -3)));

    }


    // Using Dynamic Programming.
    public int maxSubArray(final List<Integer> A) {
        int maxSum = A.get(0);
        int tempSum = maxSum;
        int i = 0;
        for (Integer item : A) {
            if (i == 0) {
                i = 1;
                continue;
            }
            tempSum = Math.max(item, tempSum + item);
            maxSum = Math.max(maxSum, tempSum);
        }
        return maxSum;
    }

    // Using Kadene's Method.
    public int maxSubArray(final int[] A) {
        int max = Integer.MIN_VALUE;
        int maxTillNow = 0;
        for (int i = 0; i < A.length; i++) {

            maxTillNow += A[i];
            if (maxTillNow > max) {
                max = maxTillNow;
            }
            if (maxTillNow < 0) {
                maxTillNow = 0;
            }
        }
        return max;
    }

}
/*

Max Sum Contiguous Sub Array;

Kadene's method suggests that you keep track of two values, the first one is the global maximum and the second one is the local maximum.
In the Problem one should keep two things in mind, we don't need the sub array we just need the sum and the second one is the
array has to be a contiguous array.

One simple thing to agree on to is that if by adding any number your sum goes below zero i.e. in negative than that part of the
sub array is not going to help you in getting the maximum sub array.


the idea is very simple as per the algorithm.
You start from the very first element of the array and then you keep adding the local maximum with the current element of the
array. If the local maximum is greater than the global maximum then you will surely need to update the global maximum and then move on.
If while adding the current element to local Maximum you get the result to be negative you will need to reset the local maximum to zero.
Which essentially means that you want to discard the current portion of the sub array and then you will need to start fresh from
next index ?
but what if the local Maximum had the global maximum.
No problem because you were constantly comparing local and global maximum and updating the global maximum if requried.




Dynamic Programming.
Dynamic Programming is nothing but just the optimization over the recursive solution.
What it says is that save the solution of the sub problem somewhere and then whenever in the recursion you will
need this you get it from the saved place instead of calculating again.

Eg.
Getting the Fibonacci Number of a particular Number.
You would quickly want to go for a recursive solution


public void fibonacci(int n){
    if( n <= 1)
        return n;
    return fibonacci(n - 1) + fibonacci(n -2);
}

this solution seems good until you start to analyze.

let's see the call.
fibonacci(10) ---> fibonacci(9) + fibonacci(8)
                fibonacci(8) + 7   7 + 6
               7 + 6  6 + 5      6 + 5 + 5 + 4
and so on.
first to calculate the fibonacci of 10 you will need fibonacci of 9 and to calculate that you will need fibonacci of 8 and 7
and so on till 1.
Here fibonacci of same number are required multiple times.
so instead of calculating over and over again what we can do is store the calculated value in array and then retrieve it in
next call before calculating.
as


public void fibonacci(int n){
        int f[] = new int[n + 1];

        f[0] = 0;
        f[1] = 1;

        for (int i = 2; i <= n; i++){
            f[i] = f[i - 1] + f[i -2];
        }

        return f[n];
}


this solution takes extra space but then it is efficient.


Using the same Dynamic Programming we can solve the maximum sub array problem simply by keeping in track of two things.

        1. Maximum till ith position can be equal to following two cases only
            i. Maximum till (i-1)th position + ith Value
            ii. ith Value.
        2. Global Maximum at ith position can only be the Maximum till ith position of the
        Maximum till i-1th position.


        It is a simple program as compare to the DP. Full DP is not used here. As we only need the maximum value not the
        Array that brings us the maximum value so the memory used to store the information required is small.
        Moreover it is a type of Tabulation form of DP.





 */
