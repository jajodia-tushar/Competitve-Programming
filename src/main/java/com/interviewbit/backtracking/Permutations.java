package com.interviewbit.backtracking;

/*
Given a collection of numbers, return all possible permutations.

Example:

[1,2,3] will have the following permutations:

[1,2,3]
[1,3,2]
[2,1,3]
[2,3,1]
[3,1,2]
[3,2,1]
NOTE

No two entries in the permutation sequence should be the same.
For the purpose of this problem, assume that all the numbers in the collection are unique.
Warning : DO NOT USE LIBRARY FUNCTION FOR GENERATING PERMUTATIONS.

Example : next_permutations in C++ / itertools.permutations in python.

If you do, we will disqualify your submission retroactively and give you penalty points.
 */

import com.interviewbit.utils.ArrayUtils;

import java.util.ArrayList;

// YOU MIGHT NEED TO VISIT THIS CHECKAGAIN
public class Permutations {

    public static void main(String[] args) {
        Permutations obj = new Permutations();
        ArrayList<Integer> list = ArrayUtils.asArrayList(1, 2, 3);
        ArrayList<ArrayList<Integer>> result = obj.permute(list);
        System.out.println(result);
    }

    ArrayList<ArrayList<Integer>> result;

    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {

        result = new ArrayList<>();
        int n = A.size();
        recursive(A, 0);
        return result;

    }

    public void recursive(ArrayList<Integer> list, int start) {

        int n = list.size();
        if (start == n)
            result.add(new ArrayList<>(list));

        for (int i = start; i < n; i++) {
            swap(list, start, i);
            recursive(list, start + 1);
            swap(list, start, i);
        }
    }

    public void swap(ArrayList<Integer> A, int i1, int i2) {
        int temp = A.get(i1);
        A.set(i1, A.get(i2));
        A.set(i2, temp);
    }
}

/*
    Swapping is the key here.
    Properly Swapping.

    If we say we are going to swap the current position starting from first position till end with the
        number starting from start till end recursively. We are done.

    eg.

    1,2,3

    We will swap 1 with 1,2,3
                 2 with 3,

                 in recursive fashion.

    Look the code you will understand.


 */