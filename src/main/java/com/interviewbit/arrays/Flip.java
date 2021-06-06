package com.interviewbit.arrays;


import com.interviewbit.utils.ArrayUtils;

/*
You are given a binary string(i.e. with characters 0 and 1) S consisting of characters S1, S2, …, SN. In a single operation, you can choose two indices L and R such that 1 ≤ L ≤ R ≤ N and flip the characters SL, SL+1, …, SR. By flipping, we mean change character 0 to 1 and vice-versa.
Your aim is to perform ATMOST one operation such that in final string number of 1s is maximised. If you don’t want to perform the operation, return an empty array. Else, return an array consisting of two elements denoting L and R. If there are multiple solutions, return the lexicographically smallest pair of L and R.

Notes:

Pair (a, b) is lexicographically smaller than pair (c, d) if a < c or, if a == c and b < d.
For example,

S = 010

Pair of [L, R] | Final string
_______________|_____________
[1 1]          | 110
[1 2]          | 100
[1 3]          | 101
[2 2]          | 000
[2 3]          | 001

We see that two pairs [1, 1] and [1, 3] give same number of 1s in final string. So, we return [1, 1].
Another example,

If S = 111

No operation can give us more than three 1s in final string. So, we return empty array [].

 */
public class Flip {
    public static void main(String[] args) {
        Flip obj = new Flip();
        String A = "010";
        int[] result = obj.flip(A);
        ArrayUtils.printArray(result);
    }

    public int[] flip(String A) {

        int localMax = 0;
        int globalMax = 0;
        int finalStart = -1;
        int finalEnd = -1;
        int localStart = 0;

        for (int i = 0; i < A.length(); i++) {

            char ch = A.charAt(i);
            int currentNumber = ch == '1' ? -1 : 1;

            localMax = localMax + currentNumber;

            if (globalMax < localMax) {
                globalMax = localMax;
                finalStart = localStart;
                finalEnd = i;
            }

            if (localMax < 0) {
                localMax = 0;
                localStart = i + 1;
            }
        }

        if (finalStart == -1) return new int[]{};
        return new int[]{finalStart + 1, finalEnd + 1};
    }
}

/*
    There is nothing much in this question as well.
    Just it is extension of the Kadene's Algorithm.
    You are assuming 1 as our enemy and 0 as our friend.
    so we will need the contiguous numbers of 0s.

    So we use Kadene's Algorithm to solve this.
    Just see the logic is in selecting the localStart variable.
    so if we are resetting localMax then we are setting localStart
    as i + 1;

 */
