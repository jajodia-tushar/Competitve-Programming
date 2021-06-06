package com.interviewbit.arrays;

import com.interviewbit.utils.ArrayUtils;

import java.util.*;

public class RotateMatrix {

    public static void main(String[] args) {

        RotateMatrix obj = new RotateMatrix();
        int[][] int1 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int[][] ints = {{13, 9, 5, 1}, {14, 10, 6, 2}, {15, 11, 7, 3}, {16, 12, 8, 4}};
        ArrayUtils.printArray(int1);
        System.out.println();
        ArrayUtils.printArray(ints);

    }

    public void rotate(ArrayList<ArrayList<Integer>> A) {
        int size = A.size();

        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                int temp = A.get(i).get(j);
                A.get(i).set(j, A.get(j).get(i));
                A.get(j).set(i, temp);

            }
        }

        for (int i = 0; i < size; i++) {
            Collections.reverse(A.get(i));
        }
    }
}

/*

    If you observe carefully you will get to know that the result is actually just reverse of transpose.
    So just use basics of transpose and reverse the list you will be good enough.

 */
