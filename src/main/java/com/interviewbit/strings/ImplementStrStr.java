package com.interviewbit.strings;

/*
Please Note:
Another question which belongs to the category of questions which are intentionally stated vaguely.
Expectation is that you will ask for correct clarification or you will state your assumptions before you start coding.

Implement strStr().

 strstr - locate a substring ( needle ) in a string ( haystack ).
Try not to use standard library string functions for this question.

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

 NOTE: Good clarification questions:
What should be the return value if the needle is empty?
What if both haystack and needle are empty?
For the purpose of this problem, assume that the return value should be -1 in both cases.
 */
public class ImplementStrStr {

    public static void main(String[] args) {
        ImplementStrStr obj = new ImplementStrStr();
        String A = "babbaaabaaaabbababaaabaabbbbabaaaabbabbabaaaababbabbbaaabbbaaabbbaabaabaaaaababbaaaaaabababbbbba";
        String B = "bababbbbbbabbbaabbaaabbbaababa";
        int result = obj.strStr(A, B);
        System.out.println(result);
    }

    public int strStr(final String A, final String B) {

        int n = A.length();
        int m = B.length();

        if (m > n) return -1;

        int[] lps = getLPSArray(B);

        int i = 0;
        int j = 0;

        while (i < n) {
            if (A.charAt(i) == B.charAt(j)) {
                i++;
                j++;
                if (j == m) return i - m;
            } else {
                if (j != 0) j = lps[j - 1];
                else i++;
            }
        }
        return -1;
    }

    public int[] getLPSArray(String A) {

        int n = A.length();
        int[] lps = new int[n];
        int len = 0;
        int i = 1;
        lps[0] = 0;

        while (i < n) {
            if (A.charAt(i) == A.charAt(len)) lps[i++] = ++len;
            else {
                if (len != 0) len = lps[len - 1];
                else lps[i++] = 0;
            }
        }
        return lps;
    }
}

/*
    Best Question to Implement KMP Algorithm.
    Learn to calculate just LPS Array it is enough.

    To Calculate remember you will need to use len
    lps[0] = 0
    always.
    And LPS[i] will give you the index of the item in the pattern string from where you should
    compare current value of text with pattern.


 */