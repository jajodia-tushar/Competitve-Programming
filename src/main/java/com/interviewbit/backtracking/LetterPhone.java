package com.interviewbit.backtracking;


import java.util.ArrayList;

/*
Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.

The digit 0 maps to 0 itself.

The digit 1 maps to 1 itself.

Input: Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Make sure the returned strings are lexicographically sorted.
 */
public class LetterPhone {

    ArrayList<String> result;
    String[] mappings;

    public ArrayList<String> letterCombinations(String A) {

        mappings = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        result = new ArrayList<>();
        recursive("", 0, A);
        return result;
    }

    public void recursive(String currString, int currIndex, String A) {

        int size = A.length();
        int currSize = currString.length();

        if (size == currSize) {
            result.add(currString);
            return;
        }
        String letters = mappings[A.charAt(currIndex) - '0'];
        for (char ch : letters.toCharArray()) {
            recursive(currString + ch, currIndex + 1, A);
        }
    }
}

/*
    There is nothing in this question really. To be discussed.
    You can do it.
    Just store the mappings and try to iterate as per the condition.

 */