package com.interviewbit.math;

import java.util.Arrays;

/*
There are A cities numbered from 1 to A. You have already visited M cities, the indices of which are given in an array B of M integers.

If a city with index i is visited, you can visit either the city with index i-1 (i >= 2) or the city with index i+1 (i < A) if they are not already visited.
Eg: if N = 5 and array M consists of [3, 4], then in the first level of moves, you can either visit 2 or 5.

You keep visiting cities in this fashion until all the cities are not visited.
Find the number of ways in which you can visit all the cities modulo 10^9+7.

Input Format

The 1st argument given is an integer A, i.e total number of cities.
The 2nd argument given is an integer array B, where B[i] denotes ith city you already visited.
Output Format

Return an Integer X % (1e9 + 7), number of ways in which you can visit all the cities.
Constraints

1 <= A <= 1000
1 <= M <= A
1 <= B[i] <= A
For Example

Input:
    A = 5
    B = [2, 5]
Output:
    6

Explanation:
    All possible ways to visit remaining cities are :
    1. 1 -> 3 -> 4
    2. 1 -> 4 -> 3
    3. 3 -> 1 -> 4
    4. 3 -> 4 -> 1
    5. 4 -> 1 -> 3
    6. 4 -> 3 -> 1
 */
public class CityTour {
    public static void main(String[] args) {

        CityTour obj = new CityTour();
        int[] ints = {2, 5};
        int result = obj.solve(5, ints);
        System.out.println(result);

    }

    int MOD = 1000000007;
    long[] fact;

    public int solve(int A, int[] B) {

        int m = B.length;
        Arrays.sort(B);
        fact = new long[A + 1];
        calculateFactorial(A);

        int[] distances = new int[m + 1];
        distances[0] = B[0] - 1;
        for (int i = 1; i < m; i++) {
            distances[i] = B[i] - B[i - 1] - 1;
        }
        distances[m] = A - B[m - 1];
        long nFactorial = fact[A - m];

        for (int i = 0; i <= m; i++) {

            int d1 = distances[i];
            if (d1 > 1) {
                long f1 = fact[d1];
                long p1 = power(f1, MOD - 2);
                nFactorial = (nFactorial * p1) % MOD;
                if (i > 0 && i < m)
                    nFactorial = (nFactorial * power(2, d1 - 1)) % MOD;
            }

        }

        return (int) nFactorial;

    }

    public void calculateFactorial(long n) {
        fact[0] = 1;
        fact[1] = 1;

        for (int i = 2; i <= n; i++) {
            fact[i] = i * fact[i - 1];
            fact[i] %= MOD;
        }
    }

    public long power(long A, long p) {

        if (A == 0) return 0;
        if (p == 0) return 1;

        long result = power(A, p / 2);
        result = (result * result) % MOD;

        if (p % 2 == 1) {
            result = (result * A) % MOD;
        }
        return result % MOD;
    }
}

/*

    There is nothing in this question as well.
    Once you understand this question properly coding is nothing.


    See if there are n places and k places are visited then remaining n - k
    by default can be visited in total (n - k)! ways.


I had a hard time wrapping my head around this for a while myself,
but I think the best way to look at it is this.
Imagine you have some simple set like {a,a,a,b},
so that you know how many distinct permutations there are:
{aaab,aaba,abaa,baaa} thus 4. We can easily use the sticker method mentioned to see that we have:
{a1a2a3b,a1a3a2b,a2a1a3b,a2a3a1b,a3a1a2b,a3a2a1b} thus 6 permutations/distinct permutation,
that is 6 permutations per distinct permutation we wouldn't be able to distinguish if we removed the stickers.
Thus, 4distinct permutations×6(permutations/distinct permutation)=24permutations,
i.e. the number of permutations you get by distinguishing each of the objects in your set.

Read this if you want to know why there is divide by n1! * n2!.
https://math.stackexchange.com/questions/119044/what-is-the-proof-of-permutations-of-similar-objects

 */
