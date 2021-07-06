package com.interviewbit.backtracking;

import com.interviewbit.utils.ArrayUtils;

import java.util.ArrayList;
import java.util.Collections;
/*
Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

 Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
Example :

Given candidate set 10,1,2,7,6,1,5 and target 8,

A solution set is:

[1, 7]
[1, 2, 5]
[2, 6]
[1, 1, 6]
 Warning : DO NOT USE LIBRARY FUNCTION FOR GENERATING COMBINATIONS.
Example : itertools.combinations in python.
If you do, we will disqualify your submission retroactively and give you penalty points.
 */
public class CombinationSumII {
    public static void main(String[] args) {

        CombinationSumII obj = new CombinationSumII();
        System.out.println(obj.combinationSum(ArrayUtils.asArrayList( 15,8,15,10,19,18,10,3,11,7,17),33));
    }

    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int b) {
        ArrayList<ArrayList<Integer>> answer;
        Collections.sort(A);
        answer = new ArrayList<>();
        ArrayList<Integer> curr = new ArrayList<>();
        recursive(0,A,b,curr,0,answer);
        return answer;
    }

    public void recursive(int index, ArrayList<Integer> A,
                          int target, ArrayList<Integer> curr, int currTarget, ArrayList<ArrayList<Integer>> answer){

        if(index == A.size())
            return;

        int newTarget = currTarget + A.get(index);

        if(newTarget > target){
            return;
        }
        else if(newTarget == target){
            ArrayList<Integer> newCurr = new ArrayList<>(curr);
            newCurr.add(A.get(index));
            answer.add(newCurr);
            return;
        }
        int x = index + 1;
        ArrayList<Integer> newCurr = new ArrayList<>(curr);
        newCurr.add(A.get(index));
        recursive(x,A,target,newCurr,newTarget, answer);
        while(x < A.size() && A.get(x) == A.get(index)){
            x++;
        }
        recursive(x,A,target,curr,currTarget, answer);
    }
}

/*
    This one is classical Backtracking Problem.
    You just have to think about how do not added already added result.
    Now think about the same for a moment,

    You have already sorted the array right ?
    This is a knapsack variant question.

    for every number you have two choices i.e. either you add that number
    or you don't add that number.
    Lets say there are 1,2,3,4,5,15,15,18,19,20,21

    Now you are at the position of first 15 and you added 15 and made a recursive call.
    And now you have to make a another recursive call without 15.
    But if you
    simply do
    recursiveX(A, currList, currSum, B, index + 1);
    15 will be added freshly again and you will have multiple instance of same result.
    So the idea is to iterate using while to skip these consecutive 15 and call to
    directly 18.

    Will this not remove the case like 1,2,15,15,18 --> If this makes answer.
    Answer is No because you are not skipping the consecutive 15 while you are adding 15 result.
    So if 15, 15 will make the result that will be checked.
 */