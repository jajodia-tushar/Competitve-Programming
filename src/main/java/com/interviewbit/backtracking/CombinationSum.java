package com.interviewbit.backtracking;

import com.interviewbit.utils.ArrayUtils;

import java.util.*;

/*

Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

 Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The combinations themselves must be sorted in ascending order.
CombinationA > CombinationB iff (a1 > b1) OR (a1 = b1 AND a2 > b2) OR … (a1 = b1 AND a2 = b2 AND … ai = bi AND ai+1 > bi+1)
The solution set must not contain duplicate combinations.
Example,
Given candidate set 2,3,6,7 and target 7,
A solution set is:

[2, 2, 3]
[7]
 Warning : DO NOT USE LIBRARY FUNCTION FOR GENERATING COMBINATIONS.
Example : itertools.combinations in python.
If you do, we will disqualify your submission retroactively and give you penalty points.


 */

public class CombinationSum {
    ArrayList<ArrayList<Integer>> answer;
    ArrayList<ArrayList<Integer>> result;

    public static void main(String[] args) {

        CombinationSum obj = new CombinationSum();
        System.out.println(obj.combinationSum(ArrayUtils.asArrayList(2,3,6,7), 7));
    }

    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        answer = new ArrayList<>();
        ArrayList<Integer> curr = new ArrayList<>();
        recursive(0, A, B, curr, 0);
        return answer;
    }

    public void recursive(int index, ArrayList<Integer> A, int B, ArrayList<Integer> curr, int currSum) {

        if (index == A.size())
            return;

        int tempSum = A.get(index) + currSum;

        if (tempSum < B) {
            ArrayList<Integer> newCurr = new ArrayList<>(curr);
            newCurr.add(A.get(index));
            recursive(index, A, B, newCurr, tempSum);
        } else if (tempSum == B) {
            ArrayList<Integer> newCurr = new ArrayList<>(curr);
            newCurr.add(A.get(index));
            answer.add(newCurr);
        } else {
            return;
        }

        int x = index + 1;
        while (x < A.size() && A.get(x) == A.get(index)) {
            x++;
        }
        recursive(x, A, B, curr, currSum);
    }

    public void recursiveX(ArrayList<Integer> A, ArrayList<Integer> currList,
                           int currSum, int B, int index) {

        int size = A.size();
        if (currSum == B) {
            result.add(currList);
            return;
        }
        if (currSum > B || index >= size) return;

        int item = A.get(index);
        if (currSum + item <= B) {
            ArrayList<Integer> newList = new ArrayList<>(currList);
            newList.add(item);
            recursiveX(A, newList, currSum + item, B, index + 1);
        }
        while (index + 1 < size && A.get(index) == A.get(index + 1))
            index++;  // This Line takes care of the Duplicate Answers.
        recursiveX(A, currList, currSum, B, index + 1);
    }
}

/*
    This One is Easy don't think too much just do it.
    This is kind of unlimited Knapsack problem.
    Just you need to take care of repeated answer.
    Since each number can be added unlimited number of times so while adding a particular
    number if you take the last occurrence of that number it will be fine.
 */

