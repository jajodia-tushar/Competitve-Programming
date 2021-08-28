package com.interviewbit.math;

import java.util.Arrays;

/*
Given a string, find the rank of the string amongst its permutations sorted lexicographically.
Assume that no characters are repeated.

Example :

Input : 'acb'
Output : 2

The order permutations with letters 'a', 'c', and 'b' :
abc
acb
bac
bca
cab
cba
The answer might not fit in an integer, so return your answer % 1000003
 */
public class SortedPermutationRank {

    int[] fact;
    char[] originalArray;
    int MOD = 1000003;

    public static void main(String[] args) {

        SortedPermutationRank obj = new SortedPermutationRank();
        int result = obj.findRank("ZCSFLVHXRYJQKWABGT");
        System.out.println(result);
    }

    public int findRank(String A) {

        int n = A.length();
        fact = new int[n + 1];
        calculateFactorial(fact, n);
        originalArray = A.toCharArray();
        Arrays.sort(originalArray);
        long count = 1;

        for (int i = 0; i < n; i++) {
            int previousPermutation = fact[n - i - 1];
            char ch = A.charAt(i);
            int smallerChar = getNumberOfCharacterSmallerThan(ch);
            count = (count + (previousPermutation * smallerChar)) % MOD;
            // System.out.println("Count -> "+  count);
        }
        return (int) (count % MOD);
    }


    public int getNumberOfCharacterSmallerThan(char ch) {
        int n = originalArray.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            char currentChar = originalArray[i];
            if (currentChar != '$') {
                if (currentChar < ch) count++;
                else if (currentChar == ch) {
                    originalArray[i] = '$';
                } else {
                    break;
                }
            }
        }
        return count;
    }

    // May need to Check overflow.
    public void calculateFactorial(int[] fact, int n) {
        fact[0] = 1;
        fact[1] = 1;
        for (int i = 2; i <= n; i++) {
            fact[i] = (i * fact[i - 1]) % MOD;
        }
    }
}

/*

   If you look properly in this question you will be able to solve this one without need of anything.
   Just remember if there are n character then there can be n! ways to arrange these numbers.
   What we will do is we will start from count = 1 and then try to add the number of permutations
   that we know will occur previously
   for eg we are give the string CBAD.

   then the first character is C we see that there are two characters that are smaller than C --> [ 'A','B' ] (On right side)
   Now the total permutation possible with A as first character is 3! (n - 1)!
   and so is the case with character B.

   So we will need to at least the permutation will be greater than 1 + 2 * 3!
   now we move forward
   We get B and there is only 1 character that is smaller than B ---> ['A'] ( on right)
   and permutation with A as starting after C is ( we are looking for permutation for CA__ as C is already attached)
   it would be (n - 2)!
   so we need at least 1 + 2 * 3! + 1 * 2!

   we move on this way till last.

   now to find the number of character on right which are smaller than current character we can use various techniques.

   This Process works because there is no repeated characters.
 */