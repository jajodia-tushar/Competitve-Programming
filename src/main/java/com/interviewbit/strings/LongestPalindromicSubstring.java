package com.interviewbit.strings;

public class LongestPalindromicSubstring {
        /*

        Given a string S, find the longest palindromic substring in S.
        Substring of string S:
        S[i...j] where 0 <= i <= j < len(S)
        Palindrome string:
        A string which reads the same backwards. More formally, S is palindrome if reverse(S) = S.
        Incase of conflict, return the substring which occurs first ( with the least starting index ).

         */

    public static void main(String[] args) {


    }

    public String longestPalindrome(String A) {

        int subStringStart = -1;
        int maxValue = Integer.MIN_VALUE;
        int endValue = -1;

        //Odd Length
        for(int i = 0; i < A.length(); i++){
            int length = 1;
            int start = i - 1;
            int end = i + 1;
            while(isPalindrome(start,end,A)){
                start--;
                end++;
                length += 2;
            }

            if(length > maxValue){
                maxValue = length;
                subStringStart = start+1;
                endValue = end - 1;
            }

            start = i - 1;
            end = i;
            length = 0;

            while(isPalindrome(start,end,A)){
                start--;
                end++;
                length += 2;
            }

            if(length > maxValue){
                maxValue = length;
                subStringStart = start + 1;
                endValue = end - 1;
            }
        }

        return A.substring(subStringStart,endValue+1);


    }

    public boolean isPalindrome(int start, int end, String A){
        return start >= 0 && end < A.length() && (A.charAt(start) == A.charAt(end));
    }

    
}
