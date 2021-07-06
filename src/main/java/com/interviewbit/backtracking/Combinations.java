package com.interviewbit.backtracking;

import java.util.ArrayList;

/*
Given two integers n and k, return all possible combinations of k numbers out of 1 2 3 ... n.

Make sure the combinations are sorted.

To elaborate,

Within every entry, elements should be sorted. [1, 4] is a valid entry while [4, 1] is not.
Entries should be sorted within themselves.
Example :

If n = 4 and k = 2, a solution is:

[
  [1,2],
  [1,3],
  [1,4],
  [2,3],
  [2,4],
  [3,4],
]
Warning : DO NOT USE LIBRARY FUNCTION FOR GENERATING COMBINATIONS.

Example : itertools.combinations in python.

If you do, we will disqualify your submission retroactively and give you penalty points.
 */


public class Combinations {

    ArrayList<ArrayList<Integer>> answer;
    ArrayList<ArrayList<Integer>> result;

    public static void main(String[] args) {

        Combinations obj = new Combinations();
        ArrayList<ArrayList<Integer>> combine = obj.combine(2, 1);
        System.out.println(combine);
    }

    public ArrayList<ArrayList<Integer>> combine(int A, int B) {
        answer = new ArrayList<>();
        ArrayList<Integer> currList = new ArrayList<>();
        recursive(A, B, currList, 1);
        return answer;
    }

    public void recursive(int A, int B, ArrayList<Integer> currList, int currNum) {

        if (currNum > A) {
            return;
        }

        ArrayList<Integer> newList = new ArrayList<>(currList);
        newList.add(currNum);

        if (newList.size() == B) {
            answer.add(newList);
        } else if (newList.size() > B) {
            return;
        }

        recursive(A, B, newList, currNum + 1);
        recursive(A, B, currList, currNum + 1);
    }


    public ArrayList<ArrayList<Integer>> combineX(int A, int B) {

        result = new ArrayList<>();
        recursiveX(1, new ArrayList<>(), B, A);
        return result;
    }

    public void recursiveX(int currentIndex, ArrayList<Integer> currList, int B, int A) {

        int size = currList.size();
        if (size == B) {
            result.add(currList);
            return;
        }

        for (int i = currentIndex; i <= A; i++) {
            ArrayList<Integer> newList = new ArrayList<>(currList);
            newList.add(i);
            recursiveX(i + 1, newList, B, A);
        }
    }
}

/*
    This Question is similar to SubSet question
    Just that the items inside the result must be in sorted order.
    and each subset should be of size B.
    So you can use the same concept and solve this question.

 */