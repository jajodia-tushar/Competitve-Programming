package com.interviewbit.heapsandmaps;

import com.interviewbit.utils.ArrayUtils;

import java.util.*;

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

        PriorityQueue<PairSum> heap = new PriorityQueue<>(Comparator.comparing(x -> x.sum));

        Set<PairSum> alreadyAddedList = new HashSet<>();
        PairSum first = new PairSum(n - 1, n - 1, A[n - 1] + B[n - 1]);
        heap.add(first);
        alreadyAddedList.add(first);

        while (n-- > 0) {
            PairSum maxPair = heap.poll();
            result[resultIndex++] = maxPair.sum;

            if (maxPair.i - 1 >= 0) {
                PairSum p = new PairSum(maxPair.i - 1, maxPair.j, A[maxPair.i - 1] + B[maxPair.j]);
                if (!alreadyAddedList.contains(p)) {
                    heap.add(p);
                    alreadyAddedList.add(p);
                }
            }

            if (maxPair.j - 1 >= 0) {
                PairSum q = new PairSum(maxPair.i, maxPair.j - 1, A[maxPair.i] + B[maxPair.j - 1]);
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
        PairSum obj = (PairSum) o;
        return Integer.compare(obj.sum, this.sum);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PairSum pairSum = (PairSum) o;
        return i == pairSum.i &&
                j == pairSum.j;
    }

    @Override
    public int hashCode() {
        return Objects.hash(i, j);
    }
}
