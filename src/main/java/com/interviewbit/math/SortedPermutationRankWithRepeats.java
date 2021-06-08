package com.interviewbit.math;

import java.util.HashMap;

/*
Given a string, find the rank of the string amongst its permutations sorted lexicographically.
Note that the characters might be repeated. If the characters are repeated, we need to look at the rank in unique permutations.
Look at the example for more details.

Example :

Input : 'aba'
Output : 2

The order permutations with letters 'a', 'a', and 'b' :
aab
aba
baa
The answer might not fit in an integer, so return your answer % 1000003

 NOTE: 1000003 is a prime number
NOTE: Assume the number of characters in string < 1000003
 */
public class SortedPermutationRankWithRepeats {

    int MOD = 1000003;
    int[] fact;

    public static void main(String[] args) {

        SortedPermutationRankWithRepeats obj = new SortedPermutationRankWithRepeats();
        int result = obj.findRank("bbbaaaccc");
        System.out.println(result);
    }

    public int findRank(String A) {

        int n = A.length();
        fact = new int[n + 1];
        calculateFactorial(n);

        long count = 1;

        for (int i = 0; i < n; i++) {
            char currentChar = A.charAt(i);
            HashMap<Character, Integer> map = new HashMap<>();

            long smallerCount = 0;
            for (int j = i; j < n; j++) {
                char ch = A.charAt(j);
                if (ch <= currentChar) {
                    if (ch < currentChar) smallerCount++;
                }
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
            if (map.isEmpty()) continue;
            // System.out.println(map);

            long denominator = 1;
            for (int value : map.values()) {
                denominator = (denominator * fact[value]) % MOD;
            }

            // System.out.println("Smaller --> "+smallerCount);
            // System.out.println("Denominator --> "+denominator);
            long numerator = fact[n - i - 1];
            // System.out.println("Numerator --> "+numerator);
            count = count + (smallerCount * numerator * power(denominator, MOD - 2) % MOD);
            count %= MOD;
            // System.out.println("Count --> "+ count+"\n");
        }

        return (int) (count % MOD);


    }

    public void calculateFactorial(int n) {
        fact[0] = 1;
        fact[1] = 1;
        for (int i = 2; i <= n; i++) {
            fact[i] = (i * fact[i - 1]) % MOD;
        }
    }

    public long power(long A, long P) {
        if (A == 0) return 0;
        if (P == 0) return 1;

        long result = power(A, P / 2);
        result = (result * result) % MOD;

        if (P % 2 != 0)
            result = (result * A) % MOD;

        return result;
    }
}

/*
       Go and Read without Repeat first.
       But with Repeat case

       We can't simply multiple number of smaller character on right with (n - 1)!
       With repeat there won't be (n - 1)! actually.
       There will only be (n - 1)! / p1! * p2!

       where p1 and p2 are count of repeats of other character.
       Here just one thing to note is if we have
       bbbcccaaa

       when we are calculating previous permutations at first character it would be

       8! / (3! * 3! * 3!) ---> We are having 3! three times. 1 for a 1 for c and 1 for b.
       b will also have 3! . Think once carefully.

       because the first place will be occupied by the smaller character than b ( in this case a)
       so now in the eight places we can have 3b 3C and 2a.
       so permutation will be (3 * 8!/(3! * 3! * 3!)) --> don't again be confused say it should not be 2! for 2a actually there is a in the first place.

       Now at last you can't calculate division with mod so you will need fermet's little theorem

 */
