package com.interviewbit.hashing;

import java.util.*;


/*
Given a string,
find the length of the longest substring without repeating characters.

Example:

The longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.

For "bbbbb" the longest substring is "b", with the length of 1.
 */

public class LongestSubstringWithoutRepeat {
    public static void main(String[] args) {

        LongestSubstringWithoutRepeat obj = new LongestSubstringWithoutRepeat();
        System.out.println(obj.lengthOfLongestSubstring("abcabcbb"));
    }

    public int lengthOfLongestSubstring(String A) {

        HashMap<Character, Integer> maps = new HashMap<>();

        int n = A.length();
        int maxLength = Integer.MIN_VALUE;
        int i = 0;
        int start = 0;

        while (i < n) {
            char ch = A.charAt(i);
            if (maps.containsKey(ch)) {
                i = maps.get(ch) + 1;
                start = i;
                maps = new HashMap<>();
            } else {
                maps.put(ch, i);
                int size = i - start + 1;
                if (size > maxLength) {
                    maxLength = size;
                }
                i++;
            }
        }

        return maxLength;

    }

    public int lengthOfLongestSubstringX(String A) {

        Set<Character> sets = new HashSet<>();

        int start = 0;
        int end = 0;
        int n = A.length();
        int maxDiff = Integer.MIN_VALUE;
        String result = "";

        while (end < n) {
            Character chEnd = A.charAt(end);
            while (sets.contains(chEnd) && start <= end) {
                Character chStart = A.charAt(start);
                if (sets.contains(chStart)) sets.remove(chStart);
                start++;
            }
            sets.add(chEnd);
            int currDiff = end + 1 - start;
            if (currDiff > maxDiff) {
                maxDiff = currDiff;
            }
            end++;
        }
        return maxDiff;
    }
}

/*
    Both the approach can be used.
    HashMap seems to be good.
    If there is a repetition then we will make a fresh start from the next of the  initial occurrence of that particular
    Character.
    abcdebxyx
    here b is repeated at index 5 so we will make a fresh start from the next of the initial occurrence of b i.e. from index
    2, as index 1 is the initial occurrence of b.

 */