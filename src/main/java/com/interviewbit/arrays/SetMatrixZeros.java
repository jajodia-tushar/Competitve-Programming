package com.interviewbit.arrays;

import com.interviewbit.utils.ArrayUtils;

import java.util.*;

public class SetMatrixZeros {
    public static void main(String[] args) {

        SetMatrixZeros obj = new SetMatrixZeros();
        ArrayList<Integer> row1 = ArrayUtils.asArrayList(1, 0, 1);
        ArrayList<Integer> row2 = ArrayUtils.asArrayList(1, 1, 1);
        ArrayList<Integer> row3 = ArrayUtils.asArrayList(1, 1, 1);

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        list.add(row1);
        list.add(row2);
        list.add(row3);

        obj.setZeroes(list);
        System.out.println(list);
    }

    public void setZeroes(ArrayList<ArrayList<Integer>> a) {


        int n = a.size();
        int m = a.get(0).size();

        boolean isFirstRowZero = false;
        boolean isFirstColZero = false;

        for (int i = 0; i < n; i++) {
            int item = a.get(i).get(0);
            if (item == 0) {
                isFirstColZero = true;
                break;
            }
        }

        for (int i = 0; i < m; i++) {
            int item = a.get(0).get(i);
            if (item == 0) {
                isFirstRowZero = true;
                break;
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int item = a.get(i).get(j);
                if (item == 0) {
                    a.get(i).set(0, 0);
                    a.get(0).set(j, 0);
                }
            }
        }

        // System.out.println(a);

        for (int i = 1; i < n; i++) {
            int item = a.get(i).get(0);
            if (item == 0) {
                for (int j = 1; j < m; j++) {
                    a.get(i).set(j, 0);
                }
            }
        }

        // System.out.println(a);

        for (int i = 1; i < m; i++) {
            int item = a.get(0).get(i);
            if (item == 0) {
                for (int j = 1; j < n; j++) {
                    a.get(j).set(i, 0);
                }
            }
        }

        // System.out.println(a);

        if (isFirstRowZero) {
            for (int i = 0; i < m; i++) {
                a.get(0).set(i, 0);
            }
        }


        if (isFirstColZero) {
            for (int i = 0; i < n; i++) {
                a.get(i).set(0, 0);
            }
        }

    }
}

/*
    The trap is if you traverse and keep updating you will end up messing it completely because the
    updated cell will be traversed and if it had 1 then you will now make it's row and column as well
    to zero.

    Using Extra space makes this question really simple.

    So the Idea is to use the first row and first column as the driving force
    so you first store whether first row and column needs to be made zero or not.

    Then you do normal traversal and when you find a zero you will have to make it's
    first cell in row and column to zero.

    Now traverse first row and column and update the values to zeros as required.
    Finally use the two variables to update the first row and columns



 */