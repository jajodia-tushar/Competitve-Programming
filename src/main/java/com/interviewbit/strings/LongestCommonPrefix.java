package com.interviewbit.strings;

import java.util.Arrays;
import java.util.LinkedHashMap;

public class LongestCommonPrefix {

    /*
    Given the array of strings A,
    you need to find the longest string S which is the prefix of ALL the strings in the array.

    Longest common prefix for a pair of strings S1 and S2 is the longest string S which is the prefix of both S1
    and S2.

    For Example, longest common prefix of "abcdefgh" and "abcefgh" is "abc".
     */

    public static void main(String[] args) {

        LongestCommonPrefix obj = new LongestCommonPrefix();
        String[] strings = {"abcd", "abcd", "efgh"};
        System.out.println(obj.longestCommonPrefix(strings));
    }

    public String longestCommonPrefix(String[] A) {
        int n = A.length;
        StringBuilder str = new StringBuilder();
        if (n == 0) return str.toString();

        Arrays.sort(A);

        String strFirst = A[0];
        String strLast = A[n - 1];

        int min = strFirst.length();

        int i = 0;
        while (i < min) {
            if (strFirst.charAt(i) == strLast.charAt(i)) {
                str.append(strFirst.charAt(i));
                i++;
            } else {
                break;
            }
        }

        return str.toString();
    }
}

/*
    You don't have to check for the prefix in all the array element.
    You can do it for just two the first and the last one .
    Can you do for any two items
    No it won't work that way because two element may have more common elements than the global.
    But the first and the last one after sorting will have the most number of difference in terms of
    characters so this technique works.
 */