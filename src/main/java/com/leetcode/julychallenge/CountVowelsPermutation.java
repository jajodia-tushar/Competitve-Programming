package com.leetcode.julychallenge;


/*
    Given an integer n, your task is to count how many strings of length n can be formed under the following rules:

Each character is a lower case vowel ('a', 'e', 'i', 'o', 'u')
Each vowel 'a' may only be followed by an 'e'.
Each vowel 'e' may only be followed by an 'a' or an 'i'.
Each vowel 'i' may not be followed by another 'i'.
Each vowel 'o' may only be followed by an 'i' or a 'u'.
Each vowel 'u' may only be followed by an 'a'.
Since the answer may be too large, return it modulo 10^9 + 7.



Example 1:

Input: n = 1
Output: 5
Explanation: All possible strings are: "a", "e", "i" , "o" and "u".
Example 2:

Input: n = 2
Output: 10
Explanation: All possible strings are: "ae", "ea", "ei", "ia", "ie", "io", "iu", "oi", "ou" and "ua".
Example 3:

Input: n = 5
Output: 68


Constraints:

1 <= n <= 2 * 10^4


 */
public class CountVowelsPermutation {
    public int MOD = 1000000007;

    public static void main(String[] args) {

        CountVowelsPermutation obj = new CountVowelsPermutation();
        int result = obj.countVowelPermutation(50);
        System.out.println(result);

    }

    public int countVowelPermutation(int n) {

        long[] aValue = new long[2];
        long[] eValue = new long[2];
        long[] iValue = new long[2];
        long[] oValue = new long[2];
        long[] uValue = new long[2];

        aValue[0] = 1;
        eValue[0] = 1;
        iValue[0] = 1;
        oValue[0] = 1;
        uValue[0] = 1;

        for (int i = 1; i < n; i++) {
            aValue[i % 2] = (eValue[(i + 1) % 2] + iValue[(i + 1) % 2] + uValue[(i + 1) % 2]) % MOD;
            eValue[i % 2] = (aValue[(i + 1) % 2] + iValue[(i + 1) % 2]) % MOD;
            iValue[i % 2] = (eValue[(i + 1) % 2] + oValue[(i + 1) % 2]) % MOD;
            oValue[i % 2] = (iValue[(i + 1) % 2]) % MOD;
            uValue[i % 2] = (iValue[(i + 1) % 2] + oValue[(i + 1) % 2]) % MOD;

        }

        long result = 0;
        n++;
        result = (aValue[n % 2] + eValue[n % 2] + iValue[n % 2] + oValue[n % 2] + uValue[n % 2]) % MOD;
        return (int) result;
    }
}

/*
    The Question seems intimidating, but then breaking it down will simple out things,
    See you can assume all vowels as node and edge can be considered as the constraints given in
    question.

    Now We can find the permutation for every position and then we can do.
    We can create array of size n and
    then for ith Position we can find the value for a, e, i, o, u depending upon from how
    many previous nodes we can come to that node,
    Again we can optimize the space as shown in the example.


 */