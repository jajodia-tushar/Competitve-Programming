package com.interviewbit.backtracking;

import java.util.ArrayList;

/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses of length 2*n.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"
Make sure the returned list of strings are sorted.
 */

public class GenerateAllParenthesesII {

    ArrayList<String> result;

    public static void main(String[] args) {
        GenerateAllParenthesesII obj = new GenerateAllParenthesesII();
        ArrayList<String> arrayList = obj.generateParenthesis(3);
        System.out.println(arrayList);
    }

    public ArrayList<String> generateParenthesis(int A) {
        ArrayList<String> result = new ArrayList<>();
        recursive(result, A, 0, 0, "");
        return result;
    }

    public void recursive(ArrayList<String> result, int A,
                          int fCurr, int bCurr, String curr) {

        if (curr.length() == A * 2) {
            result.add(curr);
        }

        if (fCurr < A)
            recursive(result, A, fCurr + 1, bCurr, curr + "(");

        if (bCurr < fCurr)
            recursive(result, A, fCurr, bCurr + 1, curr + ")");

    }

    public ArrayList<String> generateParenthesisX(int A) {
        result = new ArrayList<>();
        recursive(A, 0, 0, "");
        return result;
    }

    public void recursive(int n, int forward, int backward, String currString) {

        if (backward > forward || forward > n) return;
        if (forward == backward && forward == n) {
            result.add(currString);
        }

        recursive(n, forward + 1, backward, currString + "(");
        recursive(n, forward, backward + 1, currString + ")");
    }
}

/*
    Think of backtracking questions as the questions of choice.
    At every point you have two choices,

    Either you add the left parenthesis or you add the right parenthesis.
    If at any moment left parenthesis < right parenthesis then you are
    heading towards some wrong answer.
    Return

    Else you continue the choices.

    If left == right == n then you are at a valid combination.
 */