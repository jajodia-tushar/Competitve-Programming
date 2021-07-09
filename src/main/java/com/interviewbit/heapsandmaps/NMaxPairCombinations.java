package com.interviewbit.heapsandmaps;

import com.interviewbit.utils.ArrayUtils;

import java.util.*;

/*
Given two arrays A & B of size N each.

Find the maximum N elements from the sum combinations (Ai + Bj) formed from elements in array A and  B.

For example if A = [1,2], B = [3,4], then possible pair sums can be 1+3 = 4  , 1+4=5  ,   2+3=5   ,    2+4=6

and maximum 2 elements are 6, 5

Example:

N = 4

a[]={1,4,2,3}

b[]={2,5,1,6}

Maximum 4 elements of combinations sum are
10   (4+6),
9    (3+6),
9    (4+5),
8    (2+6)
 */

public class NMaxPairCombinations {

    public static void main(String[] args) {

        NMaxPairCombinations obj = new NMaxPairCombinations();
        int[] A = ArrayUtils.asArrays(36, 27, -35, 43, -15, 36, 42, -1, -29, 12, -23, 40, 9, 13, -24, -10, -24, 22, -14, -39, 18, 17, -21, 32, -20, 12, -27, 17, -15, -21, -48, -28, 8, 19, 17, 43, 6, -39, -8, -21, 23, -29, -31, 34, -13, 48, -26, -35, 20, -37, -24, 41, 30, 6, 23, 12, 20, 46, 31, -45, -25, 34, -23, -14, -45, -4, -21, -37, 7, -26, 45, 32, -5, -36, 17, -16, 14, -7, 0, 37, -42, 26, 28);
        int[] B = ArrayUtils.asArrays(38, 34, -47, 1, 4, 49, -18, 10, 26, 18, -11, -38, -24, 36, 44, -11, 45, 20, -16, 28, 17, -49, 47, -48, -33, 42, 2, 6, -49, 30, 36, -9, 15, 39, -6, -31, -10, -21, -19, -33, 47, 21, 31, 25, -41, -23, 17, 6, 47, 3, 36, 15, -44, 33, -31, -26, -22, 21, -18, -21, -47, -31, 20, 18, -42, -35, -10, -1, 46, -27, -32, -5, -4, 1, -29, 5, 29, 38, 14, -22, -9, 0, 43);

        int[] result = obj.solve(A, B);
        ArrayUtils.printArray(result);

    }

    public int[] solve(int[] A, int[] B) {

        int n = A.length;
        int[] result = new int[n];
        int resultIndex = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        PriorityQueue<PairWiseSum> heap = new PriorityQueue<>(Comparator.comparing(x -> x.sum));

        Set<PairWiseSum> alreadyAddedList = new HashSet<>();
        PairWiseSum first = new PairWiseSum(n - 1, n - 1, A[n - 1] + B[n - 1]);
        heap.add(first);
        alreadyAddedList.add(first);

        while (n-- > 0) {
            PairWiseSum maxPair = heap.poll();
            result[resultIndex++] = maxPair.sum;

            if (maxPair.i - 1 >= 0) {
                PairWiseSum p = new PairWiseSum(maxPair.i - 1, maxPair.j, A[maxPair.i - 1] + B[maxPair.j]);
                if (!alreadyAddedList.contains(p)) {
                    heap.add(p);
                    alreadyAddedList.add(p);
                }
            }

            if (maxPair.j - 1 >= 0) {
                PairWiseSum q = new PairWiseSum(maxPair.i, maxPair.j - 1, A[maxPair.i] + B[maxPair.j - 1]);
                if (!alreadyAddedList.contains(q)) {
                    heap.add(q);
                    alreadyAddedList.add(q);
                }
            }
        }

        return result;
    }

}


class PairSum implements Comparable {

    int i;
    int j;
    int sum;

    public PairSum(int i, int j, int sum) {
        this.i = i;
        this.j = j;
        this.sum = sum;
    }


    @Override
    public int compareTo(Object o) {
        PairWiseSum obj = (PairWiseSum) o;
        return Integer.compare(obj.sum, this.sum);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PairWiseSum pairWiseSum = (PairWiseSum) o;
        return i == pairWiseSum.i &&
                j == pairWiseSum.j;
    }

    @Override
    public int hashCode() {
        return Objects.hash(i, j);
    }
}

/*
       The Max will be A[n - 1] * B[m - 1]
       Now the second max can be
                    A[n - 2] * B[m - 1]   A = [6,5,4,3], B = [6,4,3,2]
                            OR
                    A[n - 1] * B[m - 1]   B = [6,5,4,3], A = [6,4,3,2]


       Extending this same technique more,
       We can say that if we know the current max, the next max will be
       n - 1 * m or n * m - 1 ( where n and m are the position in array A and B for current max value)

       We need the sets to keep track of already added items.
       And Heap to sort the items at runtime


       There is nothing More. It's Easy.
 */