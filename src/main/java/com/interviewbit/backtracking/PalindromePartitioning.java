package com.interviewbit.backtracking;

import java.util.ArrayList;

/*
    Given a string s, partition s such that every string of the partition is a palindrome.
    Return all possible palindrome partitioning of s.
    For example, given s = "aab",
Return
  [
    ["a","a","b"]
    ["aa","b"],
  ]
Ordering the results in the answer :
Entry i will come before Entry j if :

len(Entryi[0]) < len(Entryj[0]) OR
(len(Entryi[0]) == len(Entryj[0]) AND len(Entryi[1]) < len(Entryj[1])) OR
*
*
*
(len(Entryi[0]) == len(Entryj[0]) AND … len(Entryi[k] < len(Entryj[k]))
    In the given example,
   ["a", "a", "b"] comes before ["aa", "b"] because len("a") < len("aa")

 */

public class PalindromePartitioning {

    public static void main(String[] args) {

        PalindromePartitioning obj = new PalindromePartitioning();
        ArrayList<ArrayList<String>> result = obj.partition("aba");
        System.out.println(result);
    }

    public ArrayList<ArrayList<String>> partition(String a) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        ArrayList<String> currList = new ArrayList<>();
        recursive(result, a, currList);
        return result;
    }

    private void recursive(ArrayList<ArrayList<String>> result, String currentString, ArrayList<String> currList) {


        if (currentString.equals("")) {
            result.add(currList);
            return;
        }

        int l = currentString.length();
        for (int i = 1; i <= l; i++) {
            String subString = currentString.substring(0, i);
            if (isPalindrome(subString)) {
                ArrayList<String> newCurrList = new ArrayList<>(currList);
                newCurrList.add(subString);
                String remString = currentString.substring(i);
                recursive(result, remString, newCurrList);
            }
        }
    }

    private boolean isPalindrome(String A) {

        if (A.equals("")) return false;
        int i = 0;
        int n = A.length() - 1;
        while (i <= n) {
            if (A.charAt(i) == A.charAt(n)) {
                i++;
                n--;
            } else {
                return false;
            }
        }
        return true;
    }
}

/*
    This Question Seems intimidating,
    But then,
    You actually need to do partition can be anywhere at first position, second position or at n - 1 position.

    now if this partition is valid or not depends on two things,
    if the left and the right part is palindrome ( --> Not necessarily consolidated wise, you can assume the left part to be new String on it
        and right part to be new String again)

    So this the basics, Now you can go forward to build the answer.
 */