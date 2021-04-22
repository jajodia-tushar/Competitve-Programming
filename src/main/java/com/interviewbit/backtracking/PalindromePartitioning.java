package com.interviewbit.backtracking;

import java.util.ArrayList;

public class PalindromePartitioning {

    public static void main(String[] args) {

        PalindromePartitioning obj = new PalindromePartitioning();
        ArrayList<ArrayList<String>> result = obj.partition("aba");
        System.out.println(result);
    }

    public ArrayList<ArrayList<String>> partition(String a) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        ArrayList<String> currList = new ArrayList<>();
        recursive(result,a,currList);
        return result;
    }

    private void recursive(ArrayList<ArrayList<String>> result, String currentString, ArrayList<String> currList) {


        if(currentString.equals("")){
            result.add(currList);
            return;
        }

        int l = currentString.length();
        for(int i = 1; i <= l; i++){
            String subString = currentString.substring(0,i);
            if(isPalindrome(subString)){
                ArrayList<String> newCurrList = new ArrayList<>(currList);
                newCurrList.add(subString);
                String remString = currentString.substring(i);
                recursive(result,remString,newCurrList);
            }
        }
    }

    private boolean isPalindrome(String A) {

        if(A.equals("")) return false;
        int i = 0;
        int n = A.length() - 1;
        while(i <= n){
            if(A.charAt(i) == A.charAt(n)){
                i++;
                n--;
            }
            else{
                return false;
            }
        }
        return true;
    }
}
