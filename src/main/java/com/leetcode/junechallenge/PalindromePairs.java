package com.leetcode.junechallenge;

import com.interviewbit.hashing.PairsWithGivenXor;

import java.util.*;


/*

    Given a list of unique words, return all the pairs of the distinct indices (i, j) in the given list,
    so that the concatenation of the two words words[i] + words[j] is a palindrome.

    Example 1:
    Input: words = ["abcd","dcba","lls","s","sssll"]
    Output: [[0,1],[1,0],[3,2],[2,4]]
    Explanation: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]

    Example 2:
    Input: words = ["bat","tab","cat"]
    Output: [[0,1],[1,0]]
    Explanation: The palindromes are ["battab","tabbat"]

    Example 3:
    Input: words = ["a",""]
    Output: [[0,1],[1,0]]

    Constraints:
    1 <= words.length <= 5000
    0 <= words[i].length <= 300
    words[i] consists of lower-case English letters.

 */

public class PalindromePairs {

    public static void main(String[] args) {

        PalindromePairs obj = new PalindromePairs();
        String[] stringList = new String[]{"abcd", "dcba", "lls", "s", "sssll"};
        List<List<Integer>> result = obj.palindromePairs(stringList);
        System.out.println(result);

    }

    public List<List<Integer>> palindromePairs(String[] words) {

        Map<String, Integer> wordsMap = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            wordsMap.put(words[i], i);
        }

        for (int i = 0; i < words.length; i++) {

            if (words[i].equals("")) {
                for (int j = 0; j < words.length; j++) {

                    if (isPalindrome(words[j], 0, words[j].length() - 1) && j != i) {
                        result.add(List.of(i, j));
                        result.add(List.of(j, i));
                    }
                }
            } else {
                StringBuilder sb = new StringBuilder(words[i]);
                sb.reverse();

                String reversedString = sb.toString();

                if (wordsMap.containsKey(reversedString)) {
                    int res = wordsMap.get(reversedString);
                    if (res != i) result.add(List.of(i, res));
                }

                for (int j = 1; j < reversedString.length(); j++) {
                    if (isPalindrome(reversedString, 0, j - 1)) {
                        String subString = reversedString.substring(j);
                        if (wordsMap.containsKey(subString)) {
                            result.add(List.of(i, wordsMap.get(subString)));
                        }
                    }

                    if (isPalindrome(reversedString, j, reversedString.length() - 1)) {
                        String subString = reversedString.substring(0, j);
                        if (wordsMap.containsKey(subString)) {
                            result.add(List.of(wordsMap.get(subString), i));
                        }
                    }
                }
            }
        }
        return result;
    }


    public boolean isPalindrome(String str, int i, int j) {
        while (i < j) {
            if (str.charAt(i++) != str.charAt(j--))
                return false;
        }
        return true;
    }
}

/*
    You only need to find the pair.
    So there are some of the Edge cases,

    Edge cases,
        1. If there is a empty String, Then it will pair with all palindrome String.
        2. If you find the reverse of Current String, These Two will make a Pair.
        3. If Some part of the String is Palindrome and You are able to find the reverse of
            Remaining part.

        Now you will need to optimize things as much as possible,
        See you will need searching at each point and you will need to look the indexes,
        So You can use HashMap<String, Integer> for searching string and it's indexes.

        You will need to reverse at each point in substring part.
        So reversing is costly.
        So you reverse the whole string and you iterate so you will just need to find the
        substring.
        Look the Code you will understand.
 */