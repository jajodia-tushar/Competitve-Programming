package com.interviewbit.backtracking;

import com.interviewbit.utils.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
Given a set of distinct integers, S, return all possible subsets.

 Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
Also, the subsets should be sorted in ascending ( lexicographic ) order.
The list is not necessarily sorted.
Example :

If S = [1,2,3], a solution is:

[
  [],
  [1],
  [1, 2],
  [1, 2, 3],
  [1, 3],
  [2],
  [2, 3],
  [3],
]
 */
public class Subset {

    public static void main(String[] args) {
        Subset obj = new Subset();
        ArrayList<Integer> integers = ArrayUtils.asArrayList(12, 13);
        System.out.println(obj.subsets(integers));

    }

    ArrayList<ArrayList<Integer>> answer = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        answer = new ArrayList<>();
        ArrayList<Integer> curr = new ArrayList<>();
        answer.add(new ArrayList<Integer>());
        recursive(0, A, curr);
        return answer;
    }

    public void recursive(int index, ArrayList<Integer> A, ArrayList<Integer> curr) {
        if (index == A.size())
            return;

        ArrayList<Integer> newCurr = new ArrayList<>(curr);
        newCurr.add(A.get(index));
        answer.add(newCurr);
        recursive(index + 1, A, newCurr);
        recursive(index + 1, A, curr);
    }

    ArrayList<ArrayList<Integer>> result;

    public ArrayList<ArrayList<Integer>> subsetsX(ArrayList<Integer> A) {

        Collections.sort(A);
        result = new ArrayList<>();
        recursiveX(new ArrayList<>(), 0, A);
        return result;
    }

    public void recursiveX(ArrayList<Integer> currentList, int start, ArrayList<Integer> A) {
        // Some Check
        result.add(currentList);
        int size = A.size();
        if (start >= size) return;

        for (int i = start; i < size; i++) {
            ArrayList<Integer> newList = new ArrayList<>(currentList);
            newList.add(A.get(i));
            recursiveX(newList, i + 1, A);
        }
    }
}

/*
    Look  in the Last Implementation.
    The problem is quite simple and easy to understand

    The issue that you were facing was,
    How to form the answer like [1,3] i.e. removing 2 and then adding 3.

    The idea for that is to to actually call recursively for 2 and then
    remove 2 from there and then add 3 and call for 3 recursively.
    To do this programmatically is to create a new List for the recursive calls every time.
    So there will be no headache for removing.

    How to solve without Arraylist ?

 */