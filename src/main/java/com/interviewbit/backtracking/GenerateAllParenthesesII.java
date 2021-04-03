package com.interviewbit.backtracking;

import java.util.ArrayList;

public class GenerateAllParenthesesII {
    public static void main(String[] args) {
        GenerateAllParenthesesII obj = new GenerateAllParenthesesII();
        ArrayList<String> arrayList = obj.generateParenthesis(3);
        System.out.println(arrayList);
    }

    public ArrayList<String> generateParenthesis(int A) {
        ArrayList<String> result = new ArrayList<>();
        recursive(result,A,0,0,"");
        return result;
    }

    public void recursive(ArrayList<String> result,int A,
                          int fCurr,int bCurr,String curr){

        if(curr.length() == A * 2){
            result.add(curr);
        }

        if(fCurr < A)
            recursive(result,A,fCurr+1,bCurr,curr+"(");

        if(bCurr < fCurr)
            recursive(result,A,fCurr,bCurr+1,curr+")");

    }
}
