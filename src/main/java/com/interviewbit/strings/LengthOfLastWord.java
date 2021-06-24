package com.interviewbit.strings;

/*
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

Example:

Given s = "Hello World",

return 5 as length("World") = 5.

Please make sure you try to solve this problem without using library functions. Make sure you only traverse the string once.
 */
public class LengthOfLastWord {

    public static void main(String[] args) {

    }

    public int lengthOfLastWord(final String A) {

        int n = A.length();
        int lastCharIndex = -1;
        int i = n - 1;

        while (i >= 0) {
            char ch = A.charAt(i);
            if (ch == ' ') {
                if (lastCharIndex != -1) return lastCharIndex - i;
            }

            if (Character.isAlphabetic(ch) && lastCharIndex == -1) {
                lastCharIndex = i;
            }
            i--;
        }

        if (lastCharIndex == -1) return 0;
        else return lastCharIndex + 1;
    }
}

/*
    Nothing much in this question.
    Just a lot of Edge cases.
    Start from End for opt

 */