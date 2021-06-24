package com.interviewbit.strings;


// YOU MIGHT NEED TO VISIT THIS CHECKAGAIN
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

    // This One is not very Optimized.
    public String longestPalindrome(String A) {

        int subStringStart = -1;
        int maxValue = Integer.MIN_VALUE;
        int endValue = -1;

        //Odd Length
        for (int i = 0; i < A.length(); i++) {
            int length = 1;
            int start = i - 1;
            int end = i + 1;
            while (isPalindrome(start, end, A)) {
                start--;
                end++;
                length += 2;
            }

            if (length > maxValue) {
                maxValue = length;
                subStringStart = start + 1;
                endValue = end - 1;
            }

            start = i - 1;
            end = i;
            length = 0;

            while (isPalindrome(start, end, A)) {
                start--;
                end++;
                length += 2;
            }

            if (length > maxValue) {
                maxValue = length;
                subStringStart = start + 1;
                endValue = end - 1;
            }
        }
        return A.substring(subStringStart, endValue + 1);
    }

    public boolean isPalindrome(int start, int end, String A) {
        return start >= 0 && end < A.length() && (A.charAt(start) == A.charAt(end));
    }

    public String longestPalindromeOptimized(String A) {

        int n = A.length();
        String result = "";

        // for odd Length
        int i = 0;
        while (i < n) {
            String tempResult = getMaxPalindromicString(A, i, i);
            if (tempResult.length() > result.length())
                result = tempResult;
            i++;
        }

        // for Even Length
        i = 0;
        while (i < n - 1) {
            String tempResult = getMaxPalindromicString(A, i, i + 1);
            if (tempResult.length() > result.length())
                result = tempResult;
            i++;
        }

        return result;
    }

    public String getMaxPalindromicString(String A, int start, int end) {
        int n = A.length();
        while (start >= 0 && end < n && A.charAt(start) == A.charAt(end)) {
            start--;
            end++;
        }
        return A.substring(start + 1, end);
    }
}

/*
    The Idea in the question is simple,
    See you can do this question using Dynamic programming like you generally do in Palindrome sub string.
    But it will result in TLE.


    So here this becomes little tricky.
    We need to realize that there can be 2N - 1 Centers in the String.

    N centers for N character ( This one is for odd length Palindrome)
        Eg for ABCBA --> We can have the center of the Palindromic String at A or B or C or B or A
        i.e. all the 5 locations. We don't know before hand any one from 5 can be right ?

    N - 1 centers for N - 1 joints between N character ( This one is for Even Length Palindrome)
        Eg for ABCBA --> We can have the center in between AB or BC or CB or BA
        the center in this case in ""

     so total of N + N - 1 = 2N - 1 centers.

     Now look the Questions Solution You will get.

 */
