package com.interviewbit.backtracking;

import java.util.ArrayList;

public class Combinations {

    ArrayList<ArrayList<Integer>> answer;

    public static void main(String[] args) {

        Combinations obj = new Combinations();
        ArrayList<ArrayList<Integer>> combine = obj.combine(2, 1);
        System.out.println(combine);
    }

    public ArrayList<ArrayList<Integer>> combine(int A, int B) {
        answer = new ArrayList<>();
        ArrayList<Integer> currList = new ArrayList<>();
        recursive(A,B,currList,1);
        return answer;
    }

    public void recursive(int A,int B,ArrayList<Integer> currList,int currNum){

        if(currNum > A){
            return;
        }

        ArrayList<Integer> newList = new ArrayList<>(currList);
        newList.add(currNum);

        if(newList.size() == B){
            answer.add(newList);
        }
        else if(newList.size() > B){
            return;
        }

        recursive(A,B,newList,currNum+1);
        recursive(A,B,currList,currNum+1);
    }
}
