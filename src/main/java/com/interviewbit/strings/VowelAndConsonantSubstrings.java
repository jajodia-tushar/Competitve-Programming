package com.interviewbit.strings;

/*
Problem Description

Given a string A consisting of lowercase characters.

You have to find the number of substrings in A which starts with vowel and end with consonants or vice-versa.

Return the count of substring modulo 109 + 7.



Problem Constraints
1 <= |A| <= 105

A consists only of lower-case characters.



Input Format
First argument is an string A.



Output Format
Return a integer denoting the the number of substrings in A which starts with vowel and end with consonants or vice-versa with modulo 109 + 7.



Example Input
Input 1:

 A = "aba"
Input 2:

 A = "a"


Example Output
Output 1:

 2
Output 2:

 0


Example Explanation
Explanation 1:

 Substrings of S are : [a, ab, aba, b, ba, a]Out of these only 'ab' and 'ba' satisfy the condition for special Substring. So the answer is 2.
Explanation 2:
 */

public class VowelAndConsonantSubstrings {

    public static void main(String[] args) {
        VowelAndConsonantSubstrings obj = new VowelAndConsonantSubstrings();
        int result = obj.solve("vnpbeutxfqxriiajoejjmtjcx");
        System.out.println(result);
    }

    public int solve(String A) {

        int MOD = 1000000007;
        int n = A.length();
        int start = 0;
        int end = n - 1;
        long count = 0;

        int[] vowels = new int[n + 1];
        int[] consts = new int[n + 1];

        if (isVowel(A.charAt(n - 1))) vowels[n - 1] = 1;
        else consts[n - 1] = 1;

        for (int i = n - 2; i >= 0; i--) {
            char ch = A.charAt(i);
            if (isVowel(ch)) {
                vowels[i] = 1 + vowels[i + 1];
                consts[i] = consts[i + 1];
            } else {
                consts[i] = 1 + consts[i + 1];
                vowels[i] = vowels[i + 1];
            }
        }

        for (int i = 0; i < n; i++) {
            char ch = A.charAt(i);
            if (isVowel(ch)) {
                count = (count + consts[i + 1]) % MOD;
            } else {
                count = (count + vowels[i + 1]) % MOD;
            }
        }
        return (int) count;
    }

    public boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

}

/*
        Read the question properly and then you shall use the property of suffix array and you can be able to solve this one.
 */
