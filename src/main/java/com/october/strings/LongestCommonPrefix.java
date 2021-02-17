package com.october.strings;

import java.util.Arrays;

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
        if( n == 0) return str.toString();

        Arrays.sort(A);

        String strFirst = A[0];
        String strLast = A[n - 1];

        int min = strFirst.length();

        int i = 0;
        while(i < min){
            if(strFirst.charAt(i) == strLast.charAt(i)){
                str.append(strFirst.charAt(i));
                i++;
            }
            else{
                break;
            }
        }

        return str.toString();
    }
}
