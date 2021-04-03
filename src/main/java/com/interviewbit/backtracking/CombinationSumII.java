package com.interviewbit.backtracking;

import com.interviewbit.utils.ArrayUtils;

import java.util.ArrayList;
import java.util.Collections;

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
