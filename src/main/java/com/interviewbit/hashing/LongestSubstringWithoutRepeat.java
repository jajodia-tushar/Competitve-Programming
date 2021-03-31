package com.interviewbit.hashing;

import java.util.HashMap;

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
}
