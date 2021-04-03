package com.interviewbit.backtracking;

import com.interviewbit.utils.ArrayUtils;

import java.util.*;

public class CombinationSum {
    ArrayList<ArrayList<Integer>> answer;
    public static void main(String[] args) {

        CombinationSum obj = new CombinationSum();
        System.out.println(obj.combinationSum(ArrayUtils.asArrayList( 15,8,15,10,19,18,10,3,11,7,17),33));
    }

    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        answer = new ArrayList<>();
        ArrayList<Integer> curr = new ArrayList<>();
        recursive(0,A,B,curr,0);
        return answer;
    }

    public void recursive(int index,ArrayList<Integer> A, int B, ArrayList<Integer> curr, int currSum){

        if(index == A.size())
            return;

        int tempSum = A.get(index) + currSum;

        if(tempSum < B){
            ArrayList<Integer> newCurr = new ArrayList<>(curr);
            newCurr.add(A.get(index));
            recursive(index,A,B,newCurr,tempSum);
        }
        else if(tempSum == B){
            ArrayList<Integer> newCurr = new ArrayList<>(curr);
            newCurr.add(A.get(index));
            answer.add(newCurr);
        }
        else{
            return;
        }

        int x = index + 1;
        while(x < A.size() && A.get(x) == A.get(index)){
            x++;
        }
        recursive(x,A,B,curr,currSum);
    }
}
