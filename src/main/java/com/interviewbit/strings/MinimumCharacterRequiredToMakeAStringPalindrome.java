package com.interviewbit.strings;


/*
Given an string A. The only operation allowed is to insert  characters in the beginning of the string.

Find how many minimum characters are needed to be inserted to make the string a palindrome string.




Input Format

The only argument given is string A.
Output Format

Return the minimum characters that are needed to be inserted to make the string a palindrome string.
For Example

Input 1:
    A = "ABC"
Output 1:
    2
    Explanation 1:
        Insert 'B' at beginning, string becomes: "BABC".
        Insert 'C' at beginning, string becomes: "CBABC".

Input 2:
    A = "AACECAAAA"
Output 2:
    2
    Explanation 2:
        Insert 'A' at beginning, string becomes: "AAACECAAAA".
        Insert 'A' at beginning, string becomes: "AAAACECAAAA".
Note:You only need to implement the given function. Do not read input, instead use the arguments to the function. Do not print the output, instead return values as specified. Still have a doubt? Checkout Sample Codes for more details.
 */

// YOU MIGHT NEED TO VISIT THIS CHECKAGAIN
public class MinimumCharacterRequiredToMakeAStringPalindrome {

    public static void main(String[] args) {

        MinimumCharacterRequiredToMakeAStringPalindrome obj = new MinimumCharacterRequiredToMakeAStringPalindrome();
        System.out.println(obj.solve("AACECXAAAABUILDERAAABBBCCCAAA"));
    }

    public int solve(String A) {

        StringBuilder reverse = new StringBuilder(A).reverse();
        String finalString = A + "$" + reverse.toString();

        int n = finalString.length();
        int[] lps = new int[n];
        lps[0] = 0;
        int len = 0;
        int i = 1;

        while (i < n) {

            if (finalString.charAt(i) == finalString.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {

                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return A.length() - lps[n - 1];
    }
}

/*
    Amazing Technique to Solve this Using LPS.
 */