package com.interviewbit.backtracking;

import com.interviewbit.utils.ArrayUtils;

import java.util.ArrayList;
import java.util.Collections;

/*
Given a collection of integers that might contain duplicates, S, return all possible subsets.

Note:

Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
The subsets must be sorted lexicographically.
Example :

If S = [1,2,2], the solution is:

[
[],
[1],
[1,2],
[1,2,2],
[2],
[2, 2]
]
 */
public class SubsetsII {

    public static void main(String[] args) {
        SubsetsII obj = new SubsetsII();
        ArrayList<Integer> integers = ArrayUtils.asArrayList(12, 12, 12, 12, 13, 13, 14);
        System.out.println(obj.subsetsWithDup(integers));
    }

    ArrayList<ArrayList<Integer>> result;

    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> A) {
        Collections.sort(A);
        result = new ArrayList<>();
        result.add(new ArrayList<>());
        recursiveX(new ArrayList<>(), 0, A);
        return result;
    }

    public void recursiveX(ArrayList<Integer> currentList, int start, ArrayList<Integer> A) {

        int n = A.size();
        if (start >= n) return;

        ArrayList<Integer> newList = new ArrayList<>(currentList);
        newList.add(A.get(start));
        result.add(newList);
        recursiveX(newList, start + 1, A);
        while (start + 1 < n && A.get(start) == A.get(start + 1)) start++;
        recursiveX(currentList, start + 1, A);
    }
}

/*
    This Question is similar to the Subset first question.
    How to just take care of the Duplication.
    It is inspired from the CombinationSumII solution that we have done previously.

    If you considering the flow where current number is being discarded then properly discard the current
    number because if there are consecutive number the current number is not being discarded properly.

 */
