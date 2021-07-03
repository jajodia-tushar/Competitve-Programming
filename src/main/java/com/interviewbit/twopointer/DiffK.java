package com.interviewbit.twopointer;

/*
Given an array ‘A’ of sorted integers and another non negative integer k, find if there exists 2 indices i and j such that A[i] - A[j] = k, i != j.

 Example: Input :
    A : [1 3 5]
    k : 4
 Output : YES as 5 - 1 = 4
Return 0 / 1 ( 0 for false, 1 for true ) for this problem

Try doing this in less than linear space complexity.
 */
public class DiffK {

    public static void main(String[] args) {

    }

    public int diffPossible(int[] A, int B) {

        int i = 0;
        int j = 1;

        while (j < A.length) {
            int sum = A[j] - A[i];

            if (j == i) {
                j++;
                continue;
            }


            if (sum > B) i++;
            else if (sum < B) j++;
            else return 1;
        }

        return 0;


    }
}

/*
    Same as Pair with Given Diff.
    Just If i == j i++; as we don't want i == j cases we want diff indexes.
 */