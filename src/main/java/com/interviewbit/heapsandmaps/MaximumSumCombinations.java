package com.interviewbit.heapsandmaps;

/*
Problem Description

Given two equally sized 1-D arrays A, B containing N integers each.

A sum combination is made by adding one element from array A and another element of array B.

Return the maximum C valid sum combinations from all the possible sum combinations.



Problem Constraints
1 <= N <= 105

1 <= A[i] <= 103

1 <= C <= N



Input Format
First argument is an one-dimensional integer array A of size N.

Second argument is an one-dimensional integer array B of size N.

Third argument is an integer C.



Output Format
Return a one-dimensional integer array of size C denoting the top C maximum sum combinations.

NOTE:

The returned array must be sorted in non-increasing order.



Example Input
Input 1:

 A = [3, 2]
 B = [1, 4]
 C = 2
Input 2:

 A = [1, 4, 2, 3]
 B = [2, 5, 1, 6]
 C = 4


Example Output
Output 1:

 [7, 6]
Output 1:

 [10, 9, 9, 8]


Example Explanation
Explanation 1:

 7     (A : 3) + (B : 4)
 6     (A : 2) + (B : 4)
Explanation 2:

 10   (A : 4) + (B : 6)
 9   (A : 4) + (B : 5)
 9   (A : 3) + (B : 6)
 8   (A : 3) + (B : 5)
 */

import com.interviewbit.utils.ArrayUtils;

import java.util.Objects;
import java.util.*;

public class MaximumSumCombinations {

    public static void main(String[] args) {
        MaximumSumCombinations obj = new MaximumSumCombinations();
        int[] A = ArrayUtils.asArrays(36, 27, -35, 43, -15, 36, 42, -1, -29, 12, -23, 40, 9, 13, -24, -10, -24, 22, -14, -39, 18, 17, -21, 32, -20, 12, -27, 17, -15, -21, -48, -28, 8, 19, 17, 43, 6, -39, -8, -21, 23, -29, -31, 34, -13, 48, -26, -35, 20, -37, -24, 41, 30, 6, 23, 12, 20, 46, 31, -45, -25, 34, -23, -14, -45, -4, -21, -37, 7, -26, 45, 32, -5, -36, 17, -16, 14, -7, 0, 37, -42, 26, 28);
        int[] B = ArrayUtils.asArrays(38, 34, -47, 1, 4, 49, -18, 10, 26, 18, -11, -38, -24, 36, 44, -11, 45, 20, -16, 28, 17, -49, 47, -48, -33, 42, 2, 6, -49, 30, 36, -9, 15, 39, -6, -31, -10, -21, -19, -33, 47, 21, 31, 25, -41, -23, 17, 6, 47, 3, 36, 15, -44, 33, -31, -26, -22, 21, -18, -21, -47, -31, 20, 18, -42, -35, -10, -1, 46, -27, -32, -5, -4, 1, -29, 5, 29, 38, 14, -22, -9, 0, 43);
        int[] result = obj.solve(A, B, 10);
        ArrayUtils.printArray(result);
    }

    public int[] solve(int[] A, int[] B, int C) {

        int n = A.length;
        int k = 0;
        Arrays.sort(A);
        Arrays.sort(B);

        int[] result = new int[C];

        PriorityQueue<PairWiseSum> heap = new PriorityQueue<>();
        HashSet<PairWiseSum> sets = new HashSet<>();
        PairWiseSum firstPair = new PairWiseSum(n - 1, n - 1, A[n - 1] + B[n - 1]);
        heap.add(firstPair);
        sets.add(firstPair);

        while (k < C) {
            PairWiseSum item = heap.poll();
            result[k++] = item.sum;

            PairWiseSum nextI = new PairWiseSum(item.i - 1, item.j, A[item.i - 1] + B[item.j]);
            PairWiseSum nextJ = new PairWiseSum(item.i, item.j - 1, A[item.i] + B[item.j - 1]);

            if (item.i - 1 >= 0) {
                if (!sets.contains(nextI)) {
                    heap.add(nextI);
                    sets.add(nextI);
                }
            }

            if (item.j - 1 >= 0) {
                if (!sets.contains(nextJ)) {
                    heap.add(nextJ);
                    sets.add(nextJ);
                }
            }
        }

        return result;
    }
}


class PairWiseSum implements Comparable<PairWiseSum> {

    public int i;
    public int j;
    public int sum;

    public PairWiseSum(int i, int j, int sum) {
        this.i = i;
        this.j = j;
        this.sum = sum;
    }

    @Override
    public int compareTo(PairWiseSum obj) {
        return Integer.compare(obj.sum, this.sum);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;

        if (o.getClass() != this.getClass()) return false;

        PairWiseSum item = (PairWiseSum) o;

        return this.i == item.i && this.j == item.j;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.i, this.j);
    }


}

/*
    This Question is exactly Similar to the one we have already done.
    NMaxPairCombination

 */